package com.branegy.populito;

public class UpdateExampleTool  {
/*
    public UpdateExampleTol(PopulitoConfig config) {
        super(config);
    }

    public static void main(String args[]) throws Exception {
        PopulitoConfig cfg = new PopulitoConfig();
        cfg.configFile = "x_server_name.cfg";
        cfg.tableName = "customfieldentity_map";
        cfg.outFile = "x_server_name.csv";
//        cfg.rows = 68;
        cfg.rows = 206;

        UpdateExampleTool tool = new UpdateExampleTool(cfg);
        tool.loadFields();
        tool.reorderFields();

        tool.state = new SharedState();
        final List<FieldInfo> fields = tool.fields;
        tool.state.setFields(fields);

        tool.state.values = new Object[fields.size()];
        int fieldNumber = fields.size();
        for (int i = 0; i < fields.size(); i++) {
            fields.get(i).generator.setState(tool.state);
        }

        SqlUpdateFormatter formatter = new SqlUpdateFormatter();
        // formatter.set
		tool.generateData(formatter, fieldNumber);
    }
    */
    /*
    @Override
    protected void generateData(IFormatter formatter, int fieldNumber) throws Exception {
        formatter.initialize(cfg, state);
        final LookupRecord credit_cards = (LookupRecord)getField("credit_cards").generator;
        for (LookupItem item : credit_cards.getList()) {
            formatter.startRow();

            formatter.newField("id", item.getAttributeValue("", "id") );
            formatter.newField("user_id", item.getAttributeValue("", "user_id") );

            for (int j = 0; j < fieldNumber; j++) {
                FieldInfo fieldInfo = fields.get(j);
                Function generator = fieldInfo.generator;
                try {
                    Object value = generator.nextValue();
                    state.values[j]  = value;
                    if (fields.get(j).produceOutput) {
                        formatter.newField(fieldInfo.name,value);
                    }
                } catch (Exception e) {
                    throw new Exception("Cannot generate data for field:"+fieldInfo.name, e);
                }
            }
            formatter.endRow();
        }
        formatter.commit();
    }
    */

}
