package com.mockito.demo;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":200,\"quantity\":3}";

	@Test
     public void jsonAssert_strictTrue_exactMatchExceptForSpaces() throws JSONException {
    	 String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":200,\"quantity\":3}";
    	 JSONAssert.assertEquals(expectedResponse, actualResponse, true);
     }
	
	@Test
    public void jsonAssert_strictFalse() throws JSONException {
   	 String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":200}";
   	 JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
	
	@Test
    public void jsonAssert_without_escapeChar() throws JSONException {
   	 String expectedResponse = "{id:1,name:Ball,price:200}";
   	 JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
