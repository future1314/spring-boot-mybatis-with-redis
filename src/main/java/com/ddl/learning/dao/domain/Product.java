package com.ddl.learning.dao.domain;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1435515995276255188L;

    private long id;
    @NotBlank(message = "name can't be null")
    private String name;
    @NotNull(message = "price 不能为空")//汉字乱码怎么处理呢
    private long price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
