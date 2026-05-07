package samuel.schmid.gymEquip.Controller;

import lombok.AllArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import samuel.schmid.gymEquip.Model.AccessorySet;
import samuel.schmid.gymEquip.Service.AccessorySetService.AccessorySetService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/accessory-sets")
@SecurityRequirement(name = "bearerAuth")
@Validated
public class AccessorySetController {

    AccessorySetService accessorySetService;

    @GetMapping
    public ResponseEntity<List<AccessorySet>> getAllAccessorySets() {
        List<AccessorySet> accessorySets = accessorySetService.getAllAccessorySets();
        return new ResponseEntity<>(accessorySets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccessorySet> getAccessorySetById(@PathVariable Long id) {
        AccessorySet accessorySet = accessorySetService.getAccessorySetById(id);
        return new ResponseEntity<>(accessorySet, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AccessorySet> createAccessorySet(@Valid @RequestBody AccessorySet accessorySet) {
        AccessorySet createdSet = accessorySetService.createAccessorySet(accessorySet);
        return new ResponseEntity<>(createdSet, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccessorySet> updateAccessorySet(
            @PathVariable Long id,
            @Valid @RequestBody AccessorySet accessorySet) {
        AccessorySet updatedSet = accessorySetService.updateAccessorySet(id, accessorySet);
        return new ResponseEntity<>(updatedSet, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccessorySet(@PathVariable Long id) {
        accessorySetService.deleteAccessorySet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
