package com.example.demo.repository;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class MyDataSource {

    /////pc helena , conceder permisos de usuario en la bbdd y tablas linux
//    public static DataSource getMySQLDataSource() {
//        MysqlDataSource mysqlDS = new MysqlDataSource();
//        mysqlDS.setURL("jdbc:mysql://192.168.1.25:3306/java");
//        mysqlDS.setUser("jose2");
//        mysqlDS.setPassword("1234");
//
//        return mysqlDS;
//
//    }
//////casa
    public static DataSource getMySQLDataSource() {
        MysqlDataSource mysqlDS = new MysqlDataSource();
        mysqlDS.setURL("jdbc:mysql://127.0.0.1:3306/java");
        mysqlDS.setUser("root");
        mysqlDS.setPassword("1qaz!QAZ");

        return mysqlDS;

    }

    ///// colegio
//    public static DataSource getMySQLDataSource() {
//        MysqlDataSource mysqlDS = new MysqlDataSource();
//        mysqlDS.setURL("jdbc:mysql://127.0.0.1:3306/java");
//        mysqlDS.setUser("root");
//        mysqlDS.setPassword("1234");
//
//        return mysqlDS;
//
//    }


}
