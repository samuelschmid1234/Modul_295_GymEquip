package ch.schmid.samuel.gymEquip.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ch.schmid.samuel.gymEquip.Model.Machine;

public interface MachineRepository extends JpaRepository<Machine, Long> {

}
