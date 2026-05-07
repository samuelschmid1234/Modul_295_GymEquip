package ch.schmid.samuel.gymEquip.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccessorySet extends InventoryItem  {

    @ElementCollection
    private List<Accessory> accessoryList;

}
