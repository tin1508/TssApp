package tin.dev.com.tss.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.FieldDefaults;
import tin.dev.com.tss.enums.OrderStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderUpdateRequest {
    LocalDateTime orderDate;
    BigDecimal totalAmount;
    String paymentMethod;
    OrderStatus orderStatus;
}
