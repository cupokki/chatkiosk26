package io.github.cupokki.chatkiosk26.store.repository;

import io.github.cupokki.chatkiosk26.store.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}

