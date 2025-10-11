package org.example;

public final class Boat extends Vehicle {
    public Boat() {
        setAbility(VehicleDescriptor.vehicleAbility.SAIL.getAbility());
        setType("Boat");
        options.add(new VehicleOption("Payload", "-", "tons"));
        options.add(new VehicleOption("Power", "-", "hp"));
    }

    public Vehicle construct() {
        fillVehicleOptions();
        return this;
    }
}
