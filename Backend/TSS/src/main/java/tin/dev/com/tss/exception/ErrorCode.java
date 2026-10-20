package tin.dev.com.tss.exception;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
    // System
    UNCATEGORIZED(9999, "Uncategorized exception", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(99991, "Invalid message key", HttpStatus.BAD_REQUEST),
    INVALID_USERNAME(99992, "Username must be at least 3 characters", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD(99993, "Password must be at least 8 characters", HttpStatus.BAD_REQUEST),
    INVALID_EMAIL_FORMAT(99994, "Email format is invalid", HttpStatus.BAD_REQUEST),
    INVALID_TOKEN(99995, " Invalid token", HttpStatus.BAD_REQUEST),
    // User
    UNAUTHORIZED(1001, "You do not have permission", HttpStatus.FORBIDDEN),
    USER_NOT_EXISTED(1002, "User is not existed", HttpStatus.NOT_FOUND),
    USER_EXISTED(1003, "User is existed", HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED(1004, "User is not authenticated", HttpStatus.UNAUTHORIZED),
    // Store
    STORE_NOT_EXISTED(2001, "Store is not existed", HttpStatus.NOT_FOUND),
    // Item
    ITEM_SKU_EXISTED(3001, "Sku must be unique within a single store", HttpStatus.BAD_REQUEST),
    ITEM_BARCODE_EXISTED(3002, "Barcode must be unique within a single store", HttpStatus.BAD_REQUEST),
    ITEM_NOT_EXISTED(3003, "Item is not existed", HttpStatus.NOT_FOUND),
    // Order
    ORDER_NOT_EXISTED(4001, "Order is not existed", HttpStatus.NOT_FOUND),
    // Category
    CATEGORY_NAME_EXISTED(5001, "Category name has been existed", HttpStatus.BAD_REQUEST),
    CATEGORY_NOT_EXISTED(5002, "Category is not existed", HttpStatus.NOT_FOUND),
    // Order Item
    ORDER_ITEM_NOT_EXISTED(6001, "Order item is not existed", HttpStatus.NOT_FOUND);

    int code;
    String message;
    HttpStatus httpStatus;
}
