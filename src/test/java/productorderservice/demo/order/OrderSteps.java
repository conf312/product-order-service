package productorderservice.demo.order;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;
import productorderservice.demo.order.service.CreateOrderRequest;

public class OrderSteps {
    public static ExtractableResponse<Response> 상품주문요청(CreateOrderRequest request) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/orders")
                .then()
                .log().all().extract();
    }

    public static CreateOrderRequest 상품주문요청_생성() {
        Long productId = 1L;
        int  quantity = 2;
        return new CreateOrderRequest(productId, quantity);
    }
}
