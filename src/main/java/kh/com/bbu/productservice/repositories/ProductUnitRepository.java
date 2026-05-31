package kh.com.bbu.productservice.repositories;

import kh.com.bbu.productservice.entities.ProductUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductUnitRepository extends JpaRepository<ProductUnit, Integer> {

}
