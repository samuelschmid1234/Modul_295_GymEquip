package samuel.schmid.gymEquip.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotNull(message = "Purchase date is required")
    private LocalDateTime purchaseDate;

    @Min(value = 0, message = "Price cannot be negative")
    private Float price;

    @NotNull(message = "Category is required")
    @ManyToOne
    private Category category;

    @Size(max = 500, message = "Comment must not exceed 500 characters")
    private String comment;

    @Size(max = 100, message = "Brand must not exceed 100 characters")
    private String brand;

    @NotNull(message = "Inventory item type is required")
    private InventoryItemType type;
}

enum InventoryItemType {
    MACHINE,
    ACCESSORY_SET
}
