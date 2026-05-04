package samuel.schmid.gymEquip.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import samuel.schmid.gymEquip.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}