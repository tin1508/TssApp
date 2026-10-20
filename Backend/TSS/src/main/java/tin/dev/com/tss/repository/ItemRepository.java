package tin.dev.com.tss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tin.dev.com.tss.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
    boolean existsBySku(String sku);

    boolean existsByBarcode(String barcode);
}
