package com.qamer91.Tests;

import com.qamer91.Utilities.MongoDBUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MongoDataSetupTest {

    MongoDBUtils dbConnection ;
    String testDataKey;

    @BeforeTest
    public void setUpTestData(){
        dbConnection = new MongoDBUtils("" , 0);
        testDataKey = dbConnection.createNewVisit();

    }

    @Test
    public void test() throws Exception {

        //Do whatever testing you want here

    }

    @AfterTest
    public void deleteTestData(){
        dbConnection.deleteVisit(testDataKey);
    }
}
