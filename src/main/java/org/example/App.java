package org.example;

import org.example.impls.Car.CarImpl;
import org.example.impls.Car.CarPark;
import org.example.impls.Car.DetailsLists;
import org.example.interfaces.Car;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class App {
    private static List<CarImpl> carPark;
    private static Scanner scanner = new Scanner(System.in);
    private final static ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("/demo.xml");

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(context::close));
        carPark = context.getBean("Array", CarPark.class).nameList;
        printMainMenu();
        System.out.println("До свидания!!!");
    }

    public static void printMainMenu() {

        int result;
        System.out.println("1)Вывести автопарк");
        System.out.println("2)Добавить авто");
        System.out.println("3)Удалить авто");
        System.out.println("4)Выход");
        System.out.print("Ваш выбор:");
        try {
        result = scanner.nextInt();
        switch (result) {
            case 1:
                printAuto(false);
                break;
            case 2:
                addAuto();
                break;
            case 3:
                printAuto(true);
                break;

            case 4:
                return;
            default:
                System.out.println("Ошибка ввода");
                printMainMenu();

        }
        }catch (Exception e){
            System.out.println("Ошибка!!!");
            printMainMenu();
        }

    }

    public static void printAuto(boolean toDelete) {
        int i = 1;
        for (CarImpl car : carPark) {
            if (toDelete) {
                System.out.print(i + ")");
                i++;
            }
            System.out.println(car);
        }
        if (toDelete) {
            deleteAuto();
        } else {
            printMainMenu();
        }

    }

    public static void deleteAuto() {

        int result;
        System.out.print("Ваш выбор:");
            result = scanner.nextInt();
            carPark.remove(result - 1);
            System.out.println("Успешно удалено");
            printMainMenu();


    }

    public static void addAuto() {
        DetailsLists detailsLists = context.getBean("Details", DetailsLists.class);
        CarImpl newCar = new CarImpl();
        int result;
        System.out.println("Имя нового авто:");
        String name = scanner.next();
        newCar.setName(name);
        result = printDetail(detailsLists.engines.iterator());
        newCar.setEngine(detailsLists.engines.get(result-1));
        result = printDetail(detailsLists.bodies.iterator());
        newCar.setBody(detailsLists.bodies.get(result-1));
        result = printDetail(detailsLists.wheels.iterator());
        newCar.setWheels(detailsLists.wheels.get(result-1));
        result = printDetail(detailsLists.batteries.iterator());
        newCar.setBattery(detailsLists.batteries.get(result-1));
        result = printDetail(detailsLists.audioSystems.iterator());
        newCar.setAudioSystem(detailsLists.audioSystems.get(result-1));
        carPark.add(newCar);
        System.out.println("Добавлена:" + newCar);
        printMainMenu();
    }

    public static int printDetail(Iterator details) {
        int i = 1;
        while (details.hasNext()) {
            System.out.println(i + ")" + details.next());
            i++;
        }
        int result;
        System.out.print("Ваш выбор:");
        result = scanner.nextInt();
        return result;
    }
}
