package tin.dev.com.tss.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "order_items")
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long orderItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    Item item;

    Integer quantity;
    BigDecimal price;
    BigDecimal totalPrice;

    @PrePersist
    public void calTotalPriceHelper() {
        if (this.price != null && this.quantity != null) this.totalPrice = price.multiply(BigDecimal.valueOf(quantity));
    }

    @PreUpdate
    public void calTotalPriceBeforeUpdate() {
        if (this.price != null && this.quantity != null) this.totalPrice = price.multiply(BigDecimal.valueOf(quantity));
    }
}
