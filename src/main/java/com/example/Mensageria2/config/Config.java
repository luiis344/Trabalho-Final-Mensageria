package com.example.Mensageria2.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static Properties properties = new Properties();

    static {
        try(InputStream in = Config.class.getClassLoader()
                .getResourceAsStream("application.properties")){
            properties.load(in);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}