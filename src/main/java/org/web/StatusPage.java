package org.web;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class StatusPage {
    private final String amountBlock ="//div[@data-testid='status-order-price-header']//*[@data-testid='price_major']";

    public boolean isSuccessMessagePresent(){
        $(byText("Pagamento bem sucedido!")).shouldBe(Condition.visible);
        return $(byText("Pagamento bem sucedido!")).isDisplayed();
    }

    public String getCurrency(){
        return $x(amountBlock).shouldBe(Condition.visible).getText();
    }

}
