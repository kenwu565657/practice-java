package com.practice.java.group;

import com.practice.java.lang.Collection;
import com.practice.java.lang.Iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GroupStructure implements Collection<Employee, Link> {
    private String groupId;
    private String groupName;
    private Map<String, Employee> employeeMap = new ConcurrentHashMap<>();
    private Map<String, List<Link>> linkMap = new ConcurrentHashMap<>();
    private Map<String, String> invertedMap = new ConcurrentHashMap<>();

    public GroupStructure(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    @Override
    public boolean add(Employee employee) {
        return employeeMap.put(employee.getUid(), employee) != null;
    }

    @Override
    public boolean remove(Employee employee) {
        return null != employeeMap.remove(employee.getUid());
    }

    @Override
    public boolean addLink(String key, Link link) {
        invertedMap.put(link.getToId(), link.getFromId());
        if (linkMap.containsKey(key)) {
            return linkMap.get(key).add(link);
        } else {
            List<Link> linkList = new LinkedList<>();
            linkList.add(link);
            linkMap.put(key, linkList);
            return true;
        }
    }

    @Override
    public boolean removeLink(String key) {
        return null != linkMap.remove(key);
    }

    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<>() {
            HashMap<String, Integer> keyMap = new HashMap<>();
            int totalIndex = 0;
            private String fromId = groupId;
            private String toId = groupId;

            @Override
            public boolean hasNext() {
                return totalIndex < employeeMap.size();
            }

            @Override
            public Employee next() {
                List<Link> linkList = linkMap.get(toId);
                int cursorIndex = getCursorIndex(toId);

                if (null == linkList) {
                    cursorIndex = getCursorIndex(fromId);
                    linkList = linkMap.get(fromId);
                }

                while (cursorIndex > linkList.size() - 1) {
                    fromId = invertedMap.get(fromId);
                    cursorIndex = getCursorIndex(fromId);
                    linkList = linkMap.get(fromId);
                }

                Link link = linkList.get(cursorIndex);
                toId = link.getToId();
                fromId = link.getFromId();
                totalIndex++;
                return employeeMap.get(link.getToId());
            }

            private int getCursorIndex(String key) {
                int index = 0;
                if (keyMap.containsKey(key)) {
                    index = keyMap.get(key);
                    keyMap.put(key, ++index);
                } else {
                    keyMap.put(key, index);
                }
                return index;
            }
        };
    }
}
