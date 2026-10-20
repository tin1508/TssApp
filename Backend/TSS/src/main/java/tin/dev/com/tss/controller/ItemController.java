package tin.dev.com.tss.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import tin.dev.com.tss.dto.request.ItemCreationRequest;
import tin.dev.com.tss.dto.request.ItemUpdateRequest;
import tin.dev.com.tss.dto.response.ApiResponse;
import tin.dev.com.tss.dto.response.ItemResponse;
import tin.dev.com.tss.service.ItemService;

@Slf4j
@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ItemController {
    ItemService itemService;

    @PostMapping
    ApiResponse<ItemResponse> createItem(@RequestBody @Valid ItemCreationRequest request) {
        return ApiResponse.<ItemResponse>builder()
                .result(itemService.createItem(request))
                .build();
    }

    @PutMapping("/{itemId}")
    ApiResponse<ItemResponse> updateItem(@PathVariable String itemId, @RequestBody ItemUpdateRequest request) {
        return ApiResponse.<ItemResponse>builder()
                .result(itemService.updateItem(itemId, request))
                .build();
    }

    @DeleteMapping("/{itemId}")
    ApiResponse<String> deleteItem(@PathVariable String itemId) {
        itemService.deleteItem(itemId);
        return ApiResponse.<String>builder().result("Item has been deleted.").build();
    }

    @GetMapping
    ApiResponse<List<ItemResponse>> getItems() {
        return ApiResponse.<List<ItemResponse>>builder()
                .result(itemService.getItems())
                .build();
    }

    @GetMapping("/{itemId}")
    ApiResponse<ItemResponse> getItem(@PathVariable String itemId) {
        return ApiResponse.<ItemResponse>builder()
                .result(itemService.getItem(itemId))
                .build();
    }
}
