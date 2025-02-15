package mmittal.beer.mssc_brewery_gateway.config;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Configuration
public class LocalHostRouteConfig {

    //    @Bean
//    public RouteLocator localhostRoutes(RouteLocatorBuilder routeLocatorBuilder){
//
//        System.out.println("comingggg");
//        return routeLocatorBuilder.routes()
//                .route(r -> r.path("/api/v1/beer/*")
//                        .filters(f -> f.rewritePath("/api/v1/beer(?<segment>/?.*)","/${segment}"))
//                        .uri("http://localhost:8080"))
//                .build();
//    }
    @Bean
    @Primary
    public WebClient webClient() {
        HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("beer-service", p -> p
                        .path("/api/v1/beer*", "/api/v1/beer/**", "/api/v1/beerUpc/*")
                        .uri("lb://beer-service"))
                .route("order-service", p -> p
                        .path("/api/v1/customers/**")
                        .uri("http://localhost:8081"))
                .route("inventory-service", p -> p
                        .path("/api/v1/beer/*/inventory")
                        .uri("http://localhost:8082"))
                .build();
    }

    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }

}
