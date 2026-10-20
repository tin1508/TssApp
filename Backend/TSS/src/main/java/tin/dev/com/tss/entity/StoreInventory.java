package tin.dev.com.tss.entity;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "store_inventory", uniqueConstraints = @UniqueConstraint(columnNames = {"store_id", "item_id"}))
@Entity
public class StoreInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    Item item;

    @Builder.Default
    Integer stockQuantity = 0;

    BigDecimal sellingPrice;

    @Builder.Default
    Boolean isAvailable = true;

    Instant updatedAt;
}
