package com.example.billyshop.comtroller;


import com.example.billyshop.domain.product.Product;
import com.example.billyshop.domain.user.User;
import com.example.billyshop.dto.*;
import com.example.billyshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdcutController {

    @Autowired
    private ProductService productService;

    //게시글 등록
    @PostMapping("/product/{user_id}")
    public void create(@RequestBody ProductSaveDto saveDto, @PathVariable Long user_id){
        productService.createProduct(saveDto, user_id);
    }

    //전체조회
    @GetMapping("/product")
    public List<Product> findAll(){
        return productService.findAll();
    }

    //상품아이디로 조회
    @GetMapping("/product/{product_id}")
    public ProductDto getProduct(@PathVariable Long product_id){
        return new ProductDto(productService.findById(product_id));
    }

    //게시물수정, 되긴되는 데 입력안한 게 다 0이 됨
    @PutMapping("/product/update/{product_id}")
    public void update(@PathVariable Long product_id, @RequestBody ProductUpdateRequestDto requestDto){
        productService.update(product_id,requestDto);
    }

    //품명조회
    @GetMapping("product/title/{title}")
    public List<ProductDto> gettitle(@PathVariable String title){
        {
            return productService.titleSearch(title);
        }
    }

    //내용으로 조회
    @GetMapping("/product/content/{content}")
    public List<ProductDto> getcontent(@PathVariable String content){
        return productService.contentSearch(content);
    }


    //등록자로 조회
    @GetMapping("/product/user/{user_id}")
    public List<ProductDto> getuser(@PathVariable Long user_id){
        return productService.userSearch(user_id);
    }

    //삭제
    @DeleteMapping("/{product_id}")
    void deleteItem(@PathVariable Long product_id){
        productService.deleteById(product_id);
    }

}
