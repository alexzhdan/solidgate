package org.test;

import org.api.ApiService;
import org.core.WebdriverProvider;
import org.dto.response.PageCreationResponse;
import org.dto.response.StatusResponse;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.web.PageCreationPage;
import org.web.StatusPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.core.WebdriverProvider.getWebDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertTrue;

public class PageCreationTest {

    private WebDriver driver;
    private PageCreationPage page;
    private StatusPage statusPage;
    private SoftAssert softAssert;
    private String orderId;

    @BeforeTest
    public void setup(){
        driver = getWebDriver();
        page = new PageCreationPage();
        statusPage = new StatusPage();
        softAssert = new SoftAssert();
        orderId = "923bb7e6-436f-534c-81fb-21eb8a552e55";
    }

    @AfterTest
    public void tearDown(){

        driver.close();
        softAssert.assertAll();
    }

    @Test
    public void fullFlowTest(){
        PageCreationResponse response = ApiService.getPaymentPage(orderId);
        open(response.getUrl());
        page.writeCardNumber("4067429974719265");
        page.writeCardExpiration("12/29");
        page.writeCvcCode("852");
        page.writeEmail("test@test.com");
        page.clickSubmitButton();
        softAssert.assertTrue(statusPage.isSuccessMessagePresent());
        String currency = statusPage.getCurrency().replace(".","");

        StatusResponse statusResponse = ApiService.getStatus(orderId);

        softAssert.assertTrue(currency.contains(statusResponse.getOrder().getAmount()));
        softAssert.assertEquals(statusResponse.getOrder().getStatus(), "auth_ok");
    }
}
