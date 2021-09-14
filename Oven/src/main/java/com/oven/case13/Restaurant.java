package com.oven.case13;

public class Restaurant {
    public String name;
    private final OvenAbstraction oven = new GasOven();

    public Restaurant(String name){
        this.name = name;
        System.out.printf("Restaurant '%s' opened in your distict!\n", name);
    }

    public void cook(String item) {
        this.oven.light(oven.getOvenType());
        this.oven.bake(item);
        this.oven.extinguish(oven.getOvenType());
    }
}
