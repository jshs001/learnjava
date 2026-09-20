package com.gjjs.gjjs1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class ObjectFrame {
    public static void saveObject(Object obj) throws Exception {

        PrintStream ps = new PrintStream(new FileOutputStream("1/src/com/gjjs/gjjs1/123.txt",true));

        Class c = obj.getClass();
        String cName = c.getSimpleName();
        ps.println("------------------"+cName+"-------------------");

        Field[] fields = c.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            String value = field.get(obj).toString();
            ps.println(name+" : "+value);
        }
        ps.close();



    }
}
