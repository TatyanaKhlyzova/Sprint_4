package samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Страница заказа 3 - поп-ап окно "Вы хотите оформить заказ?"
public class OrderPage3 {
    private final WebDriver driver;
    //Кнопка "Да"
    private final By yesButton = By.xpath(".//button[text()='Да']");


    public OrderPage3(WebDriver driver) {
        this.driver = driver;
    }
    public void clickYesButton(){
        driver.findElement(yesButton).click();
    }

}
