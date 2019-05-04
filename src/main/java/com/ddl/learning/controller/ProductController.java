package com.ddl.learning.controller;

import com.alibaba.fastjson.JSONObject;
import com.ddl.learning.annotation.Log;
import com.ddl.learning.exception.ProductNotFoundException;
import com.ddl.learning.dao.domain.Product;
import com.ddl.learning.dao.mapper.ProductMapper;
import com.ddl.learning.util.AjaxJson;
import com.ddl.learning.util.Constants;
import com.ddl.learning.util.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public AjaxJson updateProductInfo(
            //@PathVariable("id")
            //      Long productId,
            @RequestBody @Valid
                    Product newProduct) {
//        if(newProduct==null){
//            return new AjaxJson(Constants.failCode,Constants.failMsg,null);
//        }
        Long productId = newProduct.getId();
        Product product = productMapper.select(productId);
        if (product == null) {
            throw new ProductNotFoundException(productId);
        }
        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        productMapper.update(product);
        System.out.println(JSONObject.toJSONString(product));
        return new AjaxJson(Constants.successCode, Constants.successMsg, product);
    }

    @PostMapping(value = "update", consumes = "application/json")
    public AjaxJson updateProductInfo2(
            @RequestBody
                    Product newProduct) throws Exception {
        ValidatorUtil.validate(newProduct);//
        Long productId = newProduct.getId();
        Product product = productMapper.select(productId);
        if (product == null) {
            throw new ProductNotFoundException(productId);
        }
        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        productMapper.update(product);
        System.out.println(JSONObject.toJSONString(product));
        return new AjaxJson(Constants.successCode, Constants.successMsg, product);
    }


    @PostMapping(value = "/add", consumes = "application/x-www-form-urlencoded")
    public AjaxJson add(int pNum) {
        Product product = new Product();
        if (pNum < 1) {
            //throw new ProductNotFoundException(111);
            return new AjaxJson(Constants.failCode, Constants.failMsg, null);
        }
        for (int i = 0; i < pNum; i++) {
            product.setId(2000 - 100 * i);
            product.setName("yyyy-" + i);
            product.setPrice(2000 - 100 * i);
            productMapper.insert(product);
        }
        return new AjaxJson(Constants.successCode, Constants.successMsg, null);
    }

    @Transactional
    @PostMapping
    public Object transaction(long pid) {
//      Product product = productMapper.select(pid);
        int result = productMapper.deleteById(pid);
        if (result != 0) {
            throw new RuntimeException("运行时异常...");//会回滚
        }
        System.out.println(result);
        return new AjaxJson(Constants.successCode, Constants.successMsg, null);
    }

    @Transactional
    @PostMapping(value = "/pid")
    public Object transException(long pid) throws Exception {
//      Product product = productMapper.select(pid);
        int result = productMapper.deleteById(pid);//删除不存在的id 不报错。。
        if (result != 0) {
            throw new Exception("非运行时异常...");///不回滚
        }
        System.out.println(result);
        return new AjaxJson(Constants.successCode, Constants.successMsg, null);
    }

    /**
     * 简单方法示例
     *
     * @param hello
     * @return
     */
    @RequestMapping("/aop")
    @Log(value = "请求了aopDemo方法")
    public String aopDemo(String hello) {
        return "请求参数为：" + hello;//返回乱码？
    }

    /**
     * 不拦截日志示例
     *
     * @param hello
     * @return
     */
    @RequestMapping("/noaop")
    @Log(ignore = true)
    public String notAopDemo(String hello) {
        return "此方法不记录日志，请求参数为：" + hello;
    }


}
