package samokat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class MainPageTest {

    private WebDriver driver;

    @Before
    public void setDriver(){
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test
    public void checkEachAnswer(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.agreeWithCookie();

        objMainPage.scrollToQuestion1();
        objMainPage.clickQuestion1();
        String actualTextAnswer1 = objMainPage.getTextAnswer1();
        assertEquals("Первый ответ нужно проверить!", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",actualTextAnswer1);

        objMainPage.scrollToQuestion2();
        objMainPage.clickQuestion2();
        String actualTextAnswer2 = objMainPage.getTextAnswer2();
        assertEquals("Второй ответ нужно проверить!", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",actualTextAnswer2);

        objMainPage.scrollToQuestion3();
        objMainPage.clickQuestion3();
        String actualTextAnswer3 = objMainPage.getTextAnswer3();
        assertEquals("Третий ответ нужно проверить!", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",actualTextAnswer3);

        objMainPage.scrollToQuestion4();
        objMainPage.clickQuestion4();
        String actualTextAnswer4 = objMainPage.getTextAnswer4();
        assertEquals("Четвертый ответ нужно проверить!", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",actualTextAnswer4);

        objMainPage.scrollToQuestion5();
        objMainPage.clickQuestion5();
        String actualTextAnswer5 = objMainPage.getTextAnswer5();
        assertEquals("Пятый ответ нужно проверить!", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",actualTextAnswer5);

        objMainPage.scrollToQuestion6();
        objMainPage.clickQuestion6();
        String actualTextAnswer6 = objMainPage.getTextAnswer6();
        assertEquals("Шестой ответ нужно проверить!", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",actualTextAnswer6);

        objMainPage.scrollToQuestion7();
        objMainPage.clickQuestion7();
        String actualTextAnswer7 = objMainPage.getTextAnswer7();
        assertEquals("Седьмой ответ нужно проверить!", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",actualTextAnswer7);

        objMainPage.scrollToQuestion8();
        objMainPage.clickQuestion8();
        String actualTextAnswer8 = objMainPage.getTextAnswer8();
        assertEquals("Восьмой ответ нужно проверить!", "Да, обязательно. Всем самокатов! И Москве, и Московской области.",actualTextAnswer8);
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}