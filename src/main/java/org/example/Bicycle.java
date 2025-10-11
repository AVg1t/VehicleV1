package org.example;

public final class Bicycle extends Vehicle {
    public Bicycle() {
        setAbility(VehicleDescriptor.vehicleAbility.RIDE.getAbility());
        setType("Bicycle");
        options.add(new VehicleOption("Size", "-", "inches"));
    }

    public Vehicle construct() {
        fillVehicleOptions();
        return this;
    }
}
