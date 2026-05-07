package ch.schmid.samuel.gymEquip.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ch.schmid.samuel.gymEquip.Model.Category;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = {
    "spring.datasource.url=jdbc:h2:mem:category-repo-test;DB_CLOSE_DELAY=-1",
    "spring.datasource.driverClassName=org.h2.Driver",
    "spring.datasource.username=sa",
    "spring.datasource.password=",
    "spring.jpa.hibernate.ddl-auto=create-drop"
})
@Transactional
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void categoryRepositorySupportsCrudOperations() {
        Category category = new Category();
        category.setName("Strength");

        Category createdCategory = categoryRepository.save(category);
        assertThat(createdCategory.getId()).isPositive();

        Category readCategory = categoryRepository.findById(createdCategory.getId()).orElseThrow();
        assertThat(readCategory.getName()).isEqualTo("Strength");
        assertThat(categoryRepository.findAll()).extracting(Category::getName).contains("Strength");

        readCategory.setName("Updated Strength");
        Category updatedCategory = categoryRepository.save(readCategory);
        assertThat(updatedCategory.getName()).isEqualTo("Updated Strength");
        assertThat(categoryRepository.findById(updatedCategory.getId())).get().extracting(Category::getName)
                .isEqualTo("Updated Strength");

        categoryRepository.deleteById(updatedCategory.getId());
        assertThat(categoryRepository.findById(updatedCategory.getId())).isEmpty();
    }
}