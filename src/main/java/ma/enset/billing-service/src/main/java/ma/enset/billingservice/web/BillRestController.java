package ma.enset.billingservice.web;

import ma.enset.billingservice.entities.Bill;
import ma.enset.billingservice.feign.CustomerServiceRestClient;
import ma.enset.billingservice.feign.InventoryServiceRestClient;
import ma.enset.billingservice.model.Customer;
import ma.enset.billingservice.repository.BillRepository;
import ma.enset.billingservice.repository.ProductItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BillRestController {

    private BillRepository billRepository;
    private ProductItemRepository productRepository;
    private CustomerServiceRestClient customerServiceRestClient;
    private InventoryServiceRestClient inventoryServiceRestClient;

    public BillRestController(BillRepository billRepository, ProductItemRepository productRepository, CustomerServiceRestClient customerServiceRestClient, InventoryServiceRestClient inventoryServiceRestClient) {
        this.billRepository = billRepository;
        this.productRepository = productRepository;
        this.customerServiceRestClient = customerServiceRestClient;
        this.inventoryServiceRestClient = inventoryServiceRestClient;
    }

    @GetMapping("/bills/{id}")
    public Bill getBillById(@PathVariable Long id){
        Bill bill = billRepository.findById(id).get();
        Customer customer = customerServiceRestClient.findCustomerById(bill.getCustomerId());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(productItem -> productItem.setProduct(
                inventoryServiceRestClient.getProduct(productItem.getProductId())
        ));
        return bill;
    }

}
