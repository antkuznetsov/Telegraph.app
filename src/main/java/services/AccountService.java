package services;

import models.Dao;
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

    private Dao dao = new Dao();
    private Account account;


    public Account createAccount(String shortName, String authorName, String authorUrl) throws IOException, ParseException {

        String q =
                "createAccount" +
                "?short_name=" + shortName +
                "&author_name=" + authorName +
                "&author_url=" + authorUrl;

        JSONObject jsonObject = dao.query(q);

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

        return account;

    }

    public Account editAccountInfo(String accessToken, String shortName, String authorName, String authorUrl) throws IOException, ParseException {

        String q =
                "editAccountInfo" +
                "?access_token=" + accessToken +
                "&short_name=" + shortName +
                "&author_name=" + authorName +
                "&author_url=" + authorUrl;

        JSONObject jsonObject = dao.query(q);

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

        return account;
    }

    public Account getAccountInfo() {
        return null;
    }

    public String revokeAccessToken() {
        return "new_token";
    }
}