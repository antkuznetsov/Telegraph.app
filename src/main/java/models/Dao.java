package models;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kuznetsov on 04/05/2017.
 */

public class Dao {

    private static final String url = "https://api.telegra.ph/";

    JSONParser parser = new JSONParser();
    HttpClient client = HttpClientBuilder.create().build();

    public JSONObject query(String q) throws IOException, ParseException {

        String query = url + q;
        Object obj = null;

        HttpGet request = new HttpGet(query);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        String line;

        if ((line = rd.readLine()) != null) {

            obj = parser.parse(line);

        }

        return (JSONObject) obj;

    }

}
