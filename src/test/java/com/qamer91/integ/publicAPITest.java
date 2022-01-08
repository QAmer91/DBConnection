package com.qamer91.integ;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class publicAPITest {

    @Test
    public void dockerInteg(){

        given().when().get("https://api.publicapis.org/entries").then().assertThat().statusCode(200);
    }
}
