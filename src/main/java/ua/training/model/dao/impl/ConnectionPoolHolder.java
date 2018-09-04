package ua.training.model.dao.impl;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.util.ResourceBundle;

public class ConnectionPoolHolder {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
    private static volatile DataSource dataSource;

    public static DataSource getDataSource() {

        if (dataSource == null) {
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
                    try {
                        Class.forName(resourceBundle.getString("db.driver"));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    ds.setUrl(resourceBundle.getString("db.host"));
                    ds.setUsername(resourceBundle.getString("db.login"));
                    ds.setPassword(resourceBundle.getString("db.password"));
                    ds.setMinIdle(Integer.parseInt(resourceBundle.getString("db.minIdle")));
                    ds.setMaxIdle(Integer.parseInt(resourceBundle.getString("db.maxIdle")));
                    ds.setMaxOpenPreparedStatements(Integer.parseInt(resourceBundle.getString("db.maxStatement")));
                    dataSource = ds;
                }
            }
        }
        return dataSource;

    }


}
