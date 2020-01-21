import org.junit.Test;
import static java.lang.System.err;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class primarySearch {
    @Test
    public void searchFen() throws InterruptedException {
        Logining lg = new Logining();
        lg.loginingUser();
        // $("ul[class = 'app-menu'] span li").click(); //открывает пункт меню пациенты

        // $("form > div[1] > div > div[role = 'group'] > div").click(); //не ставит фильтр
        Thread.sleep(1000);
        //открытие с фильтром Первичный поиск
        open("http://192.168.1.99:5002/patients?take=50&skip=0&orderby=desc&column=create_date&lastName=&createDateFrom&createDateTo&updateDateFrom&updateDateTo&status=1&operatorId=&description=&authorId=&donorId=&birthday&patientNumber=&tcCode=");
        Thread.sleep(1000);
        String gridContent = $("b").getText();
        if (gridContent.equals("0")) {
            System.out.println("No data in grid");
        } else {
            System.out.println("Grid is contains data");
        }


    }

}
