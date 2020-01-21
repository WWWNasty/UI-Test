
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;


public class Logining {

    public void loginingUser() {
        open("http://192.168.1.99:5002/login");
        ElementsCollection rdkm_user = $$(".login-box input");
        int rdkmUserElementNumber = 0;
        final SelenideElement login = rdkm_user.get(rdkmUserElementNumber).setValue("rdkm_user");
        int adminElementNumber = 1;
        final SelenideElement password = rdkm_user.get(adminElementNumber).setValue("admin");
        $("button[type='submit']").click();
    }


}
