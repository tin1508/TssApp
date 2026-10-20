package tin.dev.com.tss.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemResponse {
    String id;
    String sku;
    String itemName;
    String barcode;
    String costPrice;
    String sellingPrice;
    String stockQuantity;
}
