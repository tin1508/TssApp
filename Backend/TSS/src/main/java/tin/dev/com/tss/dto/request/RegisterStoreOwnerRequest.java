package tin.dev.com.tss.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterStoreOwnerRequest {
    @NotBlank(message = "Email is required")
    @Email(message = "INVALID_EMAIL_FORMAT")
    String email;

    @Size(min = 8, message = "INVALID_PASSWORD")
    String password;

    @Email(message = "INVALID_EMAIL_FORMAT")
    String storeEmail;

    @NotBlank(message = "Store name is required")
    String storeName;

    String avatarUrl;

    @NotBlank(message = "Store address must be not blank")
    @Size(max = 255, message = "Store address must not exceed 255 characters")
    String location;

    @Size(max = 100, message = "Store business hour must not exceed 100 characters")
    String businessHours;

    String storePicture;
}
