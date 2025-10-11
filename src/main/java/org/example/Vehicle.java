package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

sealed public class Vehicle extends VehicleDescriptor permits Car, Plane, Boat, Bicycle {
    protected List<VehicleOption> options = new ArrayList<>();

    public Vehicle() {
//      характеристики по умолчанию
        options.add(new VehicleOption("Speed", "-", "km/h"));
        options.add(new VehicleOption("Range", "-", "km"));
        options.add(new VehicleOption("Weight", "-", "kg"));
//      создаем в состоянии stopped
        setState(vehicleState.STOPPED.getState());
    }

    public void fillVehicleOptions() {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("You choose vehicle type " + getType() + "! Now let`s describe it...");

        for (VehicleOption option : getVehicleOptions()) {
            setVehicleOptionValue(option.getOptionId(), this.getOption("Type " +
                    option.getOptionId().toLowerCase() +
                    " of a " + getType() + " measured in " +
                    option.getOptionUnit().toLowerCase() +
                    ":"));
        }
        System.out.println("Great! The " + getType() + " is ready and it can " + getAbility() + " with options:");
    }

    private String getOption(String outputMsg) {
        System.out.println(outputMsg);
//      создание объекта ввода и строки
        Scanner scanner = new Scanner(System.in);
        String userInput = null;
//      в цикле, пока пользователь не введет exit, обрабатываем ввод пользователя
        do {
//          если строка ввода непустая, обрабатываем
            if (!(userInput == null)) {
                if (!userInput.isEmpty()) {
//                  если пользователь ввел ? , выводим справку
                    if (userInput.equals("?")) {
                        info();
//                  иначе считаем
                    } else {
                        try {
                            if (userInput.isEmpty()) {
                                return "-";
                            } else {
                                return userInput.trim().replaceAll("\\s+", " ");
                            }
//                      если была ошибка, выводим
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
//
                    }
                } else {
                    System.out.println("Enter your choice:");
                }
            }
//          запрашиваем ввод
            userInput = scanner.nextLine().trim().replaceAll("\\s+", " ");
//      если введен exit, на выход
        } while (!(userInput.isEmpty()));

        return userInput.trim().replaceAll("\\s+", " ");
    }

    public void setVehicleOptionValue(String id, String value) throws IllegalStateException {
//      заполняем список харакетеристик
        Optional<VehicleOption> foundElement = options.stream().filter(obj -> obj.getOptionId().equals(id)).findFirst();
        if (foundElement.isPresent()) {
            foundElement.get().setOptionValue(value);
        } else {
            throw new IllegalStateException("I don`t know vehicle option '" + id + "'. Let`s try again...");
        }
//
    }

    public List<VehicleOption> getVehicleOptions() {
        return options;
    }

    public void describeVehicleOptions() {
//      описываем введенные харакетиристики
        for (VehicleOption option : options) {
            System.out.println("  - " + option.getOptionId() + ": " + option.getOptionValue() + " " + option.getOptionUnit());
        }
        info();
//
    }

    public Vehicle construct(String type) throws IllegalArgumentException {
//      конкретизируем транспорт
        switch (type.toUpperCase()) {
            case "PLANE" -> {
                return new Plane().construct();
            }
            case "CAR" -> {
                return new Car().construct();
            }
            case "BOAT" -> {
                return new Boat().construct();
            }
            case "BICYCLE" -> {
                return new Bicycle().construct();
            }
            default ->
                    throw new IllegalArgumentException("I don`t know vehicle type '" + type + "'. Let`s try again...");
        }
//
    }

    public void run() {
        if (!(getState() == null) & vehicleState.RUNNING.getState() == getState()) {
            System.out.println("The " + getType() + " is already running!");
        } else {
            setState(vehicleState.RUNNING.getState());
            System.out.println("The " + getType() + " is running!");
        }
        info();
    }

    public void stop() {
        if (!(getState() == null) & (getState() == vehicleState.STOPPED.getState())) {
            System.out.println("The " + getType() + " is already stopped!");
        } else {
            setState(vehicleState.STOPPED.getState());
            System.out.println("The " + getType() + " is stopped!");
        }
        info();
    }

    @Override
    public void info() {
        System.out.println();
        System.out.println("You can control a " + getType() +
                " by typing /run, /stop. Or you can reset vehicle by /reset and start from scratch...");
    }
}
