package samuel.schmid.gymEquip.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Category name is required")
    @Size(min = 2, max = 50, message = "Category name must be between 2 and 50 characters")
    private String name;


}

//enum Category {
//    CHEST,
//    BACK,
//    SHOULDERS,
//    ARMS,
//    LEGS,
//    CORE,
//    CARDIO,
//    FUNCTIONAL,
//    GENERAL,
//    OTHER
//}