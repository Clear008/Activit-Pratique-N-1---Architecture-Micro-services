package ma.enset.invetoryservice;

import ma.enset.invetoryservice.entities.Product;
import ma.enset.invetoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InvetoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvetoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner star(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder().name("computer").price(1200.00).quantity(5).build());
            productRepository.save(Product.builder().name("screen").price(700.00).quantity(15).build());
            productRepository.save(Product.builder().name("rj-45").price(20.00).quantity(50).build());
        };
    }

}
