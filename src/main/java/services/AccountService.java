package services;

import models.Account;

/**
 * Created by Kuznetsov on 28/04/2017.
 */

public class AccountService {

    public Account createAccount() {
        return new Account();
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