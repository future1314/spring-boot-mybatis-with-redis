package com.wooyoo.learning;

import com.wooyoo.learning.dao.domain.Product;
import com.wooyoo.learning.dao.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
        System.out.println(product);
        return product;
    }
}
