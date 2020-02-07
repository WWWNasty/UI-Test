
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;


public class Logging {

    public void LoggingUser(String loginValue, String passwordValue) throws InterruptedException {
        open("http://192.168.1.99:5002/login");
        ElementsCollection rdkm_user = $$(".login-box input");
        int rdkmUserElementNumber = 0;
        final SelenideElement login = rdkm_user.get(rdkmUserElementNumber).setValue(loginValue);
        int adminElementNumber = 1;
        final SelenideElement password = rdkm_user.get(adminElementNumber).setValue(passwordValue);
        $("button[type='submit']").click();
        Thread.sleep(1000); //ждет закрытие формы логина
    }


}
