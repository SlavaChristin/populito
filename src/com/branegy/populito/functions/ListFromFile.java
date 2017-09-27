package com.branegy.populito.functions;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;

public class ListFromFile extends ListFunction {

    private Function sourceFile;
    
    int pointer = 0;
    
    //public void setSourceFile(String file) {
    //    this.file = file;
    //}
    
    public void setFile(Function file) {
        sourceFile = file;
    }
    
    private List<Function> buildList() {
        try {
            String file = sourceFile.nextValue().toString();
            
            // ClassLoader classLoader = this.getClass().getClassLoader();
            InputStream is = new FileInputStream(file);
            //if (is == null) {
            //    throw new RuntimeException("Cannot find file " + file);
            //}
            LineNumberReader reader = new LineNumberReader(new InputStreamReader(is, "UTF-8"));
            String line;
            
            List<Function> result = new ArrayList<Function>();
            
            while ((line = reader.readLine()) != null) {
                result.add(new Constant(line.trim()));
            }
            reader.close();
            is.close();

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void setState(SharedState state) {
        super.setState(state);
        sourceFile.setState(state);
        setValues(buildList());
    }

}
