package ch.schmid.samuel.gymEquip.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime lastRestoration;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime nextRestoration;

    @NotNull(message = "Status is required")
    private Status status;
}
