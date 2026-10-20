package tin.dev.com.tss.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemUpdateRequest {
    String sku;

    String itemName;

    String barcode;

    String costPrice;
    String sellingPrice;
    String stockQuantity;
}
