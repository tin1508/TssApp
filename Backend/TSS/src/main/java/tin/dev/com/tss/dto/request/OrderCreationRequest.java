package tin.dev.com.tss.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderCreationRequest {
    LocalDateTime orderDate;
    BigDecimal totalAmount;
    String paymentMethod;
}
