import services.AccountService;

import java.io.IOException;

/**
 * Created by Kuznetsov on 03/05/2017.
 */

public class Main {

    public static void main(String[] args) throws IOException {

        AccountService app = new AccountService();
        app.createAccount();

    }

}
