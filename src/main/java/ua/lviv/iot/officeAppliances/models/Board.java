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

    public Board() {
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
                + "\n\tlenght : " + getSizeOfSurface().getLenght()
                + "\n\twidth : " + getSizeOfSurface().getWidth()
                + "\n\theight : " + getSizeOfSurface().getHeight()
                + "\ntypeOfFrame : " + typeOfFrame + super.toString();
    }
}
