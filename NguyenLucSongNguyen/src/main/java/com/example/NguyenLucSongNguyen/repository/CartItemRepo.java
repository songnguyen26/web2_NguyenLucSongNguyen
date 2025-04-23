package com.example.NguyenLucSongNguyen.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.NguyenLucSongNguyen.domain.CartItem;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem,Long> {
    @Query("SELECT ci FROM CartItem ci WHERE ci.cart.id =?1 AND ci.product.id = ?2")
    CartItem findCartItemByCartIdAndProductId(Long cartId,Long productId);
    @Modifying
    @Query("DELETE FROM CartItem ci WHERE ci.cart.id = ?1 AND ci.product.id = ?2")
    void deleteCartItemByCartIdAndProductId(Long cartId,Long productId);
} 
