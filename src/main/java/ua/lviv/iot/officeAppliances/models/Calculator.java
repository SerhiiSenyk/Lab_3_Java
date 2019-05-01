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
public class Calculator extends OfficeAppliance {

    private String type;
    private int bitSize;
    private Size corpusSize;

    public Calculator(String type, int bitSize, Size corpusSize, double price, Color color,
            double weight, String producer, Material material) {
        super(price, color, weight, producer, material);
        this.type = type;
        this.bitSize = bitSize;
        this.corpusSize = corpusSize;
    }

    private Calculator() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBitSize() {
        return bitSize;
    }

    public void setBitSize(int bitSize) {
        this.bitSize = bitSize;
    }

    public Size getCorpusSize() {
        return corpusSize;
    }

    public void setCorpusSize(Size corpusSize) {
        this.corpusSize = corpusSize;
    }

    @Override
    public String toString() {
        return "Calculator : " + "\nType : " + type + "\nBit size : " + bitSize
                + "\ncorpus size : " + corpusSize.toString() + super.toString();
    }

    @Override
    public String getHeaders() {
        String sep = ",";
        return super.getHeaders() + sep + "type" + sep
                + "bitSize" + sep + corpusSize.getHeaders();
    }

    @Override
    public String toCSV() {
        String sep = ",";
        return super.toCSV() + sep + type + sep + bitSize + sep
                + corpusSize.toCSV();
    }
}
