package tin.dev.com.tss.entity;

import java.util.Set;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "stores")
@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    User owner;

    @OneToMany(mappedBy = "workingStore", fetch = FetchType.LAZY)
    Set<User> staffMembers;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    Set<Order> orders;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    Set<StoreInventory> inventories;

    String storeName;
    String storeEmail;
    String location;
    String businessHours;
    String storePicture;
}
