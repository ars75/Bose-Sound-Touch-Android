package com.example.adityasatalkar.bosesoundtouchapi;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONObject;

import fr.arnaudguyon.xmltojsonlib.XmlToJson;
/**
 * Bose SoundTouch API
 **/
public class RestCalls {

    private static final String CACHECONTROL = "Cache-Control";
    private static final String NOCACHE = "no-cache";
    private static final String CONTENTTYPE = "Content-Type";
    private static final String APPLICATIONTYPE = "application/xml";

    public static JSONObject getEndPoint(String ipAddress, String endPoint) throws Exception {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ipAddress + ":8090/" + endPoint)
                .get()
                .addHeader(CACHECONTROL, NOCACHE)
                .build();
        Response response = client.newCall(request).execute();
        String responseString = response.body().string();
        System.out.println("get" + endPoint + " response code : " + response.code());
        XmlToJson xmlToJson = new XmlToJson.Builder(responseString).build();
        String formattedJsonString = xmlToJson.toFormattedString();
        return new JSONObject(formattedJsonString);
    }

    public static void setEndPointValue(String ipAddress, String endPoint, String value) throws Exception {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse(APPLICATIONTYPE);
        RequestBody body = RequestBody.create(mediaType, "<"+endPoint+">"+ value +"</"+endPoint+">");
        Request request = new Request.Builder()
                .url(ipAddress + ":8090/" + endPoint)
                .post(body)
                .addHeader(CONTENTTYPE, APPLICATIONTYPE)
                .addHeader(CACHECONTROL, NOCACHE)
                .build();
        Response response = client.newCall(request).execute();
        if(response.code() == 200) {
            System.out.println(endPoint + " value set at level : " + value);
        }
    }
}
