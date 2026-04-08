package ma.enset.billingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.billingservice.model.Customer;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {

    @Id
    @GeneratedValue
    private Long id;
    private Date billingDate;
    private long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;
    @Transient // indique a JPA que cet attribut qui n'existe pas dans la base de donnee, et doit l'ignorer
    private Customer customer;


}
