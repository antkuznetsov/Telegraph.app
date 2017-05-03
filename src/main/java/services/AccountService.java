package services;

import models.Account;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kuznetsov on 28/04/2017.
 */

public class AccountService {

    private static final String url = "https://api.telegra.ph/";

    public void createAccount() throws IOException {

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url + "createAccount?short_name=MyDemo&author_name=MyDemo");
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }

    }

    public Account editAccountInfo() {
        return new Account();
    }

    public Account getAccountInfo() {
        return new Account();
    }

    public String revokeAccessToken() {
        return "new_token";
    }
}