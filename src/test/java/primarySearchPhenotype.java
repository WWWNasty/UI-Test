import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class primarySearchPhenotype {
    @Test
    public void searchFen() throws InterruptedException {
        //Arrange
            Arrange();
        //Act
        SelenideElement firstName = $("#first-name");
        Thread.sleep(5000);
        SelenideElement lastName = $("#last-name");
        Thread.sleep(5000);
        //�������� ������������� ���� ������ �������
        alleleFirstComplete();
        ClearNotRequiredFields();//������� �������������� �����
        lastName.setValue("");//������� �������
        firstName.setValue("��");
        $("div[data-vv-as= '���']").click();
        setInput("#gender", "�������");
        AlertOkValidation();

        //�������� ������������� ���� ������ �����
        alleleFirstComplete();//���������� ������ ������ �
        ClearNotRequiredFields();//������� �������������� �����
        lastName.setValue("First_name");
        firstName.setValue("");//������� �����
        setInput("#gender", "�������");
        AlertOkValidation();

        //�������� ������������� ���� ������ ���
        alleleFirstComplete();//���������� ������ ������ �
        ClearNotRequiredFields();//������� �������������� �����
        lastName.setValue("First_name");
        firstName.setValue("��");
        setInput("#gender", "...");
        AlertOkValidation();

        //�������� �������������� ������
        ClearNotRequiredFields();//������� �������������� �����
        $(By.id("A*firstAllele")).setValue("");
        $(By.id("A*secondAllele")).setValue("");
        AlertOkValidation();
    }

    private void AlertOkValidation() throws InterruptedException {
        $(".offset-md-2").find("span button").click();
        Thread.sleep(500);
        $(".swal2-confirm").click();
        Thread.sleep(500);
    }

    private void Arrange() throws InterruptedException {
        Logging lg = new Logging();
        lg.LoggingUser();
        Thread.sleep(1000); //���� �������� ����� ������
        //�������� ����������� ���� �������
        $("button[class='btn btn-secondary dropdown-toggle']").click();
        Thread.sleep(500);
        $(".dropdown-item").click();
        Thread.sleep(1000);
        SelenideElement lrControl = $("div[data-vv-as = '������ ������� �� ��']");
        if(!lrControl.has(cssClass("multiselect--disabled"))) {
            Thread.sleep(1000);
            lrControl.click();
            Thread.sleep(1000);
            setInput("#lrId", "...");
            Thread.sleep(1000);
        }
        Thread.sleep(1000);
        final String valueTCString = "�� ���� �������� (999)";
        SelenideElement tcControl = $("div[data-vv-as = '�������� �������� �� ��']");
        SelenideElement valueTC = $("ul div");
        boolean equals = valueTC.getText().equals(valueTCString);
        if(!tcControl.has(cssClass("multiselect--disabled")) && !equals ){
            Thread.sleep(1000);
            tcControl.click();
            Thread.sleep(1000);
            setInput("#tcId", "�� ���� ��������");
            Thread.sleep(2000);
        }
        $$("button").findBy(text("���������")).click();
        Thread.sleep(2000);
        //�������� � �������� ��������� �����
        //Todo
        // $("ul[class = 'app-menu'] span li").click(); //��������� ����� ���� ��������
        // $("form > div[1] > div > div[role = 'group'] > div").click(); //�� ������ ������
        open("http://192.168.1.99:5002/patients?take=50&skip=0&orderby=desc&column=create_date&lastName=&createDateFrom&createDateTo&updateDateFrom&updateDateTo&status=1&operatorId=&description=&authorId=&donorId=&birthday&patientNumber=&tcCode=");
        Thread.sleep(5000);
        String gridContent = $("b").getText();
        if (gridContent.equals("0")) {      //�������� ������� ������� � ������� �������
            System.out.println("No data in grid");
        } else {
            System.out.println("Grid is contains data");
            SelenideElement table = $(".table-striped");
            SelenideElement tr = table.$$("tr").get(2);
            SelenideElement td = tr.$$("td").get(0);
            SelenideElement a = td.$("a");
            a.click();
            Thread.sleep(5000);
        }
    }

    private void alleleInput(By selector, String value){
        SelenideElement InputField = $(selector);
        InputField.setValue(value);
    }

    private void alleleFirstComplete(){
        By firstAlleleA = By.id("A*firstAllele");
        By secondAlleleA = By.id("A*secondAllele");
        alleleInput(firstAlleleA, "03");
        alleleInput(secondAlleleA, "02");
    }

    private void ClearNotRequiredFields() throws InterruptedException {
        $(By.id("middle-name")).setValue("");
        Thread.sleep(1000);
        $("div[data-vv-as= '�������']").click();
        setInput("#diagnosis","");
        $("div[data-vv-as= '��� ������']").click();
        setInput("#CmvStatus","");
        $("div[data-vv-as= '������ �����']").click();
        setInput("#BloodType", "");
        $("div[data-vv-as= '����� ������']").click();
        setInput("#Rh", "");
        $(By.id("weight")).setValue("");
        $(By.id("tweetbox")).setValue("");
        //������� �������
        SelenideElement firstAlleleB = $(By.id("B*firstAllele"));
        firstAlleleB.sendKeys("\b\b\b\b\b\b");
        SelenideElement secondAlleleB = $(By.id("B*secondAllele"));
        secondAlleleB.sendKeys("\b\b\b\b\b\b");
        SelenideElement firstAlleleC = $(By.id("C*firstAllele"));
        firstAlleleC.sendKeys("\b\b\b\b\b\b");
        SelenideElement secondAlleleC = $(By.id("C*secondAllele"));
        secondAlleleC.sendKeys("\b\b\b\b\b\b");
        SelenideElement firstAlleleDRB1 = $(By.id("DRB1*firstAllele"));
        firstAlleleDRB1.sendKeys("\b\b\b\b\b\b");
        SelenideElement secondAlleleDRB1 = $(By.id("DRB1*secondAllele"));
        secondAlleleDRB1.sendKeys("\b\b\b\b\b\b");
        SelenideElement secondAlleleDQB1 = $(By.id("DQB1*secondAllele"));
        secondAlleleDQB1.sendKeys("\b\b\b\b\b\b");
        SelenideElement firstAlleleDQB1 = $(By.id("DQB1*firstAllele"));
        firstAlleleDQB1.sendKeys("\b\b\b\b\b\b");
    }

    private void setInput(String selector, String value) throws InterruptedException {
        final SelenideElement Input = $(selector);
        Thread.sleep(1000);
        Input.setValue(value);
        Thread.sleep(3000);
        Input.pressEnter();
        Thread.sleep(1000);
    }

}
