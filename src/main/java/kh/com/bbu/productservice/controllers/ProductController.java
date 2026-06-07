package kh.com.bbu.productservice.controllers;

import java.util.List;
import kh.com.bbu.productservice.dto.request.ProductRequest;
import kh.com.bbu.productservice.dto.response.ProductResponse;
import kh.com.bbu.productservice.exceptions.MessageResponse;
import kh.com.bbu.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<MessageResponse<List<ProductResponse>>> getAllProducts(){
        return new ResponseEntity<>(
            new MessageResponse<>(
                productService.getAllProducts(),
                true,
                "Get data products",
                "200"
            ),
            HttpStatus.OK
        );
    }
    // /api/v1/products/1
    @GetMapping("/{product-id}")
    public ResponseEntity<MessageResponse<ProductResponse>> getProductById(@PathVariable("product-id") int id){
        ProductResponse productResponse = productService.getProductById(id);
        return new ResponseEntity<>(
            new MessageResponse<>(productResponse, true,
                "Get product by id success",
                "200"
            )
            , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(
        @RequestBody ProductRequest request
    ){
        productService.createProduct(request);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> updateProduct(
        @RequestBody ProductRequest request
    ){
        productService.update(request);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(
        @PathVariable int id,
        @RequestBody ProductRequest request
    ){
        productService.delete(id, request);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/category/{category-id}")
    public ResponseEntity<?> getAllProductsByCategoryId(
        @PathVariable("category-id") int id
    ){
        return new ResponseEntity<>(
            productService.getAllProductByCategoryId(id),
            HttpStatus.OK
        );
    }

    @GetMapping("/barcode/{barcode}")
    public ResponseEntity<MessageResponse<ProductResponse>> getProductById(@PathVariable("barcode") String barcode){
        ProductResponse productResponse = productService.getProductByBarcode(barcode);
        return new ResponseEntity<>(
            new MessageResponse<>(productResponse, true,
                "Get product by barcode success",
                "200"
            )
            , HttpStatus.OK);
    }

}
