package ch.schmid.samuel.gymEquip.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
public class AccessoryType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;

    @NotBlank(message = "Accessory type name is required")
    @Size(min = 2, max = 50, message = "Accessory type name must be between 2 and 50 characters")
    private String name;

}

//enum AccessoryType {
//    DUMBBELL,
//    BARBELL,
//    KETTLEBELL,
//    WEIGHT_PLATE,
//    GRIP_HANDLE,
//    ROPE,
//    RESISTANCE_BAND,
//    FOAM_ROLLER,
//    MAT,
//    OTHER
//}
