package org.example;

public final class Car extends Vehicle {
    public Car() {
        setAbility(vehicleAbility.DRIVE.getAbility());
        setType("Car");
    }

    public Vehicle construct() {
        fillVehicleOptions();
        return this;
    }
}
