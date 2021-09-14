package com.oven.case13;

public class OvenAbstraction implements OvenInterface {
    private boolean on;
    private String ovenType = "model";

    public String getOvenType() {
        return ovenType;
    }

    @Override
    public void light(String ovenType) {
        System.out.printf("Lighting the oven's %s!%n", ovenType);
        this.on = true;
    }

    @Override
    public void extinguish(String ovenType) {
        System.out.printf("Extinguish the oven's %s!%n", ovenType);
        this.on = false;
    }

    @Override
    public void bake(String item) {
        if (!this.on){
            System.out.println("Oven's gas is not turned on.");
        }  else  {
            System.out.printf("Now baking %s!\n", item);
        }
    }
}
