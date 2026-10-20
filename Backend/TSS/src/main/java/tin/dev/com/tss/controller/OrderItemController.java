package tin.dev.com.tss.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import tin.dev.com.tss.dto.request.OrderCreationRequest;
import tin.dev.com.tss.dto.request.OrderItemUpdateRequest;
import tin.dev.com.tss.dto.response.ApiResponse;
import tin.dev.com.tss.dto.response.OrderItemResponse;
import tin.dev.com.tss.service.OrderItemService;

@Slf4j
@RestController
@RequestMapping("/orderItems")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderItemController {
    OrderItemService orderItemService;

    @PostMapping
    ApiResponse<OrderItemResponse> createOrderItem(@RequestBody OrderCreationRequest request) {
        return ApiResponse.<OrderItemResponse>builder()
                .result(orderItemService.createOrderItem(request))
                .build();
    }

    @PutMapping("/{orderItemId}")
    ApiResponse<OrderItemResponse> updateOrderItem(
            @PathVariable Long orderItemId, @RequestBody OrderItemUpdateRequest request) {
        return ApiResponse.<OrderItemResponse>builder()
                .result(orderItemService.updateOrderItem(orderItemId, request))
                .build();
    }

    @DeleteMapping("/{orderItemId}")
    ApiResponse<String> deleteOrderItem(@PathVariable Long orderItemId) {
        orderItemService.deleteOrderItem(orderItemId);
        return ApiResponse.<String>builder()
                .result("Order Item has been deleted.")
                .build();
    }

    @GetMapping("/{orderItemId}")
    ApiResponse<OrderItemResponse> getOrderItem(@PathVariable Long orderItemId) {
        return ApiResponse.<OrderItemResponse>builder()
                .result(orderItemService.getOrderItem(orderItemId))
                .build();
    }

    @GetMapping
    ApiResponse<List<OrderItemResponse>> getOrderItems() {
        return ApiResponse.<List<OrderItemResponse>>builder()
                .result(orderItemService.getOrderItems())
                .build();
    }
}
