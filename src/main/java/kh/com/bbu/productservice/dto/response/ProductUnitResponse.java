package kh.com.bbu.productservice.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductUnitResponse {
    private int id;
    private double qty;
    private int unitTypeId;
    private int productId;
    private double price;
    private double cost;
    private String productName;
    private String unitTypeName;
}
