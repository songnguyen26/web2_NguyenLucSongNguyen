package com.example.NguyenLucSongNguyen.service.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.NguyenLucSongNguyen.domain.Cart;
import com.example.NguyenLucSongNguyen.domain.CartItem;
import com.example.NguyenLucSongNguyen.domain.Product;
import com.example.NguyenLucSongNguyen.dto.CartDTO;
import com.example.NguyenLucSongNguyen.dto.ProductDTO;
import com.example.NguyenLucSongNguyen.repository.CartItemRepo;
import com.example.NguyenLucSongNguyen.repository.CartRepo;
import com.example.NguyenLucSongNguyen.repository.ProductRepo;
import com.example.NguyenLucSongNguyen.service.CartService;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepo cartRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    CartItemRepo cartItemRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public CartDTO addProductToCart(Long productId, Long cartId, Integer quantity) {
        Cart cart = cartRepo.findById(cartId).orElseThrow(()-> new RuntimeException("Cart not found"));
        Product product = productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        CartItem cartItemFromDB = cartItemRepo.findCartItemByCartIdAndProductId(cartId, productId);
        if(cartItemFromDB != null){
            throw new RuntimeException("Product" + product.getProductName() +" already exists in cart");
        }
        cart.setTotalPrice(product.getSellingPrice()*quantity);
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setProductPrice(product.getSellingPrice());
        cartItem.setQuantity(quantity);
        cartItem.setDiscount(21.1);
        cartItemRepo.save(cartItem);
        CartDTO cartDTO = modelMapper.map(cart,CartDTO.class);
        List<ProductDTO> productDTOs = cart.getCartItems().stream().map(p -> modelMapper.map(p.getProduct(),ProductDTO.class) ).collect(Collectors.toList());
        cartDTO.setProducts(productDTOs);
        return cartDTO;
       
    }
    @Override
    public CartDTO getCartById(Long cartId) {
        Cart cart = cartRepo.findById(cartId).get();
        CartDTO cartDTO = modelMapper.map(cart,CartDTO.class);
        List<ProductDTO> productDTOs = cart.getCartItems().stream().map(p->modelMapper.map(p.getProduct(),ProductDTO.class)).collect(Collectors.toList());
        cartDTO.setProducts(productDTOs);
        return cartDTO;
    }
    @Override
    public String deleteCartItemByCartIdAndProductId(Long cartId, Long productId) {
        Cart cart = cartRepo.findById(cartId).get();
        CartItem cartItem = cartItemRepo.findCartItemByCartIdAndProductId(cartId, productId);
        cart.setTotalPrice(cart.getTotalPrice() - cartItem.getProduct().getSellingPrice());
        cartItemRepo.deleteCartItemByCartIdAndProductId(cartId, productId);
        return "Product " + cartItem.getProduct().getProductName() + "removed from cart";
    }
    
}
