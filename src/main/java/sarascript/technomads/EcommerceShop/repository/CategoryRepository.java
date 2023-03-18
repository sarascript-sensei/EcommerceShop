package sarascript.technomads.EcommerceShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sarascript.technomads.EcommerceShop.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Integer> {
}
