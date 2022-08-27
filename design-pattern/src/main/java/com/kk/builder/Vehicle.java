package com.kk.builder;

public class Vehicle {

    private String engine;
    private String wheel;
    private int airbags;

    public String getEngine() {
        return engine;
    }

    public String getWheel() {
        return wheel;
    }

    public int getAirbags() {
        return airbags;
    }

    private Vehicle(VehicleBuilder builder) {
        this.airbags = builder.airbags;
        this.engine = builder.engine;
        this.wheel = builder.wheel;
    }

    public static class VehicleBuilder {
        private int airbags;
        private String engine;
        private String wheel;

        public VehicleBuilder(String engine, String wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        public VehicleBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}
