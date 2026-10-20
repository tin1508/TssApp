package tin.dev.com.tss.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import tin.dev.com.tss.dto.request.RegisterStoreOwnerRequest;
import tin.dev.com.tss.dto.request.StoreUpdateRequest;
import tin.dev.com.tss.dto.response.StoreResponse;
import tin.dev.com.tss.entity.Store;
import tin.dev.com.tss.exception.AppException;
import tin.dev.com.tss.exception.ErrorCode;
import tin.dev.com.tss.mapper.StoreMapper;
import tin.dev.com.tss.repository.StoreRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class StoreService {
    StoreRepository storeRepository;
    StoreMapper storeMapper;

    public StoreResponse createStore(RegisterStoreOwnerRequest request) {
        Store store = storeMapper.toStore(request);
        return storeMapper.toStoreResponse(storeRepository.save(store));
    }

    public StoreResponse updateStore(String id, StoreUpdateRequest request) {
        var store = storeRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.STORE_NOT_EXISTED));
        storeMapper.updateStore(store, request);
        return storeMapper.toStoreResponse(storeRepository.save(store));
    }

    public StoreResponse getStore(String id) {
        var store = storeRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.STORE_NOT_EXISTED));
        return storeMapper.toStoreResponse(store);
    }

    public List<StoreResponse> getStores() {
        return storeRepository.findAll().stream()
                .map(storeMapper::toStoreResponse)
                .toList();
    }

    public void deleteStore(String id) {
        storeRepository.deleteById(id);
    }
}
