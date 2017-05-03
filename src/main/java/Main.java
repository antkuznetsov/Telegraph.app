import org.json.simple.parser.ParseException;
import services.AccountService;

import java.io.IOException;

/**
 * Created by Kuznetsov on 03/05/2017.
 */

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        AccountService app = new AccountService();
        System.out.println(app.createAccount("DemoMax", "Max", "http://ya.ru"));

    }

}
