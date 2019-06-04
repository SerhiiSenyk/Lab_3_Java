/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.lviv.iot.officeAppliances.managers;

import ua.lviv.iot.officeAppliances.models.Color;
import ua.lviv.iot.officeAppliances.models.OfficeAppliance;
import java.util.List;

/**
 *
 * @author Serhii-PC
 */
public interface IofficeAppliancesManager {

    List<OfficeAppliance> findByColor(Color color);

    void sortByPrice(List<OfficeAppliance> officeAppliances,
            SortType sortType);

    void sortByWeight(List<OfficeAppliance> officeAppliances,
            SortType sortType);
}
