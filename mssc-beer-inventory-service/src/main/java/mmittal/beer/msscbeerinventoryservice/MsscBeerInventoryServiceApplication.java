package mmittal.beer.msscbeerinventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsscBeerInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsscBeerInventoryServiceApplication.class, args);
	}

}
