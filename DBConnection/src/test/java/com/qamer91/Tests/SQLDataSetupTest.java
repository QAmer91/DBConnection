package com.qamer91.Tests;

import com.qamer91.Utilities.MongoDBUtils;
import com.qamer91.Utilities.SqlDBUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class SQLDataSetupTest {

    SqlDBUtils dbConnection ;
    String testDataKey;

    @BeforeTest
    public void setUpTestData() throws SQLException, ClassNotFoundException {
        dbConnection = new SqlDBUtils();
        dbConnection.insertIntoSQLDB("");
    }

    @Test
    public void test() throws Exception {

        //Do whatever testing you want here

    } 

    @AfterTest
    public void deleteTestData() throws SQLException {
        dbConnection.closeConnection();
    }
}
