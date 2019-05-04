package com.ddl.learning.controller;

import com.alibaba.fastjson.JSONObject;
import com.ddl.learning.exception.ProductNotFoundException;
import com.ddl.learning.dao.domain.Product;
import com.ddl.learning.dao.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/{id}")
    public Product getProductInfo(
            @PathVariable("id")
                    Long productId) {
        return productMapper.select(productId);
    }

//  @PutMapping("/{id}")
//  @PostMapping(consumes = "application/x-www-form-urlencoded",produces = "application/json")

    /**
     * {"id":13,
     * "name":"xxx555",
     * "price":111
     * }
     */
    @PostMapping(consumes = "application/json")
    public Product updateProductInfo(
            //@PathVariable("id")
              //      Long productId,
            @RequestBody
                    Product newProduct) {
        if(newProduct==null){
            return new Product();
        }
        Long productId=newProduct.getId();
        Product product = productMapper.select(productId);
        if (product == null) {
            throw new ProductNotFoundException(productId);
        }
        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        productMapper.update(product);
        System.out.println(JSONObject.toJSONString(product));
        return product;
    }


    @RequestMapping
    public int add(int pNum) {
        Product product = new Product();
        if (product == null) {
            throw new ProductNotFoundException(111);
        }
        for (int i = 0; i <pNum ; i++) {
            product.setId(2000-100*i);
            product.setName("yyyy-"+i);
            product.setPrice(2000-100*i);
            productMapper.insert(product);
        }
        return pNum;
    }

    @Transactional
    @PostMapping
    public Object transaction(long pid){
//      Product product = productMapper.select(pid);
        int result=productMapper.deleteById(pid);
        if (result != 0) {
            throw new RuntimeException("运行时异常...");//会回滚
        }
        System.out.println(result);
        return new Product();
    }

    @Transactional
    @PostMapping(value="/pid")
    public Object transException(long pid) throws Exception{
//      Product product = productMapper.select(pid);
        int result=productMapper.deleteById(pid);//删除不存在的id 不报错。。
        if (result != 0) {
            throw new Exception("非运行时异常...");///不回滚
        }
        System.out.println(result);
        return new Product();
    }


}