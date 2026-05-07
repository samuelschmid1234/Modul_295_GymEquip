package samuel.schmid.gymEquip.Service.MachineService;

import org.springframework.stereotype.Service;
import samuel.schmid.gymEquip.Model.Machine;
import samuel.schmid.gymEquip.Repository.MachineRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class MachineServiceImpl implements MachineService{

    MachineRepository machineRepository;

    @Override
    public List<Machine> getAllMachines() {

        return machineRepository.findAll();
    }

    @Override
    public Machine getMachineById(Long id) {
        return machineRepository.findById(id).orElse(null);
    }

    @Override
    public Machine updateMachine(Long id, Machine machine) {
        Machine existingMachine = machineRepository.findById(id).orElse(null);
        if (existingMachine == null) {
            return null;
        }

        existingMachine.setStatus(machine.getStatus());
        existingMachine.setBrand(machine.getBrand());
        existingMachine.setCategory(machine.getCategory());
        existingMachine.setComment(machine.getComment());
        existingMachine.setName(machine.getName());
        existingMachine.setLastRestoration(machine.getLastRestoration());
        existingMachine.setNextRestoration(machine.getNextRestoration());
        existingMachine.setSerialNumber(machine.getSerialNumber());
        existingMachine.setPrice(machine.getPrice());
        existingMachine.setPurchaseDate(machine.getPurchaseDate());
        existingMachine.setType(machine.getType());

        return machineRepository.save(existingMachine);
    }

    @Override
    public void deleteMachine(Long id) {
        machineRepository.deleteById(id);
    }

    @Override
    public Machine createMachine(Machine machine) {
        return machineRepository.save(machine);
    }
}
