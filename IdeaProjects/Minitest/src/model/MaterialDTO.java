package model;

import java.time.LocalDate;

public class MaterialDTO implements IParser{

//ID,TYPE,TEN,PRICE,QUANTITY,HEIGHT,DATE
    private String id;
    private String type;
    private long quantity;
    private double height;
    private String name;
    private LocalDate creatAt;
    private int cost;

    public MaterialDTO(){

    }

    public MaterialDTO(String id, String type, long quantity, double height, String name, LocalDate creatAt, int cost) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
        this.height = height;
        this.name = name;
        this.creatAt = creatAt;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(LocalDate creatAt) {
        this.creatAt = creatAt;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public void parse(String line) {

    }
}
