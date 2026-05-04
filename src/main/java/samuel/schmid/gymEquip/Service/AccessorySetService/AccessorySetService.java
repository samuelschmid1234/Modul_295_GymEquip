package samuel.schmid.gymEquip.Service.AccessorySetService;

import samuel.schmid.gymEquip.Model.AccessorySet;

import java.util.List;

public interface AccessorySetService {

    public List<AccessorySet> getAllAccessorySets();

    public AccessorySet getAccessorySetById(Long id);

    public AccessorySet updateAccessorySet(Long id, AccessorySet accessorySet);

    public void deleteAccessorySet(Long id);

    public AccessorySet createAccessorySet(AccessorySet accessorySet);
}
