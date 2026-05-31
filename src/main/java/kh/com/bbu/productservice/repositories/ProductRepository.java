package kh.com.bbu.productservice.repositories;

import java.util.List;
import kh.com.bbu.productservice.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,  Integer> {
    // select * from products where category_id=1
    List<ProductEntity> findAllByCategory_Id(int categoryId);
    List<ProductEntity> findAllByCategory_IdOrderByIdDesc(int categoryId);
    ProductEntity findByBarcode(String barcode);
}
