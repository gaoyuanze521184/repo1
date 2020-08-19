package com.oracle.serviceImpl;

import cn.itcast.common.page.Pagination;
import com.oracle.mapper.ProductMapper;
import com.oracle.pojo.Product;
import com.oracle.pojo.ProductQuery;
import com.oracle.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Pagination getProducts(String pname, Integer pageNo, Integer pageSize)  {

        StringBuilder sb = new StringBuilder();
        ProductQuery productQuery = new ProductQuery();

        ProductQuery.Criteria c = productQuery.createCriteria();

        if(pname != null && !"".equals(pname)){
            c.andPnameLike("%"+pname+"%"); //模糊查询 是Criteria
            sb.append("pname=").append(pname);
        }

        productQuery.setOrderByClause(" pid desc"); //商品的降序

        //分页
        productQuery.setPageNo(Pagination.cpn(pageNo));

        productQuery.setPageSize(pageSize);
        List<Product> products = null;
        Pagination pager = null;
        int totalCount = 0;
        //获取分页后的 数据
        try{
            products = productMapper.selectByExample(productQuery);
            System.out.println(products);
        //查询总记录数
        totalCount = productMapper.countByExample(productQuery);
        //创建pager对象 返回到页面
            System.out.println(pageNo + ": " +pageSize + ": " +totalCount);
            pager = new Pagination(productQuery.getPageNo(),productQuery.getPageSize(),totalCount,products);

        }catch (Exception e){
            System.out.println(pager);
            e.printStackTrace();
        }
        //设置 翻页路径 和 携带的参数
        String url = "/getProducts";
        System.out.println(sb.toString());
        pager.pageView(url,sb.toString());
        return pager;
    }
}
