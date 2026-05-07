package ch.schmid.samuel.gymEquip.Model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Embeddable
public class Accessory {

    @NotNull(message = "Accessory type is required")
    @ManyToOne
    private AccessoryType accessoryType;

    @Min(value = 0, message = "Weight cannot be negative")
    private Float weight;

    @Min(value = 0, message = "Count cannot be negative")
    private int count;

    @NotNull(message = "Status is required")
    private Status status;

}
