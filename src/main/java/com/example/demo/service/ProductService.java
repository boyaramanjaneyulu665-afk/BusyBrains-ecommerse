package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAll() { 
		return productRepository.findAll();
		}
	
   public Product save(Product p) { return productRepository.save(p); }
    
    public void delete(int id) {
    	productRepository.deleteById((long) id);
    	}
    
    public Product update(int id, Product details) {
        Product p = productRepository.findById((long) id).orElseThrow();

        p.setName(details.getName());
        p.setPrice(details.getPrice());
        return productRepository.save(p);
    }

}
