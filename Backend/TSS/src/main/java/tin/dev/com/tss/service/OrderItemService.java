package tin.dev.com.tss.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import tin.dev.com.tss.dto.request.OrderCreationRequest;
import tin.dev.com.tss.dto.request.OrderItemUpdateRequest;
import tin.dev.com.tss.dto.response.OrderItemResponse;
import tin.dev.com.tss.exception.AppException;
import tin.dev.com.tss.exception.ErrorCode;
import tin.dev.com.tss.mapper.OrderItemMapper;
import tin.dev.com.tss.repository.OrderItemRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class OrderItemService {
    OrderItemRepository orderItemRepository;
    OrderItemMapper orderItemMapper;

    public OrderItemResponse createOrderItem(OrderCreationRequest request) {
        var orderItem = orderItemMapper.toOrderItem(request);
        orderItem.setTotalPrice(orderItem.getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity())));
        return orderItemMapper.toOrderItemResponse(orderItemRepository.save(orderItem));
    }

    public OrderItemResponse updateOrderItem(Long id, OrderItemUpdateRequest request) {
        var orderItem =
                orderItemRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.ORDER_ITEM_NOT_EXISTED));
        orderItemMapper.updateOrderItem(orderItem, request);
        return orderItemMapper.toOrderItemResponse(orderItemRepository.save(orderItem));
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }

    public OrderItemResponse getOrderItem(Long id) {
        var orderItem =
                orderItemRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.ORDER_ITEM_NOT_EXISTED));
        return orderItemMapper.toOrderItemResponse(orderItem);
    }

    public List<OrderItemResponse> getOrderItems() {
        return orderItemRepository.findAll().stream()
                .map(orderItemMapper::toOrderItemResponse)
                .toList();
    }
}
