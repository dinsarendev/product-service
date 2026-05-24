package kh.com.bbu.productservice.controllers;

import kh.com.bbu.productservice.dto.request.CategoryRequest;
import kh.com.bbu.productservice.exceptions.ApiException;
import kh.com.bbu.productservice.exceptions.MessageResponse;
import kh.com.bbu.productservice.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Object> createCategory(
        @RequestBody CategoryRequest request
    ){
            categoryService.createCategory(request);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getAllCategory(){
        return new ResponseEntity<>(
            categoryService.getAllCategories(),
            HttpStatus.OK
        );
    }
}
