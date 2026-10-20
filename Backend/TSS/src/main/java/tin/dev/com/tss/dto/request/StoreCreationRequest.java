package tin.dev.com.tss.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StoreCreationRequest {
    @NotBlank(message = "Store name must be not blank")
    @Size(min = 2, max = 100, message = "Store name must be between 2 and 100 characters")
    String storeName;

    @NotBlank(message = "Store address must be not blank")
    @Size(max = 255, message = "Store address must not exceed 255 characters")
    String location;

    @Size(max = 100, message = "Store business hour must not exceed 100 characters")
    String businessHours;
}
