package com.ddl.learning.dao.mapper;

import com.ddl.learning.dao.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {
    Product select(
            @Param("id")
                    long id);

    void update(Product product);
    void insert(Product product);
    int  deleteById(long pid);
}
