package com.qamer91.Utilities;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public class SqlDBUtils {

        Connection DBConnection = null;

        public void connectToSQLDB () {
            try {
                String dbURL = "";
                String user = "";
                String pass = "";
                DBConnection = DriverManager.getConnection(dbURL, user, pass);
                if (DBConnection != null) {
                    DatabaseMetaData dm = (DatabaseMetaData) DBConnection.getMetaData();
                    System.out.println("Driver name: " + dm.getDriverName());
                    System.out.println("Driver version: " + dm.getDriverVersion());
                    System.out.println("Product name: " + dm.getDatabaseProductName());
                    System.out.println("Product version: " + dm.getDatabaseProductVersion());
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        public void insertIntoSQLDB(String TableName) throws SQLException, ClassNotFoundException {

         try {

             //Prepare SQL Statement
             PreparedStatement queryStatement = DBConnection.
                     prepareStatement("Insert into  BALADY." + TableName + "");

             queryStatement.executeQuery();
         }
         catch (SQLException e)
         {
             System.out.println("Error Executing Query");
         }
        }

        //Will use it to check that table size increased by one to
        public int getTableSize(String TableName){

            //Replace this by returning table size
            return 1;
        }

        public void closeConnection () throws SQLException {
            DBConnection.close();
        }

}
