package ch.schmid.samuel.gymEquip.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ch.schmid.samuel.gymEquip.Model.AccessorySet;

public interface AccessorySetRepository extends JpaRepository<AccessorySet, Long> {
}
