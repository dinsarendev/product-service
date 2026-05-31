package kh.com.bbu.productservice.services;

import java.util.List;
import kh.com.bbu.productservice.dto.request.ProductRequest;
import kh.com.bbu.productservice.dto.response.ProductResponse;
import kh.com.bbu.productservice.entities.ProductEntity;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(int id);
    void createProduct(ProductRequest req);

    void update(ProductRequest request);

    void delete(int id, ProductRequest request);
    List<ProductResponse> getAllProductByCategoryId(int id);
    ProductResponse getProductByBarcode(String barcode);
}
