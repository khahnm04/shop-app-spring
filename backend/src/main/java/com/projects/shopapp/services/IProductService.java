package com.projects.shopapp.services;

import com.projects.shopapp.dtos.ProductDTO;
import com.projects.shopapp.dtos.ProductImageDTO;
import com.projects.shopapp.exceptions.DataNotFoundException;
import com.projects.shopapp.models.Product;
import com.projects.shopapp.models.ProductImage;
import com.projects.shopapp.responses.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IProductService {

    Product createProduct(ProductDTO productDTO) throws Exception;

    Product getProductById(long id) throws Exception;

    Page<ProductResponse> getAllProducts(PageRequest pageRequest);

    Product updateProduct(long id, ProductDTO productDTO) throws Exception;

    void deleteProduct(long id);

    boolean existsByName(String name);

    ProductImage createProductImage(Long productId, ProductImageDTO productImageDTO) throws Exception;

}
