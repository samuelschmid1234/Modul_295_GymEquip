package ch.schmid.samuel.gymEquip.Service.AccessorySetService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ch.schmid.samuel.gymEquip.Model.AccessorySet;
import ch.schmid.samuel.gymEquip.Repository.AccessorySetRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AccessorySetServiceImpl implements AccessorySetService{

    AccessorySetRepository accessorySetRepository;

    @Override
    public List<AccessorySet> getAllAccessorySets() {
        return accessorySetRepository.findAll();
    }

    @Override
    public AccessorySet getAccessorySetById(Long id) {
        return accessorySetRepository.findById(id).orElse(null);
    }

    @Override
    public AccessorySet updateAccessorySet(Long id, AccessorySet accessorySet) {
        AccessorySet existingAccessorySet = accessorySetRepository.findById(id).orElse(null);
        if (existingAccessorySet == null) {
            return null;
        }

        existingAccessorySet.setAccessoryList(accessorySet.getAccessoryList());

        return accessorySetRepository.save(existingAccessorySet);
    }

    @Override
    public void deleteAccessorySet(Long id) {
        accessorySetRepository.deleteById(id);
    }

    @Override
    public AccessorySet createAccessorySet(AccessorySet accessorySet) {
        return accessorySetRepository.save(accessorySet);
    }
}
