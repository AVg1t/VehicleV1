package org.example;

public abstract class VehicleDescriptor {
    protected enum vehicleAbility {
        DRIVE("drive"), FLY("fly"), SAIL("sail"), RIDE("ride");
        private final String ability;

        vehicleAbility(String ability) {
            this.ability = ability;
        }

        public String getAbility() {
            return ability;
        }
    }

    protected enum vehicleState {
        RUNNING("running"), STOPPED("stopped");
        private final String state;

        vehicleState(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    private String type;
    private String ability;
    private String state;

    protected void setAbility(String ability) {
        this.ability = ability;
    }

    protected void setState(String state) {
        this.state = state;
    }

    protected void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public String getAbility() {
        return this.ability;
    }

    public String getState() {
        return this.state;
    }

    public void info() {
        System.out.println("I`m a Vehicle constructor v1. Let`s construct a vehicle!");
        System.out.println("(enter ? for help)");
        System.out.println("(enter '/exit' to complete work)");
    }
}
