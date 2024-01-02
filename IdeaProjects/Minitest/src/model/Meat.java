package model;

import java.time.LocalDate;

public class Meat extends Material {
    private double weight;


    public Meat(String id, String name, LocalDate creatAt, int cost) {
        super(id, name, creatAt, cost);
    }

    public Meat(String id, String name, LocalDate creatAt, int cost, double weight) {
        super(id, name, creatAt, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return getCost() * weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return getCreatAt().plusDays(7);
    }

    @Override
    public void displayMaterial() {
        super.displayMaterial();
        System.out.println("Cân nặng là :" + weight);
    }

    @Override
    public String toString() {
        return super.toString() + " " +
                "weight=" + weight +
                ' ';
    }

    @Override
    public double getRealMoney() {
        LocalDate expirationDate = getExpiryDate();
        LocalDate today = LocalDate.now();

        long daysUntilExpiration = today.until(expirationDate).getDays();
        if (daysUntilExpiration <= 5) {
            return getAmount() * 0.7;
        } else {
            return getAmount() * 0.9;
        }
    }
}

