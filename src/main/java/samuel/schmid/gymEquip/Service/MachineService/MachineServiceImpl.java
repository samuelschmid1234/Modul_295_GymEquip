package samuel.schmid.gymEquip.Service.MachineService;

import org.springframework.stereotype.Service;
import samuel.schmid.gymEquip.Model.Machine;
import samuel.schmid.gymEquip.Repository.MachineRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

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

        if (machineRepository.findById(id).isEmpty()){
            return null;
        }

        return machineRepository.findById(id).get();
    }

    @Override
    public Machine updateMachine(Long id, Machine machine) {

        if (machineRepository.findById(id).isEmpty()){
            return null;
        }

        Machine updateMachine = machineRepository.findById(id).get();

        updateMachine.setStatus(machine.getStatus());
        updateMachine.setBrand(machine.getBrand());
        updateMachine.setCategory(machine.getCategory());
        updateMachine.setComment(machine.getComment());
        updateMachine.setName(machine.getName());
        updateMachine.setLastRestoration(machine.getLastRestoration());
        updateMachine.setNextRestoration(machine.getNextRestoration());
        updateMachine.setSerialNumber(machine.getSerialNumber());
        updateMachine.setPrice(machine.getPrice());
        updateMachine.setPurchaseDate(machine.getPurchaseDate());
        updateMachine.setType(machine.getType());

        return machineRepository.save(updateMachine);
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
