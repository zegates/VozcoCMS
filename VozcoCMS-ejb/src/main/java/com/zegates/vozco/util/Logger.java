package com.zegates.vozco.util;

import com.zegates.vozco.config.Configurations;

import java.util.logging.Level;

/**
 * Created by sandaruwan on 1/23/16.
 */
public class Logger {

    private static java.util.logging.Logger logger;

    static {
        logger = java.util.logging.Logger.getGlobal();
    }

    public static void log(String log,Level level){
        switch (Configurations.LOG_MOD){

//            case Configurations.LogMod.DEBUG :
//                logger.log(level, log);
//                break;

        }
        logger.log(level, log);
    }

}
