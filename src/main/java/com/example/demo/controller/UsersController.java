package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.UsersService;
@RestController
public class UsersController {
	
 @Autowired
 private UsersService userService;
 @Autowired
 private ProductService productService;
 @GetMapping("/auth/user/getAllProducts")
 public List<Product> getAllProducts() {
    return productService.getAll();
 }
 
 @PostMapping("/auth/admin/addproduct")
 //@PreAuthorize("hasRole('ADMIN')")
 public Product addProduct(@RequestBody Product product) {
     return productService.save(product);
 }

 @PutMapping("/auth/admin/{id}")
 //@PreAuthorize("hasRole('ADMIN')")
 public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
     return productService.update(id, product);
 }

 @DeleteMapping("/auth/admin/{id}")
 //@PreAuthorize("hasRole('ADMIN')")
 public void deleteProduct(@PathVariable int id) {
     productService.delete(id);
 }

}
