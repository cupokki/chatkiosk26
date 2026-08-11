package io.github.cupokki.chatkiosk26.store.service;

import io.github.cupokki.chatkiosk26.store.repository.StoreRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreDto.DetailResponse getStoreDetail(Long id) {

    }
}
