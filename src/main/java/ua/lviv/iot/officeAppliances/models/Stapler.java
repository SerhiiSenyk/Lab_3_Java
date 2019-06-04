/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.lviv.iot.officeAppliances.models;

import javax.persistence.Entity;

/**
 *
 * @author Serhii-PC
 */
@Entity
public class Stapler extends OfficeAppliance {

    private double staplesSize;
    private int power;

    public Stapler(double staplesSize, int power, double price, Color color,
            double weight, String producer, Material material) {
        super(price, color, weight, producer, material);
        this.power = power;
        this.staplesSize = staplesSize;
    }

    private Stapler() {
    }

    public double getStaplesSize() {
        return staplesSize;
    }

    public void setStaplesSize(double staplesSize) {
        this.staplesSize = staplesSize;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Stapler : \n" + "Staples size : " + staplesSize + "\nPower : "
                + power + super.toString();
    }

    @Override
    public String getHeaders() {
        String sep = ",";
        return super.getHeaders() + sep + "Staples size"
                + sep + "power";
    }

    @Override
    public String toCSV() {
        String sep = ",";
        return super.toCSV() + sep + staplesSize + sep + power;
    }

}
