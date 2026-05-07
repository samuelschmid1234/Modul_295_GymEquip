package ch.schmid.samuel.gymEquip.Service.AccessoryTypeService;

import ch.schmid.samuel.gymEquip.Model.AccessoryType;

import java.util.List;

public interface AccessoryTypeService {

    public List<AccessoryType> getAllAccessoryTypes();

    public AccessoryType getAccessoryTypeById(Long id);

    public AccessoryType updateAccessoryType(Long id, AccessoryType accessoryType);

    public void deleteAccessoryType(Long id);

    public AccessoryType createAccessoryType(AccessoryType accessoryType);

}
