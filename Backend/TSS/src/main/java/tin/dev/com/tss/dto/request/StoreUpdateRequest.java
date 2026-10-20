package tin.dev.com.tss.dto.request;

import jakarta.validation.constraints.Size;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StoreUpdateRequest {
    @Size(min = 2, max = 100, message = "Store name must be between 2 and 100 characters")
    String storeName;

    @Size(max = 255, message = "Store address must not exceed 255 characters")
    String location;

    String businessHours;
}
