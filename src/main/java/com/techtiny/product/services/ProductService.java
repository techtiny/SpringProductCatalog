package com.techtiny.product.services;
import com.techtiny.product.dto.ProductRequest;
import com.techtiny.product.dto.ProductResponse;
import com.techtiny.product.model.Product;
import com.techtiny.product.repositary.ProductRepository;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

	public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }
	

	  public List<ProductResponse> getAllProducts() {
	        List<Product> products = productRepository.findAll();

	        return products.stream().map(this::mapToProductResponse).toList();
	    }

	    private ProductResponse mapToProductResponse(Product product) {
	        return ProductResponse.builder()
	                .id(product.getId())
	                .name(product.getName())
	                .description(product.getDescription())
	                .price(product.getPrice())
	                .build();
	    }
}