package ch.schmid.samuel.gymEquip.Controller;

import lombok.AllArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Accessory sets returned successfully"),
            @ApiResponse(responseCode = "401", description = "Authentication required"),
            @ApiResponse(responseCode = "403", description = "Access denied")
    })
    public ResponseEntity<List<AccessorySet>> getAllAccessorySets() {
        List<AccessorySet> accessorySets = accessorySetService.getAllAccessorySets();
        return new ResponseEntity<>(accessorySets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize(Roles.CanRead)
    @Operation(summary = "Get an accessory set by ID", 
        description = "Returns the accessory set with the specified ID. Requires read, update, or admin privileges.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Accessory set returned successfully"),
            @ApiResponse(responseCode = "401", description = "Authentication required"),
            @ApiResponse(responseCode = "403", description = "Access denied"),
            @ApiResponse(responseCode = "404", description = "Accessory set not found")
    })
    public ResponseEntity<AccessorySet> getAccessorySetById(@Parameter(description = "ID of the accessory set") @PathVariable Long id) {
        AccessorySet accessorySet = accessorySetService.getAccessorySetById(id);
        return new ResponseEntity<>(accessorySet, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize(Roles.IsAdmin)
    @Operation(summary = "Create an accessory set", 
        description = "Creates a new accessory set. Requires admin privileges.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Accessory set created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid accessory set data"),
            @ApiResponse(responseCode = "401", description = "Authentication required"),
            @ApiResponse(responseCode = "403", description = "Access denied")
    })
    public ResponseEntity<AccessorySet> createAccessorySet(@Parameter(description = "Accessory set data to create") @Valid @RequestBody AccessorySet accessorySet) {
        AccessorySet createdSet = accessorySetService.createAccessorySet(accessorySet);
        return new ResponseEntity<>(createdSet, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize(Roles.CanUpdate)
    @Operation(summary = "Update an accessory set by ID", 
        description = "Updates the accessory set with the specified ID. Requires update or admin privileges.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Accessory set updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid accessory set data"),
            @ApiResponse(responseCode = "401", description = "Authentication required"),
            @ApiResponse(responseCode = "403", description = "Access denied"),
            @ApiResponse(responseCode = "404", description = "Accessory set not found")
    })
    public ResponseEntity<AccessorySet> updateAccessorySet(
            @Parameter(description = "ID of the accessory set") @PathVariable Long id,
            @Parameter(description = "Updated accessory set data") @Valid @RequestBody AccessorySet accessorySet) {
        AccessorySet updatedSet = accessorySetService.updateAccessorySet(id, accessorySet);
        return new ResponseEntity<>(updatedSet, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(Roles.IsAdmin)
    @Operation(summary = "Delete an accessory set by ID", 
        description = "Deletes the accessory set with the specified ID. Requires admin privileges.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Accessory set deleted successfully"),
            @ApiResponse(responseCode = "401", description = "Authentication required"),
            @ApiResponse(responseCode = "403", description = "Access denied"),
            @ApiResponse(responseCode = "404", description = "Accessory set not found")
    })
    public ResponseEntity<Void> deleteAccessorySet(@Parameter(description = "ID of the accessory set") @PathVariable Long id) {
        accessorySetService.deleteAccessorySet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
