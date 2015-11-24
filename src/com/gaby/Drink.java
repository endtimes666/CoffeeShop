package com.gaby;

public class Drink {

    private String name;
    private float cost;
    private float price;
    private int totalSold;


    public Drink(String name, float cost, float price, int totalSold) {
        super();
        this.name = name;
        this.cost = cost;
        this.price = price;
        this.totalSold = totalSold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getTotalSold() {
        return totalSold;
    }

    public void setTotalSold(int totalSold) {
        this.totalSold = totalSold;
    }

  /*  @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + ", company="
                + company + ", total=" + total + ", available=" + available
                + "]";
    }
*/

        }
    