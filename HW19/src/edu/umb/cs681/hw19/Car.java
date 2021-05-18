package edu.umb.cs681.hw19;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String make, model;
    private int mileage, year;
    private int price;
    private int dominationCount;
    public Car(String make, String model, int mileage, int year, int price) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public int getYear() {
        return year;
    }
    public int getPrice() {
        return price;
    }
    public void setDominationCount(List<Car> cars) {
        for (Car car : cars) {
            if ((car.getPrice() >= this.getPrice()) && (car.getMileage() >= this.getMileage()) && (car.getYear() <= this.getYear())) {
                this.dominationCount++;
            }
        }
        this.dominationCount--;
    }
    public int getDominationCount() {
        return this.dominationCount;
    }

    @Override
    public String toString() {

        return this.make +" "+ this.model+" "+ this.mileage+" "+this.year+" "+this.price;
    }

    public static void main(String args[]) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", "S300", 20, 2018, 20000));
        cars.add(new Car("Audi", "A5", 80, 2017, 25000));
        cars.add(new Car("Toyota", "SUV", 100, 2015, 20000));
        cars.add(new Car("Mercedes", "S300", 60, 2018, 30000));
        cars.add(new Car("Ford", "Jeep", 50, 2018, 15000));

        //min() price with reduce
        int min_cost = cars.stream().parallel().map((Car car) ->car.getPrice() )
                .reduce(1000000000, (result, price)->price>result ? result : price);

        System.out.println("Price of cheapest car is $"+min_cost);

        //max() price with reduce.
        int max_cost = cars.stream().parallel().map((Car car) ->car.getPrice() )
                .reduce(0, (result,price)->result > price ? result : price);

        System.out.println("Price of most expensive car is $"+max_cost);

        //count() with reduce
        int y=0;
        int count = cars.stream().parallel().map(x->y+1).reduce(0,(a,b)->a+b);
        System.out.println("Total number of cars in list:"+count);

    }
}
