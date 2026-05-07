package samuel.schmid.gymEquip.Controller;

import lombok.AllArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import samuel.schmid.gymEquip.Model.AccessoryType;
import samuel.schmid.gymEquip.Service.AccessoryTypeService.AccessoryTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/accessorytypes")
@AllArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Validated
public class AccessoryTypeController {

    private final AccessoryTypeService accessoryTypeService;

    @GetMapping
    public ResponseEntity<List<AccessoryType>> getAllAccessoryTypes() {
        List<AccessoryType> accessoryTypes = accessoryTypeService.getAllAccessoryTypes();
        return new ResponseEntity<>(accessoryTypes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccessoryType> getAccessoryTypeById(@PathVariable Long id) {
        AccessoryType accessoryType = accessoryTypeService.getAccessoryTypeById(id);
        return new ResponseEntity<>(accessoryType, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AccessoryType> createAccessoryType(@Valid @RequestBody AccessoryType accessoryType) {
        AccessoryType createdAccessoryType = accessoryTypeService.createAccessoryType(accessoryType);
        return new ResponseEntity<>(createdAccessoryType, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccessoryType> updateAccessoryType(@PathVariable Long id, @Valid @RequestBody AccessoryType accessoryType) {
        AccessoryType updatedAccessoryType = accessoryTypeService.updateAccessoryType(id, accessoryType);
        return new ResponseEntity<>(updatedAccessoryType, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccessoryType(@PathVariable Long id) {
        accessoryTypeService.deleteAccessoryType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
