package kh.com.bbu.productservice.repositories;

import java.util.List;
import kh.com.bbu.productservice.entities.views.ProductUnitView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductUnitViewRepository extends JpaRepository<ProductUnitView, Integer> {
    List<ProductUnitView> findAllByProductId(int productId);
}
