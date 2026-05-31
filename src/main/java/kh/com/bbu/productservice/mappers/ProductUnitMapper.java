package kh.com.bbu.productservice.mappers;

import kh.com.bbu.productservice.dto.response.ProductUnitResponse;
import kh.com.bbu.productservice.entities.views.ProductUnitView;

public class ProductUnitMapper {

    public static ProductUnitResponse toResponse(ProductUnitView data){
        return ProductUnitResponse.builder()
            .id(data.getId())
            .unitTypeId(data.getUnitTypeId())
            .cost(data.getCost())
            .price(data.getPrice())
            .productId(data.getProductId())
            .qty(data.getQty())
            .productName(data.getProductName())
            .unitTypeName(data.getUnitTypeName())
            .build();
    }
}
