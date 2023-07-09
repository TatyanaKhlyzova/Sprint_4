package samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Страница 4 с уведомлением об успешно оформленном заказе
public class OrderPage4 {
    private final WebDriver driver;
    //Поп-ап с уведомлением об успешном оформлении
    private final By PopUpWithSuccessfulOrder = By.className("Order_ModalHeader__3FDaJ");


    public OrderPage4(WebDriver driver) {
        this.driver = driver;
    }
    public String  receivePopUpWithSuccessfulOrder(){
        return driver.findElement(PopUpWithSuccessfulOrder).getText();
    }

}
