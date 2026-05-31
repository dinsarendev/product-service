package kh.com.bbu.productservice.dto.response;

import java.util.List;
import kh.com.bbu.productservice.entities.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private int id;
    private String title;
    private String description;
    private Double price;
    private Double discount;
    private String createdDate;// 12/02/2026
    private CategoryEntity category;
    private List<ProductUnitResponse> productUnitList;
}
