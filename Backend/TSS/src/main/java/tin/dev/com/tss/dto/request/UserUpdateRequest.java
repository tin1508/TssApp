package tin.dev.com.tss.dto.request;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    String username;
    String password;
    String avatarUrl;
    Boolean isActive;
    Instant updatedAt;
    List<String> roles;
}
