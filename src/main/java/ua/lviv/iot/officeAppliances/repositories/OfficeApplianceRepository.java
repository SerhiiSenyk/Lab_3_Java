package ua.lviv.iot.officeAppliances.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.iot.officeAppliances.models.OfficeAppliance;

public interface OfficeApplianceRepository<T extends OfficeAppliance> extends CrudRepository<T, Integer> {
}
