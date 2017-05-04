import models.Account;
import org.json.simple.parser.ParseException;
import services.AccountService;

import java.io.IOException;

import static java.lang.Thread.sleep;

/**
 * Created by Kuznetsov on 03/05/2017.
 */

public class Main {

    public static void main(String[] args) throws IOException, ParseException, InterruptedException {

        AccountService app = new AccountService();

        Account account = app.createAccount("DemoMax", "Max", "http://ya.ru");

        System.out.println(account);

        String token = account.getAccessToken();

        System.out.println(token);

        sleep(1000);

        System.out.println(app.editAccountInfo("fc2c63428bda281fd26c6391fb6792094dd2ad07d6a073d69aa5f1c935aa", "xxx", "Ant", "http://google.ru"));

    }

}
