package com.zegates.vozco.config;

/**
 * Created by sandaruwan on 1/23/16.
 */
public class Configurations {

    public static LogMod LOG_MOD = LogMod.NO_LOG;


    public enum LogMod{
        NO_LOG,
        DEBUG,
        INFO,
        ERROR,
        ALL
    }

    public enum DBOperations{
        CREATED,
        FAIL,
        UPDATED,
        FOUND
    }

    public enum AuthenticateStatus{
        SUCCESS,
        FAIL
    }



}
