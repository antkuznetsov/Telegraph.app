package services;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import models.Account;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kuznetsov on 28/04/2017.
 */

public class AccountService {

    private static final String url = "https://api.telegra.ph/";
    private Account account;

    JSONParser parser = new JSONParser();
    HttpClient client = HttpClientBuilder.create().build();

    public Account createAccount(String shortName, String authorName, String authorUrl) throws IOException, ParseException {

        String query = url +
                "createAccount" +
                "?short_name=" + shortName +
                "&author_name=" + authorName +
                "&author_url=" + authorUrl;

        HttpGet request = new HttpGet(query);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        if ((line = rd.readLine()) != null) {

            Object obj = parser.parse(line);

            JSONObject jsonObject = (JSONObject) obj;

            if ((Boolean) jsonObject.get("ok")) {

                JSONObject result = (JSONObject) jsonObject.get("result");

                account = new Account(
                        (String) result.get("short_name"),
                        (String) result.get("author_name"),
                        (String) result.get("author_url"),
                        (String) result.get("access_token"),
                        (String) result.get("auth_url")
                );

            } else {
                System.out.println("Неверный запрос");
            }

        }

        return account;

    }

    public Account editAccountInfo(String accessToken, String shortName, String authorName, String authorUrl) throws IOException, ParseException {

        String query = url +
                "editAccountInfo" +
                "?access_token=" + accessToken +
                "&short_name=" + shortName +
                "&author_name=" + authorName +
                "&author_url=" + authorUrl;

        System.out.println(query);

        HttpGet request = new HttpGet(query);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        if ((line = rd.readLine()) != null) {

            Object obj = parser.parse(line);

            JSONObject jsonObject = (JSONObject) obj;

            if ((Boolean) jsonObject.get("ok")) {

                JSONObject result = (JSONObject) jsonObject.get("result");

                account = new Account(
                        (String) result.get("short_name"),
                        (String) result.get("author_name"),
                        (String) result.get("author_url"),
                        (String) result.get("access_token"),
                        (String) result.get("auth_url")
                );

            } else {
                System.out.println("Неверный запрос");
                System.out.println(jsonObject);
            }

        }

        return account;
    }

    public Account getAccountInfo() {
        return null;
    }

    public String revokeAccessToken() {
        return "new_token";
    }
}