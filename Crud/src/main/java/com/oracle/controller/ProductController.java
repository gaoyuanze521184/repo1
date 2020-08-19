package com.oracle.controller;

import cn.itcast.common.page.Pagination;
import com.oracle.common.Constants;
import com.oracle.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("pager")
public class ProductController {

    @Autowired
    private ProductService productService;

     @RequestMapping(value = "/getProducts",method = RequestMethod.GET)
     public String getProducts(Model model,String pname,
                               Integer pageNo) throws Exception {

         Pagination pager = productService.getProducts(pname, pageNo, Constants.PAGE_SIZE);

         model.addAttribute("pager",pager);

         //设置包含页面
         model.addAttribute("mainPage","list.jsp");
         System.out.println(model.getAttribute("mainPage"));
         return "dashboard";
     }



}
