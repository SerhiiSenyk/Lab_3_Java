/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.lviv.iot.officeAppliances.models;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Serhii-PC
 */
@Entity
public abstract class OfficeAppliance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private double price;
    @Embedded
    @AttributeOverrides(value = {
        @AttributeOverride(name = "red", column = @Column(name = "red"))
        ,
        @AttributeOverride(name = "green", column = @Column(name = "green"))
        , 
        @AttributeOverride(name = "blue", column = @Column(name = "blue"))
    })
    private Color color;
    private double weight;
    private String producer;
    @Enumerated(EnumType.STRING)
    private Material material;

    public OfficeAppliance(double price, Color color, double weight,
            String producer, Material material) {
        this.price = price;
        this.color = color;
        this.weight = weight;
        this.producer = producer;
        this.material = material;
    }

    public OfficeAppliance() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "\nPrice : " + getPrice() + color.toString() + "\nWeight : "
                + getWeight() + "\nProducer : " + getProducer() + "\nMaterial : "
                + getMaterial() + "\n\n";
    }

    public String getHeaders() {
        String sep = ",";
        return "Price" + sep + color.getHeaders() + sep
                + "Weight" + sep + "Produder" + sep + "Material";
    }

    public String toCSV() {
        String sep = ",";
        return getPrice() + sep + color.toCSV() + sep
                + getWeight() + sep + getProducer() + sep + getMaterial();
    }

}
