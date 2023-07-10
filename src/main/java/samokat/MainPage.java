package samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {
    private final WebDriver driver;
    //Кнопка согласия с куками "да все привыкли"
    private final By cookieButton = By.xpath(".//button[@id='rcc-confirm-button']");
// Вопросы и ответы из раздела "Вопросы о важном"
    //Вопрос 1
    private final By question1 = By.id("accordion__heading-0");
    //Ответ 1
    private final By answer1 = By.xpath(".//p[contains(text(),'Сутки — 400 рублей')]");
    //Вопрос 2
    private final By question2 = By.id("accordion__heading-1");
    //Ответ 2
    private final By answer2 = By.xpath(".//p[contains(text(),'Пока что у нас так: один заказ — один самокат.')]");
    //Вопрос 3
    private final By question3 = By.id("accordion__heading-2");
    //Ответ 3
    private final By answer3 = By.xpath(".//p[contains(text(),'Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая')]");
    //Вопрос 4
    private final By question4 = By.id("accordion__heading-3");
    //Ответ 4
    private final By answer4 = By.xpath(".//p[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']");
    //Вопрос 5
    private final By question5 = By.id("accordion__heading-4");
    //Ответ 5
    private final By answer5 = By.xpath(".//p[contains(text(),'Пока что нет! Но если что-то срочное')]");
    //Вопрос 6
    private final By question6 = By.id("accordion__heading-5");
    //Ответ 6
    private final By answer6 = By.xpath(".//p[contains(text(),'Самокат приезжает к вам с полной зарядкой.')]");
    //Вопрос 7
    private final By question7 = By.id("accordion__heading-6");
    //Ответ 7
    private final By answer7 = By.xpath(".//p[contains(text(),'Да, пока самокат не привезли.')]");
    //Вопрос 8
    private final By question8 = By.id("accordion__heading-7");
    //Ответ 8
    private final By answer8 = By.xpath(".//p[contains(text(),'Да, обязательно. Всем самокатов!')]");

    public MainPage(WebDriver driver) {
         this.driver = driver;
    }
//методы для проверки 1 ответа
    public void scrollToQuestion1() {
        WebElement element = driver.findElement(question1);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickQuestion1(){
        driver.findElement(question1).click();
    }

    public String getTextAnswer1(){
        return driver.findElement(answer1).getText();
    }

//методы для проверки 2 ответа
    public void scrollToQuestion2() {
        WebElement element = driver.findElement(question2);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickQuestion2(){
        driver.findElement(question2).click();
    }

    public String getTextAnswer2(){
        return driver.findElement(answer2).getText();
    }
//методы для проверки 3 ответа
    public void scrollToQuestion3() {
        WebElement element = driver.findElement(question3);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickQuestion3(){
        driver.findElement(question3).click();
    }

    public String getTextAnswer3(){
        return driver.findElement(answer3).getText();
    }
//методы для проверки 4 ответа
    public void scrollToQuestion4() {
        WebElement element = driver.findElement(question4);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickQuestion4(){
        driver.findElement(question4).click();
    }

    public String getTextAnswer4(){
        return driver.findElement(answer4).getText();
    }

//методы для проверки 5 ответа
    public void scrollToQuestion5() {
        WebElement element = driver.findElement(question5);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickQuestion5(){
        driver.findElement(question5).click();
    }

    public String getTextAnswer5(){
        return driver.findElement(answer5).getText();
    }
//методы для проверки 6 ответа
    public void scrollToQuestion6() {
        WebElement element = driver.findElement(question6);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickQuestion6(){
        driver.findElement(question6).click();
    }

    public String getTextAnswer6(){
        return driver.findElement(answer6).getText();
    }

//методы для проверки 7 ответа
    public void scrollToQuestion7() {
        WebElement element = driver.findElement(question7);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickQuestion7(){
        driver.findElement(question7).click();
    }

    public String getTextAnswer7(){
        return driver.findElement(answer7).getText();
    }
//методы для проверки 8 ответа
    public void scrollToQuestion8() {
        WebElement element = driver.findElement(question8);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickQuestion8(){
        driver.findElement(question8).click();
    }

    public String getTextAnswer8(){
        return driver.findElement(answer8).getText();
    }


// Нажать на кнопку "Заказать" (и нижнюю, и верхнюю)
    public void clickOnButtonOrder(By orderButtonMainPage){
        WebElement element = driver.findElement(orderButtonMainPage);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(orderButtonMainPage).click();
    }
// Нажать на кнопку согласия с куками "да все привыкли"
    public void agreeWithCookie(){
        driver.findElement(cookieButton).click();
    }
}




