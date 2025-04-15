package com.practice.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver {
    private int cursorIndex = 0;
    private List<ConfigMemento> mementoList = new ArrayList<>();
    private Map<String, ConfigMemento> mementoMap = new HashMap<>();

    public void append(ConfigMemento memento) {
        mementoList.add(memento);
        mementoMap.put(memento.getConfig().getVersionNumber(), memento);
        cursorIndex++;
    }

    public ConfigMemento undo() {
        if (--cursorIndex <= 0) {
            return mementoList.getFirst();
        }
        return mementoList.get(cursorIndex);
    }
    public ConfigMemento redo() {
        return mementoList.get(cursorIndex);
    }
}
