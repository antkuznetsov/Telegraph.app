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
    private int pageCount;

    public Account(String shortName, String authorName, String authorUrl, String accessToken, String authUrl) {
        this.shortName = shortName;
        this.authorName = authorName;
        this.authorUrl = authorUrl;
        this.accessToken = accessToken;
        this.authUrl = authUrl;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
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