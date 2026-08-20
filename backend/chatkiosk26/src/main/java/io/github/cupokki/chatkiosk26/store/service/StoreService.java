package io.github.cupokki.chatkiosk26.store.service;

import io.github.cupokki.chatkiosk26.category.dto.CategoryDto;
import io.github.cupokki.chatkiosk26.menu.repository.MenuRepository;
import io.github.cupokki.chatkiosk26.category.repository.CategoryRepository;
import io.github.cupokki.chatkiosk26.store.dto.StoreDto;
import io.github.cupokki.chatkiosk26.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final CategoryRepository categoryRepository;
    private final MenuRepository menuRepository;

    public StoreDto getStoreDetail(Long id) {
        return null;
    }

    public StoreDto getStatistics () {
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
