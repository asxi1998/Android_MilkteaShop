package com.example.thandroid_milkteabooking.File;

import java.sql.Connection;

public class JDBCController {
    JDBCModel JdbcModel = new JDBCModel();

    public Connection ConnnectionData() {
        return JdbcModel.getConnectionOf();
    }
}