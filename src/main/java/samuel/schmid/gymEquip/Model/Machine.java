package samuel.schmid.gymEquip.Model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Machine extends InventoryItem{

    @NotBlank(message = "Serial number is required")
    @Size(max = 100, message = "Serial number must not exceed 100 characters")
    private String serialNumber;

    private LocalDateTime lastRestoration;

    private LocalDateTime nextRestoration;

    @NotNull(message = "Status is required")
    private Status status;
}
