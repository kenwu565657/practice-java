package com.practice.java.mediator;

import org.apache.ibatis.parsing.XNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DefaultSqlSession implements SqlSession {
    private Connection connection;
    private Map<String, XNode> mapperElement;
    public DefaultSqlSession(Connection connection, Map<String, XNode> mapperElement) {
        this.connection = connection;
        this.mapperElement = mapperElement;
    }

    @Override
    public <T> T selectOne(String statement) {
        try {
            XNode xNode = mapperElement.get(statement);
            PreparedStatement preparedStatement = connection.prepareStatement(xNode.);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<T> objectList = resultSetToObject(resultSet, Class.forName(xNode.getName()));
            return objectList.getFirst();
        } catch (SQLException e) {

        } catch (ClassNotFoundException e) {

        }
    }

    private <T> List<T> resultSetToObject(ResultSet resultSet, Class<?> clazz) {
        List<T> list = new ArrayList<>();
        try {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                T object = (T) clazz.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    Object value = resultSet.getObject(i);
                    String columnName = resultSetMetaData.getColumnName(i);
                    String setMethodName = "set" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1);
                    Method method;
                    if (value instanceof Timestamp) {
                        method = clazz.getMethod(setMethodName, Date.class);
                    } else {
                        method = clazz.getMethod(setMethodName, value.getClass());
                    }
                    method.invoke(object, value);
                }
                list.add(object);
            }
        } catch (SQLException e) {

        } catch (InstantiationException e) {

        } catch (IllegalAccessException e) {

        } catch (NoSuchMethodException e) {

        } catch (InvocationTargetException e) {

        }
        return list;
    }

    @Override
    public void close() {
        if (null != connection) {
            try {
                connection.close();
            } catch (SQLException e) {

            }
        }
    }
}
