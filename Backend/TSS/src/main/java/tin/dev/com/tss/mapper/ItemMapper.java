package tin.dev.com.tss.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import tin.dev.com.tss.dto.request.ItemCreationRequest;
import tin.dev.com.tss.dto.request.ItemUpdateRequest;
import tin.dev.com.tss.dto.response.ItemResponse;
import tin.dev.com.tss.entity.Item;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item toItem(ItemCreationRequest request);

    ItemResponse toItemResponse(Item item);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateItem(@MappingTarget Item item, ItemUpdateRequest request);
}
