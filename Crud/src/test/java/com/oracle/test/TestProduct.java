package com.oracle.test;

import cn.itcast.common.page.Pagination;
import com.oracle.pojo.Product;
import com.oracle.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(locations = "classpath:config/bean.xml")
public class TestProduct {

    @Autowired
    private ProductService productService;

    @Test
    public void testProduct(){

        try {
            Pagination products = productService.getProducts(null, 1, 3);

            System.out.println(products);

            List list = products.getList();
            System.out.println(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
