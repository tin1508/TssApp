package tin.dev.com.tss.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import tin.dev.com.tss.dto.request.OrderCreationRequest;
import tin.dev.com.tss.dto.request.OrderItemUpdateRequest;
import tin.dev.com.tss.dto.response.OrderItemResponse;
import tin.dev.com.tss.entity.OrderItem;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItem toOrderItem(OrderCreationRequest request);

    OrderItemResponse toOrderItemResponse(OrderItem orderItem);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateOrderItem(@MappingTarget OrderItem orderItem, OrderItemUpdateRequest request);
}
