package ch.schmid.samuel.gymEquip.Service.MachineService;

import ch.schmid.samuel.gymEquip.Model.Machine;

import java.util.List;

public interface MachineService {

    public List<Machine> getAllMachines();

    public Machine getMachineById(Long id);

    public Machine updateMachine(Long id, Machine Machine);

    public void deleteMachine(Long id);

    public Machine createMachine(Machine Machine);

}
