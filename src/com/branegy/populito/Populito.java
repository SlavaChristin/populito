package com.branegy.populito;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.branegy.populito.formatter.FormattableFunction;
import com.branegy.populito.formatter.Formatter;
import com.branegy.populito.parser.InputParser;


public class Populito {

    public static boolean DEBUG = true;
    public static boolean INFO  = true;
    
    // protected List<FieldInfo> fields = new ArrayList<FieldInfo>();
    protected PopulitoConfig cfg;
    private  SharedState state;
    protected List<RecordListener> listeners = new ArrayList<RecordListener>();
    protected static Map<String, Class<? extends Function>> customFunctions = new HashMap<String, Class<? extends Function>>();
   
    public Populito(Formatter formatter) {
        state = new SharedState();
        state.formatter = formatter;
    }
    
    public List<FieldInfo> getFields() {
    	return state.getFields();
    }

    public void setDefaultConnection(Connection connection) {
        state.setDefaultConnection(connection);
    }

    public static Class<? extends Function> getFunction(String name) {
    	return customFunctions.get(name);
    }

    public static void registerFunction(String name, Class<? extends Function> functionClass) {
    	customFunctions.put(name, functionClass);
    }
    
    public void resetState() {
    	state.reset();
    }

    public void loadConfiguration(PopulitoConfig config) throws Exception {
        log("**** Loading configuration from "+config.configFile);
        this.cfg = config;

        final List<FieldInfo> fields = reorderFields(loadFields(config.configFile));
        
        state.setFields(fields);
        state.values = new Object[fields.size()];
        for (int i = 0; i < fields.size(); i++) {
            fields.get(i).generator.setState(state);
        }
        state.formatter.initialize(cfg, state);
        
    }

    private static List<FieldInfo> reorderFields(List<FieldInfo> fields) {
        List<FieldInfo> orderedFields = new ArrayList<FieldInfo>();
        boolean found;
        do {
            found = false;
            for (int i = 0; i < fields.size(); i++) {
                boolean hasDep = false;
                Set<String> dependencies2 = fields.get(i).dependencies;
                for (int j = 0; j < fields.size(); j++) {
                    if (i != j && dependencies2.contains(fields.get(j).name)) {
                        hasDep = true;
                        break;
                    }
                }
                if (!hasDep) {
                    found = true;
                    FieldInfo okField = fields.remove(i);
                    log("Field:" + okField.name);
                    orderedFields.add(okField);
                    break;
                }
            }
        } while (found);

        if (!fields.isEmpty()) {
            // TODO Show user the cycle
            System.out.println("There is a cycle by dependencies");
            System.exit(1);
        }
        return orderedFields;
    }

    private static List<FieldInfo> loadFields(String configFile) throws Exception {
    	List<FieldInfo> fields = new ArrayList<FieldInfo>();
        LineNumberReader reader = null;
        try {
            reader = new LineNumberReader(new FileReader(configFile));
            String input;

            InputParser inputParser = new InputParser();

            while ((input = reader.readLine()) != null) {
                input = input.trim();
                if (input.startsWith("#")) // comment
                    continue;
                
                //{
                //    
                //    .getClass().getName().
                //}
                if (input.endsWith("{")) {
                    input = input.substring(0, input.length() - 1);
                    
                    while (!input.endsWith("}")) {
                        String line = reader.readLine();
                        if (line != null && line.trim().startsWith("#")) {
                            continue;
                        }
                        if (line != null) {
                            input = input + " " + line.trim();
                        } else {
                            break;
                        }
                    }
                    if (input.endsWith("}"))
                        input = input.substring(0, input.length() - 1);
                    
                    
                }
                while (input.endsWith("/")) {
                    String line = reader.readLine();
                    if (line != null && line.trim().startsWith("#")) {
                        continue;
                    }
                    input = input.substring(0, input.length() - 1);
                    if (line != null) {
                        input = input + " " + line.trim();
                    } else {
                        break;
                    }
                }
                if (input.length()==0) {
                    continue;
                }
                int index = input.indexOf(':');
                if (index<=0) {
                    throw new RuntimeException("Expected <field>:<spec> got '"+input+"'");
                }
                String field = input.substring(0, index).trim();

                int optionsIndex = field.indexOf('(');
                String options = null;
                if (optionsIndex > 0) {
                    options = field.substring(optionsIndex + 1).trim();
                    options = options.substring(0, options.length() - 1);
                    field = field.substring(0,optionsIndex);
                }

                String value = input.substring(index + 1).trim();
                log("-------------------------------------------------------------------------");
                log(INFO, field);
                log(INFO, value);
                log("-------------------------------------------------------------------------");

                FieldInfo fieldInfo = new FieldInfo();

                fieldInfo.setOptions(options);

                fieldInfo.generator = inputParser.parseExpression(value);
                fieldInfo.name = field;
                fieldInfo.dependencies = inputParser.getDependencies();
                log(field + ":" + inputParser.getDependencies());
                fieldInfo.generatorExpression = value;
                fields.add(fieldInfo);
            }
        } finally {
            if (reader!=null) 
                reader.close();
        }
        return fields;
    }

    public static void log(Boolean level, String string) {
        if (level) {
            System.out.println(string);
        }
    }

    private static void log(String string) {
        if (DEBUG) {
            System.out.println(string);
        }
    }

    public void generateData(int rows) throws Exception {
        generateData(rows, true);
    }

    public void generateData(int rows, boolean autoClose) throws Exception {
        int j;
        // log("Starting generation" + (new Date()));
        int i = 0;
        List<FieldInfo> fields = state.getFields();
        int fieldNumber = fields.size();
        try {
            for (i = 0; i < rows; i++) {
                // System.out.println("Gen "+i+" rows for "+cfg.tableName);
                state.formatter.startRow();
                for (j = 0; j < fieldNumber; j++) {
                    FieldInfo fieldInfo = fields.get(j);
                    Function generator = fieldInfo.generator;
                    try {
                        Object value = null;
                        if (fieldInfo.nullPercentage<=0) {
                            value = generator.nextValue();
                        } else if (generator.rnd.nextFloat() >= fieldInfo.nullPercentage) {
                            value = generator.nextValue();
                        }
                        state.values[j]  = value;
                        if (fields.get(j).produceOutput) {
                            Object formattedObject = value;
                            // TODO: some pieces might be Formattable
                            if (generator instanceof FormattableFunction) {
                                formattedObject = ((FormattableFunction)generator).formatValue(value);
                            }
                            state.formatter.newField(fieldInfo.name, value, formattedObject);
                        }
                    } catch (OutOfRowsException e) {
                        throw e;
                    } catch (Exception e) {
                        throw new Exception("Cannot generate data for field:"+fieldInfo.name, e);
                    }
                }
                state.formatter.endRow();
                for (RecordListener rl : listeners) {
                    rl.addRow();
                }
                if (i%200==0) {
                    commit();
                }
            }
        } catch (OutOfRowsException e) {
            System.out.println("No more rows. Total rows generated: " + i);
        }
        if (autoClose) {  
            commit();
            close();
        }
    }

    public void close() {
        if (state.formatter!=null) {
            state.formatter.close();
        }
        for (RecordListener rl : listeners) {
            rl.close();
        }
    }

    public FieldInfo getField(String name) throws Exception {
        List<FieldInfo> fields = state.getFields();
		for (FieldInfo field : fields) {
            if (field.name.equals(name)) {
                return field;
            }
        }
        throw new Exception("Field "+name+" not found");
    }

    
    public void commit() {
        if (state.getParentState()!=null) {
            Formatter parentFormatter = state.getParentState().formatter;
            parentFormatter.commit();
        }
        if (state.formatter!=null) {
            state.formatter.commit();
        }
        for (RecordListener rl : listeners) {
            rl.commit();
        }
    }

    public void linkListener(Populito child, RecordListener recordListener) {
        child.state.setParentState(state);
        listeners.add(recordListener);
    }

	public Object getFieldValue(String fieldName) {
		return state.getFieldValue(fieldName);
	}

	public void setFieldValue(String fieldName, Map<String, Object> crewResourceInfo) {
		int index = state.getFieldIndex(fieldName);
		state.values[index] = crewResourceInfo;
	}

	public Random getRandom() {
		return state.rnd;
	}

}
