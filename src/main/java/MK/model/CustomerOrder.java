package MK.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "customers_orders")
public class CustomerOrder {
    @Id
    @GeneratedValue
    private Long id;
    private BigDecimal payment;
    private LocalDate date;
    private int numberOfItems;
    private long productId;
    private long customerId;

    @ManyToMany(mappedBy = "customerOrders")
    private Set<Product> products;


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "customer_orders",
            joinColumns = @JoinColumn(name = "customers_order_id"),
            inverseJoinColumns = @JoinColumn(name = "cusomer_id")
    )

    private Set<Customer> customers;

}
