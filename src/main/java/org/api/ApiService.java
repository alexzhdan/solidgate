package org.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.dto.request.Order;
import org.dto.request.OrderStatusRequest;
import org.dto.request.PageCreationRequest;
import org.dto.request.PageCustomizationDTO;
import org.dto.response.PageCreationResponse;
import org.dto.response.StatusResponse;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.core.Generator.convertToJson;
import static org.core.Generator.generateSignature;

public class ApiService {

    private static final String merchant = "api_pk_64b03189_28f3_4b70_930b_0a8de99eb142";
    private static final String key = "api_sk_6fa13424_6751_45ac_a95f_c1a8113233bc";
    static {
        RestAssured.baseURI = "https://payment-page.solidgate.com/api/v1/";
    }

    public static PageCreationResponse getPaymentPage(String orderId){
        RequestSpecification requestSpecification = given()
                .header("merchant", merchant)
                .header("Signature", generateSignature(merchant, convertToJson(getPageCreationRequest(orderId)), key))
                .contentType(ContentType.JSON)
                .body(getPageCreationRequest(orderId));
        return requestSpecification.log().all().post(baseURI + "init").then().log().all().extract().response().as(PageCreationResponse.class);
    }

    public static StatusResponse getStatus(String orderId){
        OrderStatusRequest requestBody = OrderStatusRequest.builder()
                .order_id(orderId).
                build();
        RequestSpecification requestSpecification = given()
                .header("merchant", merchant)
                .header("Signature", generateSignature(merchant, convertToJson(requestBody), key))
                .contentType(ContentType.JSON)
                .body(requestBody);
        return requestSpecification.log().all().post("https://pay.solidgate.com/api/v1/" + "status").then().log().all().extract().response().as(StatusResponse.class);

    }

    public static PageCreationRequest getPageCreationRequest(String orderId){
        PageCreationRequest request = PageCreationRequest.builder()
                .order(getOrder(orderId))
                .page_customization(getPageCustomizationDto())
                .build();
        return request;
    }

    private static Order getOrder(String orderId){
        Map<String, String> metadata = new HashMap<>();
        metadata.put("coupon_code", "NY2018");
        metadata.put("partner_id", "123989");
        Order order = Order.builder()
                .amount(1020)
                .currency("EUR")
                .customerDateOfBirth("1988-11-21")
                .customerEmail("test@solidgate.com")
                .customerFirstName("Ilon")
                .customerLastName("Mask")
                .customerPhone("+10111111111")
                .failUrl("http://merchant.example/fail")
                .force3ds(false)
                .geoCity("New Castle")
                .geoCountry("USA")
                .googlePayAllowedAuthMethods(Collections.singletonList("PAY_ONLY"))
                .language("pt")
                .orderDate("2024-09-04 11:21:30")
                .order_description("Premium package")
                .order_id(orderId)
                .orderItems("item 1 x 10, item 2 x 30")
                .orderMetadata(metadata)
                .orderNumber(9)
                .type("auth")
                .retryAttempt(3)
                .settleInterval(0)
                .purchaseCountry("USA")
                .successUrl("http://merchant.example/success")
                .trafficSource("facebook")
                .website("https://solidgate.com")
                .transactionSource("main_menu").build();
        return order;
    }

    private static PageCustomizationDTO getPageCustomizationDto(){
        PageCustomizationDTO dto = PageCustomizationDTO.builder()
                .backUrl("https://solidgate.com")
                .buttonColor("#00816A")
                .buttonFontColor("#FFFFFF")
                .fontName("Open Sans")
                .public_name("Public Name")
                .isCardholderVisible(true)
                .orderDescription("Premium package")
                .orderTitle("Order Title")
                .paymentMethods(Collections.singletonList("paypal"))
                .termsUrl("https://solidgate.com/terms")
                .build();
        return dto;
    }
}
