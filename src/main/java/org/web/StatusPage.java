package org.web;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class StatusPage {
    private String statusMessage = "//h1[@data-testid='status-title']";
    private String amountBlock ="//*[@data-testid='price_major']";

    public String getStatusMessage(){
        return $x(statusMessage).getValue();
    }
    public boolean isSuccessMessagePresent(){
        $(byText("Pagamento bem sucedido!")).shouldBe(Condition.visible);
        return $(byText("Pagamento bem sucedido!")).isDisplayed();
    }

    public String getCurrency(){
        return $x(amountBlock).getText();
    }

}
