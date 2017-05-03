package models;

/**
 * Created by Kuznetsov on 28/04/2017.
 */

public class Account {

    private String shortName;
    private String authorName;
    private String authorUrl;
    private String accessToken;
    private String authUrl;
    private String pageCount;

    public Account(String shortName, String authorName, String authorUrl, String accessToken, String authUrl) {
        this.shortName = shortName;
        this.authorName = authorName;
        this.authorUrl = authorUrl;
        this.accessToken = accessToken;
        this.authUrl = authUrl;
    }

    @Override
    public String toString() {
        return "Account{" +
                "shortName='" + shortName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorUrl='" + authorUrl + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", authUrl='" + authUrl + '\'' +
                ", pageCount='" + pageCount + '\'' +
                '}';
    }
}