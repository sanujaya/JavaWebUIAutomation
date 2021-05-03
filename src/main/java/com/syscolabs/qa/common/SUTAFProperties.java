package com.syscolabs.qa.common;


import com.syscolabs.qa.utils.BrakesLoggerUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SUTAFProperties {
    //private static String defaultFilePath = System.getProperty("user.dir") + "/src/main/resources/config.properties";
    private static String defaultFilePath = "src/main/resources/config.properties";
    private static Properties properties = null;
    //private static String defaultEnvFilePath = System.getProperty("user.dir") + "/src/main/resources/" + getProperty("test.env") + "_config.properties";
    //private static Properties envProperties = null;

    private SUTAFProperties() {
    }

    private static void loadProperties() {
        properties = new Properties();
        InputStream input;
        try {
            input = new FileInputStream(defaultFilePath);
            properties.load(input);
        } catch (IOException e) {
            BrakesLoggerUtil.log(e);
        }
    }

    public static String getProperty(String key) {
        if (properties == null)
            loadProperties();

        String p = System.getProperty(key);
        return p != null ? p : properties.getProperty(key);
    }

/*    private static void loadEnvProperties() {
        envProperties = new Properties();
        InputStream input;
        try {
            input = new FileInputStream(defaultEnvFilePath);
            envProperties.load(input);
        } catch (IOException e) {
            com.syscolab.qe.core.common.LoggerUtil.logERROR(e.getMessage(), e);
        }
    }

    public static String getEnvProperty(String key) {
        if (envProperties == null)
            loadEnvProperties();

        String p = System.getProperty(key);
        return p != null ? p : envProperties.getProperty(key);
    }


 */
}
