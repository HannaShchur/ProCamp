package com.example.spacestation.Repoes;

public interface SuppliesRepo {
    void loadSupplies(String type, int quantity);

    void useSupplies(String type, int quantity);

    void reportSupplies();
}
