package org.example;

import java.util.Scanner;

public class Descriptor extends VehicleDescriptor {
    @Override
    public void info() {
        super.info();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Let`s construct a vehicle! Choose and type one of types: plane, boat, car, bicycle...");
    }

    //  основная функция работы
    public void construct() {
//      вызов справки
        this.info();
//      создание объекта ввода и строки
        Scanner scanner = new Scanner(System.in);
        String userInput = null;
//      в цикле, пока пользователь не введет exit, обрабатываем ввод пользователя
        do {
//          если строка ввода непустая, обрабатываем
            if (!(userInput == null)) {
                if (!(userInput.isEmpty())) {
//                  если пользователь ввел ? , выводим справку
                    if (userInput.equals("?")) {
                        info();
//                  иначе запускаем конструктор
                    } else {
                        try {
//                          конструируем vehicle
                            Vehicle vehicle = new Vehicle().construct(userInput.trim().replaceAll("\\s+", " "));
//                          описываем что получилось
                            vehicle.describeVehicleOptions();
//                          предлгаем запустить /run или /stop
                            userInput = null;
                            do {
                                if (!(userInput == null)) {
                                    if (userInput.equals("/run")) {
                                        vehicle.run();
                                    } else if (userInput.equals("/stop")) {
                                        vehicle.stop();
                                    } else {
                                        System.out.println("Unknown command '" + userInput + "' .Enter your choice:");
                                    }
                                }
                                userInput = scanner.nextLine().trim().replaceAll("\\s+", " ");
                            } while (!userInput.equals("/reset") & !userInput.equals("/exit"));
//                          если пользователь вышел по /reset, начинаем заново, иначе выход
                            if (userInput.equals("/reset")) {
                                info();
                            } else {
                                break;
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
        } while (!userInput.equals("/exit"));
//
        System.out.println("Vehicle constructor v1 is stopped");
    }
}
