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
public class Board extends OfficeAppliance {

    private String surface;
    private Size sizeOfSurface;
    private String typeOfFrame;

    public Board(String surface, Size sizeOfSurface, String typeOfFrame,
            double price, Color color, double weight, String producer,
            Material material) {
        super(price, color, weight, producer, material);
        this.surface = surface;
        this.sizeOfSurface = sizeOfSurface;
        this.typeOfFrame = typeOfFrame;
    }

    private Board() {
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public Size getSizeOfSurface() {
        return sizeOfSurface;
    }

    public void setSizeOfSurface(Size sizeOfSurface) {
        this.sizeOfSurface = sizeOfSurface;
    }

    public String getTypeOfFrame() {
        return typeOfFrame;
    }

    public void setTypeOfFrame(String typeOfFrame) {
        this.typeOfFrame = typeOfFrame;
    }

    @Override
    public String toString() {
        return "Board : " + "\nsurface : " + surface + "\nSize of surface : "
                + sizeOfSurface.toString()
                + "\ntypeOfFrame : " + typeOfFrame + super.toString();
    }

    @Override
    public String getHeaders() {
        String sep = ",";
        return super.getHeaders() + sep + "surface" + sep
                + sizeOfSurface.getHeaders() + sep + "type of frame";
    }

    @Override
    public String toCSV() {
        String sep = ",";
        return super.toCSV() + sep + surface + sep + sizeOfSurface.toCSV()
                + sep + typeOfFrame;
    }
}
