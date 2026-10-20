package tin.dev.com.tss.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import tin.dev.com.tss.dto.request.RegisterStoreOwnerRequest;
import tin.dev.com.tss.dto.request.StoreUpdateRequest;
import tin.dev.com.tss.dto.response.StoreResponse;
import tin.dev.com.tss.entity.Store;

@Mapper(componentModel = "spring")
public interface StoreMapper {
    Store toStore(RegisterStoreOwnerRequest request);

    StoreResponse toStoreResponse(Store store);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStore(@MappingTarget Store store, StoreUpdateRequest request);
}
