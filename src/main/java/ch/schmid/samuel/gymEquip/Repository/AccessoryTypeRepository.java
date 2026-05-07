package ch.schmid.samuel.gymEquip.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ch.schmid.samuel.gymEquip.Model.AccessoryType;

public interface AccessoryTypeRepository extends JpaRepository<AccessoryType, Long> {

}
