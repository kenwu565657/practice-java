package com.practice.java.group;

import com.practice.java.lang.Iterator;
import org.junit.Test;

public class GroupStructureTest {

    @Test
    public void testGroupStructure() {
        GroupStructure groupStructure = new GroupStructure("1", "Tom");
        groupStructure.add(new Employee("2", "Jack"));
        groupStructure.add(new Employee("3", "Jack"));
        groupStructure.add(new Employee("4", "Jack"));
        groupStructure.add(new Employee("5", "Jack"));
        groupStructure.add(new Employee("6", "Jack"));
        groupStructure.add(new Employee("7", "Jack"));
        groupStructure.add(new Employee("8", "Jack"));

        groupStructure.addLink("1", new Link("1", "2"));
        groupStructure.addLink("1", new Link("1", "3"));
        groupStructure.addLink("2", new Link("2", "4"));
        groupStructure.addLink("2", new Link("2", "5"));
        groupStructure.addLink("5", new Link("5", "6"));
        groupStructure.addLink("5", new Link("5", "7"));
        groupStructure.addLink("5", new Link("5", "8"));

        Iterator<Employee> iterator = groupStructure.iterator();

        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            System.out.println(employee);
        }

    }

}