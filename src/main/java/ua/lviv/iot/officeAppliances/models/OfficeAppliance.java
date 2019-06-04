/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*Дана робота присвячена роботі з файлами і операції запису, і також базується на основі
лабораторних 3-5. Для реалізованої ієрархії класів в 3-й лабораторній слід реалізувати запис
списку об’єктів, які присутні в менеджері, в CSV-файл. Звертаю увагу, що код слід реалізувати
лише після здачі 3-5 лабораторних (здаються окремо, при спробі здачі всіх робіт одночасно
студент отримає доповнення до його задачі 3).
Нехай в рамках лабораторної 3 було реалізовано клас CrocodileManager, який містить список
об’єктів, похідних від класу Crocodile. Для кожного класу, похідного від Crocodile і в самому класі
Crocodile слід реалізувати два методи:
pubic String getHeaders() { … } - повертає стрічку з атрибутів, присутніх в даному класі,
розділеному через кому
pubic String toCSV() { ... } - повертає значення атрибутів (значення полів), даного об'єкта,
розділеного комами
Реалізація методу toCSV в дочірніх класах має викликати також цей метод із батьківського
класу. Поля, які оголошені в батьківському класі, мають конвертуватись в стрічку, розділену
комами, в батьківському класі, наприклад:
class Crocodile {
private String origin;
…
pubic String getHeaders() {
return “origin”;
}
}
class Aligator extends Crocodile {
private int maxSpeed;
…
pubic String getHeaders() {
return super.getHeaders() + “,” + “maxSpeed”;
}
}
Для реалізації запису у файл слід реалізувати окремий клас Writer (наприклад - CrocodileWriter),
який міститиме метод public void writeToFile(List<Crocodile> crocodiles). Виклик даного методу
слід реалізувати з тестів
Код має відповідати code convention
 */
package ua.lviv.iot.officeAppliances.models;

/**
 *
 * @author Serhii-PC
 */
public abstract class OfficeAppliance {

    private double price;
    private Color color;
    private double weight;
    private String producer;
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
