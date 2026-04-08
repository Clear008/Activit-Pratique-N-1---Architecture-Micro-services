package ma.enset.billingservice;

import ma.enset.billingservice.entities.Bill;
import ma.enset.billingservice.entities.ProductItem;
import ma.enset.billingservice.repository.BillRepository;
import ma.enset.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BillRepository billRepository,
										ProductItemRepository productRepository) {
		return args -> {
			List<Long> customerIds = List.of(1L, 2L, 3L);
			List<Long> productIds = List.of(1L, 2L, 3L);
			customerIds.forEach(clientId ->{
				Bill bill = new Bill();
				bill.setBillingDate(new Date());
				bill.setCustomerId(clientId);
				billRepository.save(bill);
				productIds.forEach(productId ->{
					ProductItem productItem = new ProductItem();
					productItem.setPrice(5509.00);
					productItem.setQuantity(3);
					productItem.setProductId(productId);
					productItem.setBill(bill);
					productRepository.save(productItem);
				});
			});
		};
	}
}
