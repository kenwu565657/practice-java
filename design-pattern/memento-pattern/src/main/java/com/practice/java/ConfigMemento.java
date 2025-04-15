package com.practice.java;

public class ConfigMemento {
    private Config config;

    public ConfigMemento(Config config) {
        this.config = config;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }
}
