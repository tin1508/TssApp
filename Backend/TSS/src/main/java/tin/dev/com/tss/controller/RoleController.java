package tin.dev.com.tss.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tin.dev.com.tss.dto.request.RoleRequest;
import tin.dev.com.tss.dto.response.ApiResponse;
import tin.dev.com.tss.dto.response.RoleResponse;
import tin.dev.com.tss.service.RoleService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleController {
    RoleService roleService;

    @PostMapping
    ApiResponse<RoleResponse> createRole(@RequestBody RoleRequest request){
        return ApiResponse.<RoleResponse>builder().result(roleService.createRole(request)).build();
    }
    @GetMapping
    ApiResponse<List<RoleResponse>> getAll(){
        return ApiResponse.<List<RoleResponse>>builder().result(roleService.getAll()).build();
    }
    @DeleteMapping("/{role}")
    ApiResponse<String> delete(@PathVariable String role){
        roleService.delete(role);
        return ApiResponse.<String>builder().result("Role has been deleted.").build();
    }
}
