package samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPagePopUpSuccessfulOrder {
    private final WebDriver driver;
    //Поп-ап с уведомлением об успешном оформлении
    private final By PopUpWithSuccessfulOrder = By.className("Order_ModalHeader__3FDaJ");


    public OrderPagePopUpSuccessfulOrder(WebDriver driver) {
        this.driver = driver;
    }
    public String  receivePopUpWithSuccessfulOrder(){
        return driver.findElement(PopUpWithSuccessfulOrder).getText();
    }

}
