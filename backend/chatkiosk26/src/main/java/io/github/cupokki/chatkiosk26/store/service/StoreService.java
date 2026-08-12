package io.github.cupokki.chatkiosk26.store.service;

import io.github.cupokki.chatkiosk26.store.dto.StoreDto;
import io.github.cupokki.chatkiosk26.store.repository.StoreRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreDto getStoreDetail(Long id) {
        return null;
    }

    public StoreDto getSalesByPeriod () {
        return null;
    }

    public StoreDto getStatistics () {
        return null;
    }

    public StoreDto join() {
        return null;
    }

    public StoreDto login() {
        return null;
    }

//    public StoreDto addItem() {
//        return null;
//    }
//
//    public StoreDto updateStock() {
//        return null;
//    }
}
