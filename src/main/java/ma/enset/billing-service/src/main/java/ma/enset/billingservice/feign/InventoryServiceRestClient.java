package ma.enset.billingservice.feign;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.enset.billingservice.model.Customer;
import ma.enset.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "invetory-service")
public interface InventoryServiceRestClient {
    @GetMapping("/products/{id}")
    @CircuitBreaker(name = "invetory-service", fallbackMethod = "getDefaultProduct")
    Product getProduct(@PathVariable Long id);

    default Product getDefaultProduct(Long id, Exception e) {
        return Product.builder().id(id).build();
    }

}
