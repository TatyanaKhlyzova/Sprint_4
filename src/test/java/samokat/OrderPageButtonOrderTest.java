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
    private static WebDriver driver;
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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    static MainPage objectMainPage = new MainPage(driver);
    static By upOrderButton = objectMainPage.getUpOrderButton();
    static By downOrderButton = objectMainPage.getDownOrderButton();

    @Parameterized.Parameters
    public static Object[][] getRegistrationOnOrderPage() {
            return new Object[][]{
                    {upOrderButton, "Кирилл", "Петров", "г.Москва ул. Мясницкая д.9", "+79123333333", "10.11.2023", "Комментари для заказа"},
                    {downOrderButton, "Варвара", "Васильева", "г.Москва ул. Ленина д.9", "+79123377332", "10.09.2023", "Оставить у дверей"},
                    {upOrderButton, "Анатолий", "Вассерман", "г.Москва ул. Лесная д.11", "+79123553353", "10.10.2023", "Нет комментраиев по заказу"},
                    {downOrderButton, "Василиса", "Премудрая", "г.Москва ул. Ленина д.13", "+79113377388", "10.12.2023", "Нужен самый красивый самокат!"},
            };
        }

        @Test
        public void registrationOnOrderPageTest() {
            MainPage objMainPage = new MainPage(driver);
            objMainPage.agreeWithCookie();
            objMainPage.clickOnButtonOrder(orderButtonMainPage);

            OrderPageForWhomScooter objForWhom = new OrderPageForWhomScooter(driver);
            objForWhom.setName(name);
            objForWhom.setSurname(surname);
            objForWhom.setAddress(address);
            objForWhom.setSubwayStation();
            objForWhom.setTelephone(telephone);
            objForWhom.clickNextButton();

            OrderPageAboutRent objAboutRent = new OrderPageAboutRent(driver);
            objAboutRent.setDate(date);
            objAboutRent.setRentalPeriod();
            objAboutRent.setColorGrey();
            objAboutRent.setComment(comment);
            objAboutRent.clickOrderButton();

            OrderPagePopUpAgreeWithOrder objAgreeWithOrder = new OrderPagePopUpAgreeWithOrder(driver);
            objAgreeWithOrder.clickYesButton();

            OrderPagePopUpSuccessfulOrder objSuccessfulOrder = new OrderPagePopUpSuccessfulOrder(driver);
            String textPopUp = objSuccessfulOrder.receivePopUpWithSuccessfulOrder();
            MatcherAssert.assertThat("Нет поп-ап окна с сообщением об успешном оформлении заказа", textPopUp, startsWith("Заказ оформлен"));

        }
       @After
    public void tearDown() {
        driver.quit();
    }

}