package tin.dev.com.tss.dto.request;

import jakarta.validation.constraints.NotBlank;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemCreationRequest {
    @NotBlank(message = "Sku must be not blank")
    String sku;

    @NotBlank(message = "Item name must be not blank")
    String itemName;

    String barcode;

    String costPrice;
    String sellingPrice;
    String stockQuantity;
}
