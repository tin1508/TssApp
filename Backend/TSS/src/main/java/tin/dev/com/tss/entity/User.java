package tin.dev.com.tss.entity;

import java.time.Instant;
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
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String email;

    @Column(nullable = false, unique = true)
    String username;

    String password;
    String avatarUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    Store workingStore;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Store> ownedStore;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Item> items;

    String authProvider;

    @ManyToMany
    Set<Role> roles;

    @Builder.Default
    Boolean isActive = false;

    Instant createdAt;
    Instant updatedAt;
}
