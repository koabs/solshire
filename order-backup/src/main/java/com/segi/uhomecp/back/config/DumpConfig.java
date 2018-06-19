package com.segi.uhomecp.back.config;

import com.google.common.base.Strings;

import java.util.Map;

/**
 * Author: koabs
 * 2018/6/15.
 */
public class DumpConfig {

    private String binPath;
    private String month;
    private String exportFolder;

    public DumpConfig() {
    }

    public DumpConfig(String binPath, String month, String exportFolder) {
        this.binPath = binPath;
        this.month = month;
        this.exportFolder = exportFolder;
    }

    public static DumpConfig build(Map<String, Object> config){
        if (config == null)
            throw new RuntimeException("mysql.dump 未配置");
        DumpConfig dumpConfig = new DumpConfig();
        dumpConfig.binPath = String.valueOf(config.get("binPath"));
        dumpConfig.month = String.valueOf(config.get("month"));
        dumpConfig.exportFolder = String.valueOf(config.get("exportFolder"));
        if (Strings.isNullOrEmpty(dumpConfig.binPath))
            throw new RuntimeException("mysql.dump.binPath 未配置");
        if (Strings.isNullOrEmpty(dumpConfig.month))
            throw new RuntimeException("mysql.dump.month 未配置");
        if (Strings.isNullOrEmpty(dumpConfig.exportFolder))
            throw new RuntimeException("mysql.dump.exportFolder 未配置");

        return dumpConfig;
    }


    public String getBinPath() {
        return binPath;
    }

    public void setBinPath(String binPath) {
        this.binPath = binPath;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getExportFolder() {
        return exportFolder;
    }

    public void setExportFolder(String exportFolder) {
        this.exportFolder = exportFolder;
    }
}
