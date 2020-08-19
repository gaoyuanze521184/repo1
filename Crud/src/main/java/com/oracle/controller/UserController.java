package com.oracle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController  {

     @RequestMapping("/login")
         public String login(@RequestParam("uname") String uname,
                             @RequestParam("password") String password, Model model){
             System.out.println(uname +" : " +password);

             return "dashboard";
     }



}
