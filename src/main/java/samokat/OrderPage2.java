package samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Страница заказ 2 "Про аренду"
public class OrderPage2 {
    private final WebDriver driver;
    //Поле "Когда привезти самокат"
    private final By dateForScooterField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Дата аренды 10 сентября 2023
    private final By dateForScooter_10_09_2023 = By.xpath(".//div[@aria-label='Choose воскресенье, 10-е сентября 2023 г.']");
    //Поле "Срок аренды"
    private final By rentalPeriodField = By.xpath(".//div[@class='Dropdown-placeholder']");
    //Вариант "Четверо суток" из выпадающего списка
    private final By rentalPeriod = By.xpath(".//div[@class='Dropdown-option' and text()='четверо суток']");
    //Цвет "серая безысходность" в поле "Цвет самоката"
    private final By colorGrey = By.xpath(".//input[@id='grey']");
    //Поле "Комментарий"
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка "Заказать" (внизу экрана)
    private final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    public OrderPage2(WebDriver driver) {
        this.driver = driver;
    }
    public void setDate(String date){
        driver.findElement(dateForScooterField).sendKeys(date);
        driver.findElement(dateForScooter_10_09_2023).click();
    }
    public void setRentalPeriod() {
        driver.findElement(rentalPeriodField).click();
        driver.findElement(rentalPeriod).click();
    }
    public void setColorGrey(){
        driver.findElement(colorGrey).click();
    }
    public void setComment(String comment){
        driver.findElement(commentField).sendKeys(comment);
    }
    public void clickOrderButton(){
        driver.findElement(orderButton).click();
    }
}
