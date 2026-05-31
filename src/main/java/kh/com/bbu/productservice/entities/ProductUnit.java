package kh.com.bbu.productservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_units")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double qty;
    private int unitTypeId;
    private int productId;
    private double price;
    private double cost;
}
