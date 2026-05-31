package kh.com.bbu.productservice.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import kh.com.bbu.productservice.dto.request.ProductRequest;
import kh.com.bbu.productservice.dto.response.ProductResponse;
import kh.com.bbu.productservice.dto.response.ProductUnitResponse;
import kh.com.bbu.productservice.entities.ProductEntity;
import kh.com.bbu.productservice.exceptions.ApiException;
import kh.com.bbu.productservice.mappers.ProductMapper;
import kh.com.bbu.productservice.mappers.ProductUnitMapper;
import kh.com.bbu.productservice.repositories.CategoryRepository;
import kh.com.bbu.productservice.repositories.ProductRepository;
import kh.com.bbu.productservice.repositories.ProductUnitViewRepository;
import kh.com.bbu.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;
    private final ProductUnitViewRepository productUnitViewRepository;
    @Override
    public List<ProductResponse> getAllProducts() {
//        List<ProductResponse> list = new ArrayList<>();
        List<ProductEntity> productEntityList = productRepository.findAll();
//        productEntityList.forEach((data)->{
//            ProductResponse productResponse = productMapper.toResponse(data);
//            list.add(productResponse);
//        });
        return mapProductToResponseList(productEntityList);
    }

    @Override
    public ProductResponse getProductById(int id) {
        ProductEntity entity = productRepository.findById(id).orElse(null);
        if(entity == null){
            throw new ApiException("400","Product not found");
        }
        var response =  productMapper.toResponse(entity);
        response.setProductUnitList(getAllProductUnitResponse(response.getId()));
        return response;
    }

    @Override
    public void createProduct(ProductRequest req) {
        var entity = productMapper.toEntity(req);
        entity.setCategory(
            categoryRepository.findById(req.getCategoryId()).orElse(null)
        );
        productRepository.save(entity);
    }

    @Override
    public void update(ProductRequest request) {
        ProductEntity findProduct = productRepository.findById(request.getId()).orElse(null);
        if(findProduct == null){
            throw new RuntimeException("Product not found");
        }
        findProduct.setPrice(request.getPrice());
        findProduct.setDiscount(request.getDiscount());
        findProduct.setTitle(request.getTitle());
        findProduct.setDescription(request.getDescription());
        productRepository.save(findProduct);
    }

    @Override
    public void delete(int id, ProductRequest request) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductResponse> getAllProductByCategoryId(int id) {
        return mapProductToResponseList(productRepository.findAllByCategory_IdOrderByIdDesc(id));
    }

    @Override
    public ProductResponse getProductByBarcode(String barcode) {
        if(Strings.isBlank(barcode)){
            throw new ApiException("400", "Barcode is required");
        }
        var product = productRepository.findByBarcode(barcode);
        if(Objects.isNull(product)){
            throw new ApiException("400", "Product not found");
        }
        var response = productMapper.toResponse(product);
        response.setProductUnitList(getAllProductUnitResponse(response.getId()));
        return response;
    }

//    public ProductServiceImpl(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    private List<ProductResponse> mapProductToResponseList(List<ProductEntity> list){
        List<ProductResponse> responseList = new ArrayList<>();
        list.forEach((data)->{
            ProductResponse productResponse = productMapper.toResponse(data);
            responseList.add(productResponse);
        });
        return responseList;
    }

    private List<ProductUnitResponse> getAllProductUnitResponse(int productId){
        List<ProductUnitResponse> productUnitResponsesList = new ArrayList<>();
        productUnitViewRepository.findAllByProductId(productId).forEach((data)->{
            var productUnitResponse = ProductUnitMapper.toResponse(data);
            productUnitResponsesList.add(productUnitResponse);
        });
        return productUnitResponsesList;
    }
}
