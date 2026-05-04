package samuel.schmid.gymEquip.Service.AccessorySetService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import samuel.schmid.gymEquip.Model.AccessorySet;
import samuel.schmid.gymEquip.Repository.AccessorySetRepository;

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

        if (accessorySetRepository.findById(id).isEmpty()){
            return null;
        }

        return accessorySetRepository.findById(id).get();
    }

    @Override
    public AccessorySet updateAccessorySet(Long id, AccessorySet accessorySet) {
        if (accessorySetRepository.findById(id).isEmpty()){
            return null;
        }

        AccessorySet updateAccessorySet = accessorySetRepository.findById(id).get();

        updateAccessorySet.setAccessoryList(accessorySet.getAccessoryList());

        return accessorySetRepository.save(updateAccessorySet);
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
