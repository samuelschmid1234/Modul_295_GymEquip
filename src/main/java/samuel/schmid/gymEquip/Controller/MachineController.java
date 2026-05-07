package samuel.schmid.gymEquip.Controller;

import lombok.AllArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import samuel.schmid.gymEquip.Model.Machine;
import samuel.schmid.gymEquip.Service.MachineService.MachineService;

import java.util.List;

@RestController
@RequestMapping("/api/machines")
@AllArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Validated
public class MachineController {

    private final MachineService machineService;

    @GetMapping
    public ResponseEntity<List<Machine>> getAllMachines() {
        List<Machine> machines = machineService.getAllMachines();
        return new ResponseEntity<>(machines, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Machine> getMachineById(@PathVariable Long id) {
        Machine machine = machineService.getMachineById(id);
        return new ResponseEntity<>(machine, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Machine> createMachine(@Valid @RequestBody Machine machine) {
        Machine createdMachine = machineService.createMachine(machine);
        return new ResponseEntity<>(createdMachine, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Machine> updateMachine(
            @PathVariable Long id,
            @Valid @RequestBody Machine machine) {
        Machine updatedMachine = machineService.updateMachine(id, machine);
        return new ResponseEntity<>(updatedMachine, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMachine(@PathVariable Long id) {
        machineService.deleteMachine(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
