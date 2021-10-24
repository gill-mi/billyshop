package com.example.billyshop.service;

import com.example.billyshop.domain.product.Product;
import com.example.billyshop.domain.user.User;
import com.example.billyshop.dto.*;
import com.example.billyshop.repository.ProductRepository;
import com.example.billyshop.repository.UserRepository;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    public void createProduct(ProductSaveDto saveDto, Long id){
        Product uploadProduct = getPro(saveDto,id);
        Product saveProduct = productRepository.save(uploadProduct);

        /*Optional<User> user = userRepository.findById(Dto.getUser().getId());
        if(!user.isPresent()){
            throw new EntityNotFoundException(
                    "User Not Found"
            );
        }
        Product product = new Product();
        BeanUtils.copyProperties(Dto, product);
        productRepository.save(product);

         */
    }

    private Product getPro(ProductSaveDto productSaveDto, Long id){
        User user = userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당게시물이 없습니다. id" +id));
        return Product.from(
                productSaveDto.getTitle(),
                productSaveDto.getContent(),
                productSaveDto.getPrice(),
                productSaveDto.getCharge(),
                user
        );
    }

    public List<Product> findAllItems(){
        return productRepository.findAll();
    }

    public void update(Long id, ProductUpdateRequestDto requestDto){
        Product product = productRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당게시물이 없습니다. id" +id));
        product.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getPrice(), requestDto.getCharge());
        productRepository.save(product);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당게시물이 없습니다. id" +id));
    }

    //등록자로 하는 거 안됨
    public List<ProductDto> userSearch(Long user_id){
        User user = userRepository.findById(user_id).orElseThrow(()-> new IllegalArgumentException("해당게시물이 없습니다. id" +user_id));
        List<Product> productList = productRepository.findAllByUser(user);
        List<ProductDto> DtoList = new ArrayList<>();

        if(productList.isEmpty()) return DtoList;

        for(Product product : productList){
            DtoList.add(new ProductDto(product));
        }
        return DtoList;
    }


    public List<ProductDto> titleSearch(String keyword){
        List<Product> productList = productRepository.findByTitleContaining(keyword);
        List<ProductDto> DtoList = new ArrayList<>();

        if(productList.isEmpty()) return DtoList;

        for(Product product : productList){
            DtoList.add(new ProductDto(product));
        }
        return DtoList;
    }

    //By내용
    public List<ProductDto> contentSearch(String keyword){
        List<Product> productList = productRepository.findByContentContaining(keyword);
        List<ProductDto> DtoList = new ArrayList<>();

        if (productList.isEmpty()) return DtoList;

        for (Product product : productList){
            DtoList.add(new ProductDto(product));
        }
        return DtoList;
    }



}