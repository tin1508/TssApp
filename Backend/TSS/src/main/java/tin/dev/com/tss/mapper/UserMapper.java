package tin.dev.com.tss.mapper;

import org.mapstruct.*;

import tin.dev.com.tss.dto.request.RegisterStoreOwnerRequest;
import tin.dev.com.tss.dto.request.UserCreationRequest;
import tin.dev.com.tss.dto.request.UserUpdateRequest;
import tin.dev.com.tss.dto.response.UserResponse;
import tin.dev.com.tss.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    User toStoreOwner(RegisterStoreOwnerRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
