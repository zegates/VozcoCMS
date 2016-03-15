package com.zegates.vozco.util;

import com.zegates.vozco.config.Configurations;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.logging.Level;

/**
 * Created by sandaruwan on 1/23/16.
 */
public class Logger {

    private static java.util.logging.Logger logger;
    private static Level LOG_LEVEL=Level.ALL;

    static {
        logger = java.util.logging.Logger.getGlobal();
    }

    public static void log(Level level, String log){
        if(LOG_LEVEL.equals(Level.ALL)) {
            logger.log(level, log);
        }else if(LOG_LEVEL.equals(level)){
            logger.log(level, log);
        }
    }
    public static void log(String log){
        log(Level.INFO, log);
    }

}
