package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utilities.AuthenticationMedunna.generateToken;

public class MedunnaBaseUrl {
    public static RequestSpecification spec;
    // Testi çalıştırdığımızda spec objesinin null gelmemesi için setup() metodunun çalıştırılması gerekir.
    // Cucumber'da her testten önce çalıştırmak istediğimiz metotları Hooks class'ı içerisine ekleriz.
    public static void setUp(){
        spec = new RequestSpecBuilder()
                .setBaseUri("https://medunna.com")
                .addHeader("Authorization", "Bearer " + generateToken())
                .setContentType(ContentType.JSON)
                .build();
    }
}
