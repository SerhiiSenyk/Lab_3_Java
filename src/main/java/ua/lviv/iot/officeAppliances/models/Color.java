/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.lviv.iot.officeAppliances.models;

import javax.persistence.Embeddable;

/**
 *
 * @author Serhii-PC
 */
@Embeddable
public class Color {

    private int red;
    private int green;
    private int blue;

    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public Color() {
        this(0, 0, 0);
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public void setColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Color other = (Color) obj;
        return red == other.red && green == other.green && blue == other.blue;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.red;
        hash = 61 * hash + this.green;
        hash = 61 * hash + this.blue;
        return hash;
    }

    @Override
    public String toString() {
        return "\nColor : \n" + "\tred : "
                + getRed() + "\n\tgreen : " + getGreen()
                + "\n\tblue : " + getBlue();
    }
    public String getHeaders() {
        String sep = ",";
        return "red" + sep + "green" + sep + "blue";
    }
    public String toCSV() {
        String sep = ",";
        return getRed() + sep + getGreen() + sep + getBlue();
    }
}
