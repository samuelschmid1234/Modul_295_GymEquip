package ch.schmid.samuel.gymEquip.Service.AccessoryTypeService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ch.schmid.samuel.gymEquip.Model.AccessoryType;
import ch.schmid.samuel.gymEquip.Repository.AccessoryTypeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AccessoryTypeServiceImpl implements AccessoryTypeService {

    private final AccessoryTypeRepository accessoryTypeRepository;

    @Override
    public List<AccessoryType> getAllAccessoryTypes() {
        return accessoryTypeRepository.findAll();
    }

    @Override
    public AccessoryType getAccessoryTypeById(Long id) {
        return accessoryTypeRepository.findById(id).orElse(null);
    }

    @Override
    public AccessoryType updateAccessoryType(Long id, AccessoryType accessoryType) {
        AccessoryType existingAccessoryType = accessoryTypeRepository.findById(id).orElse(null);
        if (existingAccessoryType != null) {
            existingAccessoryType.setName(accessoryType.getName());
            return accessoryTypeRepository.save(existingAccessoryType);
        }
        return null;
    }

    @Override
    public void deleteAccessoryType(Long id) {
        accessoryTypeRepository.deleteById(id);
    }

    @Override
    public AccessoryType createAccessoryType(AccessoryType accessoryType) {
        return accessoryTypeRepository.save(accessoryType);
    }

}
