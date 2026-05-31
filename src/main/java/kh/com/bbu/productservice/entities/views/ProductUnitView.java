package kh.com.bbu.productservice.entities.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "product_unit_view")
@Entity
@Getter
@Setter
public class ProductUnitView {
    @Id
    private int id;
    private double qty;
    private int unitTypeId;
    private int productId;
    private double price;
    private double cost;
    private String productName;
    private String unitTypeName;

}
