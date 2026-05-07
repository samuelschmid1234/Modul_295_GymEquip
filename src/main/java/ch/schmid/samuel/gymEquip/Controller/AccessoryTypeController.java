package ch.schmid.samuel.gymEquip.Controller;

import lombok.AllArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import ch.schmid.samuel.gymEquip.Model.AccessoryType;
import ch.schmid.samuel.gymEquip.Service.AccessoryTypeService.AccessoryTypeService;
import ch.schmid.samuel.gymEquip.security.Roles;

import java.util.List;

@RestController
@RequestMapping("/api/accessorytypes")
@AllArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Validated
public class AccessoryTypeController {

    private final AccessoryTypeService accessoryTypeService;

    @GetMapping
    @PreAuthorize(Roles.CanRead)
    @Operation(summary = "Get all accessory types", 
        description = "Returns all accessory types. Requires read, update, or admin privileges.")
    public ResponseEntity<List<AccessoryType>> getAllAccessoryTypes() {
        List<AccessoryType> accessoryTypes = accessoryTypeService.getAllAccessoryTypes();
        return new ResponseEntity<>(accessoryTypes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize(Roles.CanRead)
    @Operation(summary = "Get an accessory type by ID", 
        description = "Returns the accessory type with the specified ID. Requires read, update, or admin privileges.")
    public ResponseEntity<AccessoryType> getAccessoryTypeById(@PathVariable Long id) {
        AccessoryType accessoryType = accessoryTypeService.getAccessoryTypeById(id);
        return new ResponseEntity<>(accessoryType, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize(Roles.IsAdmin)
    @Operation(summary = "Create an accessory type", 
        description = "Creates a new accessory type. Requires admin privileges.")
    public ResponseEntity<AccessoryType> createAccessoryType(@Valid @RequestBody AccessoryType accessoryType) {
        AccessoryType createdAccessoryType = accessoryTypeService.createAccessoryType(accessoryType);
        return new ResponseEntity<>(createdAccessoryType, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize(Roles.CanUpdate)
    @Operation(summary = "Update an accessory type by ID", 
        description = "Updates the accessory type with the specified ID. Requires update or admin privileges.")
    public ResponseEntity<AccessoryType> updateAccessoryType(@PathVariable Long id, @Valid @RequestBody AccessoryType accessoryType) {
        AccessoryType updatedAccessoryType = accessoryTypeService.updateAccessoryType(id, accessoryType);
        return new ResponseEntity<>(updatedAccessoryType, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(Roles.IsAdmin)
    @Operation(summary = "Delete an accessory type by ID", 
        description = "Deletes the accessory type with the specified ID. Requires admin privileges.")
    public ResponseEntity<Void> deleteAccessoryType(@PathVariable Long id) {
        accessoryTypeService.deleteAccessoryType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
