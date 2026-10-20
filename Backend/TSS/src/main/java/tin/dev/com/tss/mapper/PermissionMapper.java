package tin.dev.com.tss.mapper;

import org.mapstruct.Mapper;

import tin.dev.com.tss.dto.request.PermissionRequest;
import tin.dev.com.tss.dto.response.PermissionResponse;
import tin.dev.com.tss.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
