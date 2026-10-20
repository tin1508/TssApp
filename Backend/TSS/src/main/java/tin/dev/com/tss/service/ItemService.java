package tin.dev.com.tss.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import tin.dev.com.tss.dto.request.ItemCreationRequest;
import tin.dev.com.tss.dto.request.ItemUpdateRequest;
import tin.dev.com.tss.dto.response.ItemResponse;
import tin.dev.com.tss.exception.AppException;
import tin.dev.com.tss.exception.ErrorCode;
import tin.dev.com.tss.mapper.ItemMapper;
import tin.dev.com.tss.repository.ItemRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ItemService {
    ItemRepository itemRepository;
    ItemMapper itemMapper;

    public ItemResponse createItem(ItemCreationRequest request) {
        if (itemRepository.existsBySku(request.getSku())) throw new AppException(ErrorCode.ITEM_SKU_EXISTED);
        if (itemRepository.existsByBarcode(request.getBarcode()))
            throw new AppException(ErrorCode.ITEM_BARCODE_EXISTED);
        var item = itemMapper.toItem(request);

        return itemMapper.toItemResponse(itemRepository.save(item));
    }

    public ItemResponse updateItem(String itemId, ItemUpdateRequest request) {
        var item = itemRepository.findById(itemId).orElseThrow(() -> new AppException(ErrorCode.ITEM_NOT_EXISTED));
        itemMapper.updateItem(item, request);
        return itemMapper.toItemResponse(itemRepository.save(item));
    }

    public void deleteItem(String itemId) {
        itemRepository.deleteById(itemId);
    }

    public ItemResponse getItem(String itemId) {
        var item = itemRepository.findById(itemId).orElseThrow(() -> new AppException(ErrorCode.ITEM_NOT_EXISTED));
        return itemMapper.toItemResponse(item);
    }

    public List<ItemResponse> getItems() {
        return itemRepository.findAll().stream().map(itemMapper::toItemResponse).toList();
    }
}
