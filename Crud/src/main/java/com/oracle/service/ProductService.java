package com.oracle.service;

import cn.itcast.common.page.Pagination;

public interface ProductService {
    /**
     *
     * 模糊查询带分页
     *
     * @param pname
     * @param pageNo
     * @param pageSize
     * @return Pagination  就是现成的分页对象
     * @throws Exception
     */
    public Pagination getProducts(String pname,Integer pageNo,Integer pageSize)throws Exception;


}
