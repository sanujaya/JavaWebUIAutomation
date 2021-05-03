package com.syscolabs.qa.utils;

import com.syscolabs.qa.common.Constants;
import com.syscolab.qe.core.common.LoggerUtil;

import java.util.logging.Logger;

public class BrakesLoggerUtil extends LoggerUtil {

    public static final String LOGGER_ERROR_MESSAGE = "ERROR! ";
    public static final String LOGGER_EXCEPTION_MESSAGE = ". EXCEPTION: ";

    private BrakesLoggerUtil() {
        throw new IllegalAccessError();
    }

    public static void log(Exception e) {
        BrakesLoggerUtil.log(LOGGER_ERROR_MESSAGE + e.getMessage() + LOGGER_EXCEPTION_MESSAGE + e);
    }

    public static void log(Throwable t) {
        BrakesLoggerUtil.log(LOGGER_ERROR_MESSAGE + t);
    }

    public static void log(String msg) {
        if (Constants.IS_LOGGER_ENABLED) {
            Logger logger = Logger.getLogger("logger");
            logger.info(msg);
        }
    }
}
