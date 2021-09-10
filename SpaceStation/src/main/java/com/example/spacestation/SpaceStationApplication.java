package com.example.spacestation;

import com.example.spacestation.FuelRepoImpl.FuelRepoImpl;
import com.example.spacestation.FunctionalInterfaces.SensorsActivation;
import com.example.spacestation.Repoes.FuelRepo;
import com.example.spacestation.Repoes.SuppliesRepo;
import com.example.spacestation.SuppliesRepoImpl.SuppliesRepoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import static com.example.spacestation.MessageUtils.MessageUtils.ACTIVATION;

@SpringBootApplication
public class SpaceStationApplication {
    private static final FuelRepo fuel = new FuelRepoImpl();
    private static final SuppliesRepo supplies = new SuppliesRepoImpl();
    private static final SensorsActivation activation = () -> System.out.println(ACTIVATION);

    public static void main(String[] args) {
        SpringApplication.run(SpaceStationApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void demoRunner() {
        supplies.loadSupplies("Coffee", 1);
        fuel.loadFuel(15);
        activation.runSensors();
        fuel.reportFuel();
        supplies.reportSupplies();
        fuel.activateThrusters();
    }
}
