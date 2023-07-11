package samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPageForWhomScooter {
    private final WebDriver driver;
    //Поле "Имя"
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    //Поле "Фамилия"
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле "Адрес"
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле "Станция метро"
    private final By subwayStationField = By.xpath(".//input[@placeholder='* Станция метро']");
    //Станция метро - для изменения станции можно изменить значение value от 1 до 237
    private final By subwayStation = By.xpath(".//div[@class='select-search__select']/ul/li/button[@value='105']");
    //Поле "Телефон"
    private final By telephoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private final By nextButton = By.xpath(".//button[text()='Далее']");
    //Кнопка согласия с куками "да все привыкли"

    public OrderPageForWhomScooter(WebDriver driver) {
        this.driver = driver;
    }
    public void setName(String name){
        driver.findElement(nameField).sendKeys(name);
    }
    public void setSurname(String surname){
        driver.findElement(surnameField).sendKeys(surname);
    }
    public void setAddress(String address){
        driver.findElement(addressField).sendKeys(address);
    }
    public void setSubwayStation(){
        driver.findElement(subwayStationField).click();
        WebElement element = driver.findElement(subwayStation);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(subwayStation).click();
    }
    public void setTelephone(String telephone){
        driver.findElement(telephoneField).sendKeys(telephone);
    }
    public void clickNextButton(){
        WebElement element = driver.findElement(nextButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(nextButton).click();
    }


}
