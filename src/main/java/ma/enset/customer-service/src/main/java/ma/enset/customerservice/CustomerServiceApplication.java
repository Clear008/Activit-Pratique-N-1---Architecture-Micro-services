package ma.enset.customerservice;

import ma.enset.customerservice.config.CustomerConfigParams;
import ma.enset.customerservice.entities.Customer;
import ma.enset.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder().name("Abdelilah").email("abdelilah@gmail.com").build());
            customerRepository.save(Customer.builder().name("Yassine").email("yassine@gmail.com").build());
            customerRepository.save(Customer.builder().name("Ali").email("ali@gmail.com").build());
        };
    }
}
