/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.lviv.iot.officeAppliances.managers;
import ua.lviv.iot.officeAppliances.models.*;
import java.util.*;
import java.util.stream.Collectors;
import static ua.lviv.iot.officeAppliances.managers.SortType.*;

/**
 *
 * @author Serhii-PC
 */
public class OfficeAppliancesManager implements IOfficeAppliancesManager {

    private List<OfficeAppliance> officeAppliances;

    public OfficeAppliancesManager(List<OfficeAppliance> officeAppliances) {
        this.officeAppliances = officeAppliances;
    }

    public OfficeAppliancesManager() {

    }

    public List<OfficeAppliance> getOfficeAppliances() {
        return officeAppliances;
    }

    public void setOfficeAppliances(List<OfficeAppliance> officeAppliances) {
        this.officeAppliances = officeAppliances;
    }

    @Override
    public List<OfficeAppliance> findByColor(Color color) {
        return officeAppliances.stream().filter(col -> col.getColor().equals(color)).collect(Collectors.toList());
    }

    @Override
    public void sortByPrice(List<OfficeAppliance> officeAppliances, SortType sortType) {
        if (sortType == ASCENDING) {
            Collections.sort(officeAppliances, Comparator.comparing(OfficeAppliance::getPrice));

        } else {
            Collections.sort(officeAppliances, Comparator.comparing(OfficeAppliance::getPrice).reversed());
        }
    }

    @Override
    public void sortByWeight(List<OfficeAppliance> officeAppliances, SortType sortType) {
        if (sortType == ASCENDING) {
            Collections.sort(officeAppliances, Comparator.comparing(OfficeAppliance::getWeight));
        } else {
            Collections.sort(officeAppliances, Comparator.comparing(OfficeAppliance::getWeight).reversed());
        }
    }
}
