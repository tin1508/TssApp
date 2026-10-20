package tin.dev.com.tss.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import tin.dev.com.tss.dto.request.OrderCreationRequest;
import tin.dev.com.tss.dto.request.OrderUpdateRequest;
import tin.dev.com.tss.dto.response.OrderResponse;
import tin.dev.com.tss.enums.OrderStatus;
import tin.dev.com.tss.exception.AppException;
import tin.dev.com.tss.exception.ErrorCode;
import tin.dev.com.tss.mapper.OrderMapper;
import tin.dev.com.tss.repository.OrderRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class OrderService {
    OrderRepository orderRepository;
    OrderMapper orderMapper;

    public OrderResponse createOrder(OrderCreationRequest request) {
        var order = orderMapper.toOrder(request);
        order.setOrderStatus(OrderStatus.PENDING);
        return orderMapper.toOrderResponse(orderRepository.save(order));
    }

    public OrderResponse updateOrder(String orderId, OrderUpdateRequest request) {
        var order = orderRepository.findById(orderId).orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_EXISTED));
        orderMapper.updateOrder(order, request);
        return orderMapper.toOrderResponse(orderRepository.save(order));
    }

    public void deleteOrder(String orderId) {
        orderRepository.deleteById(orderId);
    }

    public OrderResponse getOrder(String orderId) {
        var order = orderRepository.findById(orderId).orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_EXISTED));
        return orderMapper.toOrderResponse(order);
    }

    public List<OrderResponse> getOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toOrderResponse)
                .toList();
    }
}
