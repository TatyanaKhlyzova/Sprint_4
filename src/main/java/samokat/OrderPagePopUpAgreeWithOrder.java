package samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPagePopUpAgreeWithOrder {
    private final WebDriver driver;
    //Кнопка "Да"
    private final By yesButton = By.xpath(".//button[text()='Да']");


    public OrderPagePopUpAgreeWithOrder(WebDriver driver) {
        this.driver = driver;
    }
    public void clickYesButton(){
        driver.findElement(yesButton).click();
    }

}
