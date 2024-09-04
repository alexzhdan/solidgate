package org.web;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PageCreationPage {

    private String cardNumberInput ="//*[@id='ccnumber']";
    private String cardExpirationInput = "//input[@name='cardExpiryDate']";
    private String cvcCodeInput = "//*[@id='cvv2']";
    private String cardHolderNameInput = "//input[@name='cardHolder']";
    private String emailInput = "//input[@name='email']";
    private String submitButton = "//button[@data-testid='submit']";


    public void writeCardNumber(String cardNumber){
        $(By.xpath(cardNumberInput)).setValue(cardNumber);
    }

    public void writeCardExpiration(String cardExpiration){
        $(By.xpath(cardExpirationInput)).setValue(cardExpiration);
    }

    public void writeCvcCode(String cvcCode){
        $(By.xpath(cvcCodeInput)).setValue(cvcCode);
    }

    public void writeCardHolderName(String name){
        $(By.xpath(cardHolderNameInput)).setValue(name);
    }

    public void writeEmail(String email){
        $(By.xpath(emailInput)).setValue(email);
    }

    public void clickSubmitButton(){
        $(By.xpath(submitButton)).click();
    }

}
