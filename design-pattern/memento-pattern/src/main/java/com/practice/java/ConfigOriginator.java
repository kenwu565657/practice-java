package com.practice.java;

public class ConfigOriginator {
    private Config config;

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public ConfigMemento saveMemento() {
        return new ConfigMemento(config);
    }

    public void getMemento(ConfigMemento memento) {
        this.config = memento.getConfig();
    }
}
