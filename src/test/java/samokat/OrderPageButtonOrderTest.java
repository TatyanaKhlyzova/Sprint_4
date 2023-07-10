package samokat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.CoreMatchers.startsWith;
import org.hamcrest.MatcherAssert;



import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class OrderPageButtonOrderTest {
    private WebDriver driver;
    private final By orderButtonMainPage;
    private final String name;
    private final String surname;
    private final String address;
    private final String telephone;
    private final String date;
    private final String comment;

    public OrderPageButtonOrderTest(By orderButtonMainPage, String name, String surname, String address, String telephone, String date, String comment) {
        this.orderButtonMainPage = orderButtonMainPage;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephone = telephone;
        this.date = date;
        this.comment = comment;
    }

    @Before
    public void setDriver(){
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Parameterized.Parameters
    public static Object[][] getRegistrationOnOrderPage() {
            return new Object[][]{
                    {By.xpath(".//button[@class='Button_Button__ra12g']"), "Кирилл", "Петров", "г.Москва ул. Мясницкая д.9", "+79123333333", "10.09.2023", "Комментари для заказа"},
                    {By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM')]"), "Варвара", "Васильева", "г.Москва ул. Ленина д.9", "+79123377332", "10.09.2023", "Оставить у дверей"},
                    {By.xpath(".//button[@class='Button_Button__ra12g']"), "Анатолий", "Вассерман", "г.Москва ул. Лесная д.11", "+79123553353", "10.09.2023", "Нет комментраиев по заказу"},
                    {By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM')]"), "Василиса", "Премудрая", "г.Москва ул. Ленина д.13", "+79113377388", "10.09.2023", "Нужен самый красивый самокат!"},
            };
        }

        @Test
        public void registrationOnOrderPageTest() {
            MainPage objMainPage = new MainPage(driver);
            objMainPage.agreeWithCookie();
            objMainPage.clickOnButtonOrder(orderButtonMainPage);

            OrderPage1 objOrderPage1 = new OrderPage1(driver);
            objOrderPage1.setName(name);
            objOrderPage1.setSurname(surname);
            objOrderPage1.setAddress(address);
            objOrderPage1.setSubwayStation();
            objOrderPage1.setTelephone(telephone);
            objOrderPage1.clickNextButton();

            OrderPage2 objOrderPage2 = new OrderPage2(driver);
            objOrderPage2.setDate(date);
            objOrderPage2.setRentalPeriod();
            objOrderPage2.setColorGrey();
            objOrderPage2.setComment(comment);
            objOrderPage2.clickOrderButton();

            OrderPage3 objOrderPage3 = new OrderPage3(driver);
            objOrderPage3.clickYesButton();

            OrderPage4 objOrderPage4 = new OrderPage4(driver);
            String textPopUp = objOrderPage4.receivePopUpWithSuccessfulOrder();
            MatcherAssert.assertThat("Нет поп-ап окна с сообщением об успешном оформлении заказа", textPopUp, startsWith("Заказ оформлен"));

        }
       @After
    public void tearDown() {
        driver.quit();
    }

}