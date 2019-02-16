package com.example.adityasatalkar.bosesoundtouchapi;

import org.json.JSONObject;

public class ParseJson {

    public static String parseJson(JSONObject jsonObject, String endPoint, String actual) throws Exception{
        jsonObject = (JSONObject) jsonObject.get(endPoint);
        System.out.println(jsonObject.get(actual));
        String actualValue = jsonObject.get(actual).toString();
        System.out.println("String " + actualValue);
        return actualValue;
    }
}
