package tin.dev.com.tss.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import tin.dev.com.tss.dto.request.RegisterStoreOwnerRequest;
import tin.dev.com.tss.dto.request.StoreUpdateRequest;
import tin.dev.com.tss.dto.response.ApiResponse;
import tin.dev.com.tss.dto.response.StoreResponse;
import tin.dev.com.tss.service.StoreService;

@Slf4j
@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StoreController {
    StoreService storeService;

    @PostMapping
    ApiResponse<StoreResponse> createStore(@RequestBody @Valid RegisterStoreOwnerRequest request) {
        return ApiResponse.<StoreResponse>builder()
                .result(storeService.createStore(request))
                .build();
    }

    @PutMapping("/{storeId}")
    ApiResponse<StoreResponse> updateStore(@PathVariable String storeId, @RequestBody StoreUpdateRequest request) {
        return ApiResponse.<StoreResponse>builder()
                .result(storeService.updateStore(storeId, request))
                .build();
    }

    @GetMapping("/{storeId}")
    ApiResponse<StoreResponse> getStore(@PathVariable String storeId) {
        return ApiResponse.<StoreResponse>builder()
                .result(storeService.getStore(storeId))
                .build();
    }

    @GetMapping
    ApiResponse<List<StoreResponse>> getStores() {
        return ApiResponse.<List<StoreResponse>>builder()
                .result(storeService.getStores())
                .build();
    }

    @DeleteMapping("/{storeId}")
    ApiResponse<String> deleteStore(@PathVariable String storeId) {
        storeService.deleteStore(storeId);
        return ApiResponse.<String>builder().result("Store has been deleted.").build();
    }
}
