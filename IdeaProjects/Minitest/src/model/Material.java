package model;

import java.time.LocalDate;

public abstract class Material implements Discount {

    private String id;
    private String name;
    private LocalDate creatAt;
    private int cost;

    public Material(String id, String name, LocalDate creatAt, int cost) {
        this.id = id;
        this.name = name;
        this.creatAt = creatAt;
        this.cost = cost;
    }
    public Material(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public abstract double getAmount();

    public abstract LocalDate getExpiryDate();

    public void displayMaterial() {
        System.out.println("Code của vật liệu là " + id);
        System.out.println("Tên vật liệu là " + name);
        System.out.println("Ngày tạo là " + creatAt);
        System.out.println("Giá " + cost);
    }

    @Override
    public String toString() {
        return "Material" +
                " " +
                "id ='" + id + '\'' +
                ", name ='" + name + '\'' +
                ", creatAt = " + creatAt +
                ", cost = " + cost +
                ',';
    }
}
