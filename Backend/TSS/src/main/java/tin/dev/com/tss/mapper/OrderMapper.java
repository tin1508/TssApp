package tin.dev.com.tss.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import tin.dev.com.tss.dto.request.OrderCreationRequest;
import tin.dev.com.tss.dto.request.OrderUpdateRequest;
import tin.dev.com.tss.dto.response.OrderResponse;
import tin.dev.com.tss.entity.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order toOrder(OrderCreationRequest request);

    OrderResponse toOrderResponse(Order order);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateOrder(@MappingTarget Order order, OrderUpdateRequest request);
}
