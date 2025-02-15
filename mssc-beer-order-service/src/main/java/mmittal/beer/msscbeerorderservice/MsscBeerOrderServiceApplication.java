package mmittal.beer.msscbeerorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsscBeerOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsscBeerOrderServiceApplication.class, args);
	}

}
