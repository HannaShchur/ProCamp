package com.example.spacestation.FuelRepoImpl;


import com.example.spacestation.FunctionalInterfaces.FuelControl;
import com.example.spacestation.FunctionalInterfaces.MessageGenerator;
import com.example.spacestation.FunctionalInterfaces.Report;
import com.example.spacestation.Repoes.FuelRepo;

import static com.example.spacestation.MessageUtils.MessageUtils.*;

public class FuelRepoImpl implements FuelRepo {
    private int fuel = 0;
    private final int MIN_FUEL = 10;
    private final Report report = f -> System.out.printf(FUEL_REPORT, f);
    private final MessageGenerator logger = System.out::println;
    private final FuelControl fuelAvailable = x -> x >= MIN_FUEL;


    @Override
    public void loadFuel(int quantity) {
        logger.print(FUEL_ACTION);
        logger.print(String.format(LOADING_FUEL, quantity));
        this.fuel += quantity;
    }

    @Override
    public void reportFuel() {
        report.action(fuel);
    }

    @Override
    public void activateThrusters() {
        logger.print(THRUSTERS_ACTION);
        String thrustersStartMessage = fuelAvailable.check(fuel)
                ? this.fuelIsOk()
                : THRUSTERS_ERROR;
        logger.print(thrustersStartMessage);
    }

    // private method
    private String fuelIsOk() {
        fuel -= 10;
        return "Thrusting action successful.";
    }
}
