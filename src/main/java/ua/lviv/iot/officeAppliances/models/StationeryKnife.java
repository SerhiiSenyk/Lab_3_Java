/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.lviv.iot.officeAppliances.models;

/**
 *
 * @author Serhii-PC
 */
public class StationeryKnife extends OfficeAppliance {

    private double widthOfBlade;

    public StationeryKnife(double widthOfBlade, double price, Color color,
            double weight, String producer, Material material) {
        super(price, color, weight, producer, material);
        this.widthOfBlade = widthOfBlade;
    }

    public StationeryKnife() {
        //this(0.0);
    }

    public double getWidthOfBlade() {
        return widthOfBlade;
    }

    public void setWidthOfBlade(double widthOfBlade) {
        this.widthOfBlade = widthOfBlade;
    }

    @Override
    public String toString() {
        return "StationeryKnife : " + "\nwidth of blade : "
                + widthOfBlade + super.toString();

    }
}
