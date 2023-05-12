package msharma.integration;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class Reservation extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        restConfiguration().component("netty-http").host("0.0.0.0").port("8081").scheme("http").bindingMode(RestBindingMode.json)
        .enableCORS(true)
        .corsAllowCredentials(true).
        corsHeaderProperty("Access-Control-Allow-Origin","*")
        .corsHeaderProperty("Access-Control-Allow-Methods", "GET") ;
        
        rest("/api/v2")
        .get("reservation").produces("application/json").to("direct:mongodbFetch")
        .post("reservation").consumes("application/json").to("direct:newIntegration");
        
        from("direct:newIntegration").to("kamelet:mongodb-sink?hosts=localhost:27017&collection=reservation&database=integration")
           .log("Processing ${body}");
        
        from("direct:mongodbFetch").to("mongodb:integration?hosts=localhost:27017&collection=reservation&database=integration&operation=findAll");
        
        from("kamelet:timer-source?message=hello&period=20000").process(new GenerateData()).marshal().json(JsonLibrary.Jackson)
        .to("kamelet:http-sink?url=http://localhost:8081/api/v2/reservation");
    }
}
