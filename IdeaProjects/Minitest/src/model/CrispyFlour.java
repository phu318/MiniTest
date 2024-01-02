package model;

import java.time.LocalDate;

public class CrispyFlour extends Material {
    private long quantity;
    public CrispyFlour(String id, String name, LocalDate creatAt, int cost) {
        super(id, name, creatAt, cost);
    }

    public CrispyFlour(String id, String name, LocalDate creatAt, int cost, long quantity) {
        super(id, name, creatAt, cost);
        this.quantity = quantity;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }



    @Override
    public double getAmount() {
        return quantity * getCost();
    }
    @Override
    public LocalDate getExpiryDate(){
        return getCreatAt().plusYears(1);
    }
    @Override
    public void displayMaterial() {
        super.displayMaterial();
        System.out.println("Số lượng là " + quantity);

    }

    @Override
    public String toString() {
        return super.toString() + " " +
                "quantity=" + quantity +
                ' ';
    }

    @Override
    public double getRealMoney() {
        LocalDate expirationDate = getExpiryDate();
        LocalDate today = LocalDate.now();
        long monthsUntilExpiration = today.until(expirationDate).toTotalMonths();

        double discountRate = 0.0;
        if (monthsUntilExpiration == 2) {
            discountRate = 0.4;  // Giảm 40%
        } else if (monthsUntilExpiration == 4) {
            discountRate = 0.2;  // Giảm 20%
        } else {
            discountRate = 0.05; // Giảm 5%
        }

        return getAmount() * (1 - discountRate);
    }
    }

