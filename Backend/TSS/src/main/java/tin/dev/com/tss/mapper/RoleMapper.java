package tin.dev.com.tss.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import tin.dev.com.tss.dto.request.RoleRequest;
import tin.dev.com.tss.dto.response.RoleResponse;
import tin.dev.com.tss.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
