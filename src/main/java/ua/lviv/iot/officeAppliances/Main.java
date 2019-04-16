/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Serhii-PC
 */
package ua.lviv.iot.officeAppliances;

import ua.lviv.iot.officeAppliances.models.Board;
import ua.lviv.iot.officeAppliances.models.Calculator;
import ua.lviv.iot.officeAppliances.models.Color;
import ua.lviv.iot.officeAppliances.models.Material;
import ua.lviv.iot.officeAppliances.models.OfficeAppliance;
import ua.lviv.iot.officeAppliances.models.Size;
import ua.lviv.iot.officeAppliances.models.Stapler;
import ua.lviv.iot.officeAppliances.models.StationeryKnife;
import ua.lviv.iot.officeAppliances.managers.OfficeAppliancesManager;
import ua.lviv.iot.officeAppliances.managers.SortType;
import java.util.List;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        List<OfficeAppliance> officeAppliances = new LinkedList<>();

        Board board = new Board("chalky", new Size(100.0, 80.0, 5.0),
                "aluminum", 250.0, new Color(0, 128, 128), 25.0, "Economix",
                Material.METAL);

        Stapler stapler = new Stapler(0.7, 2, 26.0, new Color(0, 0, 0), 100.0,
                "Buromax", Material.METAL_PLUS_PLASTIC);

        StationeryKnife stationeryKnife = new StationeryKnife(2.0, 50.0,
                new Color(128, 128, 128), 0.2, "ABC", Material.METAL);

        Calculator calculator = new Calculator("engineering", 64,
                new Size(15.2, 5.0, 0.5), 35.0, new Color(128, 128, 128), 0.1,
                "Company", Material.PLASTIC);

        officeAppliances.add(board);
        officeAppliances.add(stapler);
        officeAppliances.add(stationeryKnife);
        officeAppliances.add(calculator);

        OfficeAppliancesManager manager = 
                new OfficeAppliancesManager(officeAppliances);
        System.out.println("Selection by color");
        System.out.println(manager.findByColor(new Color(128, 128, 128)));
        System.out.println("Sort by ascending price");

        manager.sortByPrice(officeAppliances, SortType.ASCENDING);
        System.out.println(officeAppliances);
        manager.sortByPrice(officeAppliances, SortType.DESCENDING);
        System.out.println("Sort by descending by price");
        System.out.println(officeAppliances);
        System.out.println("Sort by ascending by weight");
        manager.sortByWeight(officeAppliances, SortType.ASCENDING);
        System.out.println(officeAppliances);
        manager.sortByWeight(officeAppliances, SortType.DESCENDING);
        System.out.println("Sort descending by weight");
        System.out.println(officeAppliances);
    }
}
