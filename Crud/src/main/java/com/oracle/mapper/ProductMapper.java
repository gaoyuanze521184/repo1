package com.oracle.mapper;

import com.oracle.pojo.Product;
import com.oracle.pojo.ProductQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ProductMapper {
    int countByExample(ProductQuery example);

    int deleteByExample(ProductQuery example);

    int deleteByPrimaryKey(Integer pid);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExampleWithRowbounds(ProductQuery example, RowBounds rowBounds);

    List<Product> selectByExample(ProductQuery example);

    Product selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductQuery example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductQuery example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}