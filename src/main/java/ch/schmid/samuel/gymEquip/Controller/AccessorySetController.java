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
import ch.schmid.samuel.gymEquip.Model.AccessorySet;
import ch.schmid.samuel.gymEquip.Service.AccessorySetService.AccessorySetService;
import ch.schmid.samuel.gymEquip.security.Roles;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/accessory-sets")
@SecurityRequirement(name = "bearerAuth")
@Validated
public class AccessorySetController {

    AccessorySetService accessorySetService;

    @GetMapping
    @PreAuthorize(Roles.CanRead)
    @Operation(summary = "Get all accessory sets", 
        description = "Returns all accessory sets. Requires read, update, or admin privileges.")
    public ResponseEntity<List<AccessorySet>> getAllAccessorySets() {
        List<AccessorySet> accessorySets = accessorySetService.getAllAccessorySets();
        return new ResponseEntity<>(accessorySets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize(Roles.CanRead)
    @Operation(summary = "Get an accessory set by ID", 
        description = "Returns the accessory set with the specified ID. Requires read, update, or admin privileges.")
    public ResponseEntity<AccessorySet> getAccessorySetById(@PathVariable Long id) {
        AccessorySet accessorySet = accessorySetService.getAccessorySetById(id);
        return new ResponseEntity<>(accessorySet, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize(Roles.IsAdmin)
    @Operation(summary = "Create an accessory set", 
        description = "Creates a new accessory set. Requires admin privileges.")
    public ResponseEntity<AccessorySet> createAccessorySet(@Valid @RequestBody AccessorySet accessorySet) {
        AccessorySet createdSet = accessorySetService.createAccessorySet(accessorySet);
        return new ResponseEntity<>(createdSet, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize(Roles.CanUpdate)
    @Operation(summary = "Update an accessory set by ID", 
        description = "Updates the accessory set with the specified ID. Requires update or admin privileges.")
    public ResponseEntity<AccessorySet> updateAccessorySet(
            @PathVariable Long id,
            @Valid @RequestBody AccessorySet accessorySet) {
        AccessorySet updatedSet = accessorySetService.updateAccessorySet(id, accessorySet);
        return new ResponseEntity<>(updatedSet, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(Roles.IsAdmin)
    @Operation(summary = "Delete an accessory set by ID", 
        description = "Deletes the accessory set with the specified ID. Requires admin privileges.")
    public ResponseEntity<Void> deleteAccessorySet(@PathVariable Long id) {
        accessorySetService.deleteAccessorySet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
