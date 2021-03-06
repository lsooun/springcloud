package com.how2java.springcloud.controller;

import com.how2java.springcloud.pojo.Product;
import com.how2java.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RefreshScope
public class ProductController {
    @Autowired
    ProductService productService;

    @Value("${version}")
    String version;

    @GetMapping("/products")
    public String products(Model m) {
        List<Product> ps = productService.listProduct();
        m.addAttribute("ps", ps);
        m.addAttribute("version", version);

        return "products";
    }
}
