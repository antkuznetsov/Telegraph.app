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

        sleep(1000);

        System.out.println(app.editAccountInfo(account.getAccessToken(), "xxx", "Ant", "http://google.ru"));

        sleep(1000);

        System.out.println(app.getAccountInfo(account.getAccessToken()));
    }

}
