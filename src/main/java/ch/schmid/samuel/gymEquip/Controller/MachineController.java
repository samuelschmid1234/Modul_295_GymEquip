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
import ch.schmid.samuel.gymEquip.Model.Machine;
import ch.schmid.samuel.gymEquip.Service.MachineService.MachineService;
import ch.schmid.samuel.gymEquip.security.Roles;

import java.util.List;

@RestController
@RequestMapping("/api/machines")
@AllArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Validated
public class MachineController {

    private final MachineService machineService;

    @GetMapping
    @PreAuthorize(Roles.CanRead)
    @Operation(summary = "Get all machines", 
        description = "Returns all machines. Requires read, update, or admin privileges.")
    public ResponseEntity<List<Machine>> getAllMachines() {
        List<Machine> machines = machineService.getAllMachines();
        return new ResponseEntity<>(machines, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize(Roles.CanRead)
    @Operation(summary = "Get a machine by ID", 
        description = "Returns the machine with the specified ID. Requires read, update, or admin privileges.")
    public ResponseEntity<Machine> getMachineById(@PathVariable Long id) {
        Machine machine = machineService.getMachineById(id);
        return new ResponseEntity<>(machine, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize(Roles.IsAdmin)
    @Operation(summary = "Create a machine", 
        description = "Creates a new machine. Requires admin privileges.")
    public ResponseEntity<Machine> createMachine(@Valid @RequestBody Machine machine) {
        Machine createdMachine = machineService.createMachine(machine);
        return new ResponseEntity<>(createdMachine, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize(Roles.CanUpdate)
    @Operation(summary = "Update a machine by ID", 
        description = "Updates the machine with the specified ID. Requires update or admin privileges.")
    public ResponseEntity<Machine> updateMachine(
            @PathVariable Long id,
            @Valid @RequestBody Machine machine) {
        Machine updatedMachine = machineService.updateMachine(id, machine);
        return new ResponseEntity<>(updatedMachine, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(Roles.IsAdmin)
    @Operation(summary = "Delete a machine by ID", 
        description = "Deletes the machine with the specified ID. Requires admin privileges.")
    public ResponseEntity<Void> deleteMachine(@PathVariable Long id) {
        machineService.deleteMachine(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
