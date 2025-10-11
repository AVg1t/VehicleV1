package org.example;

public final class Plane extends Vehicle {
    public Plane() {
        setAbility(vehicleAbility.FLY.getAbility());
        setType("Plane");
        options.add(new VehicleOption("Flight altitude", "-", "km"));
    }

    public Vehicle construct() {
        fillVehicleOptions();
        return this;
    }
}
