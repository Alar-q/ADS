import DataStructures.MyHeap;

public class Reader {
    private String fullName;
    private int libraryCardNumber;
    private String faculty;
    private String birthDate;
    private String phoneNumber;

    public Reader(String fullName, int libraryCardNumber, String faculty, String birthDate, String phoneNumber) {
        this.fullName = fullName;
        this.libraryCardNumber = libraryCardNumber;
        this.faculty = faculty;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    public void takeBook(String... bookNames) {
        System.out.print(fullName + " взял книги: ");
        for (String book : bookNames) {
            System.out.print(book + ", ");
        }
        System.out.println();
    }

    public void returnBook(String... bookNames) {
        System.out.print(fullName + " вернул книги: ");
        if (bookNames.length == 0) {
            System.out.print("нет книг");
        } else {
            for (String book : bookNames) {
                System.out.print(book + ", ");
            }
        }
        System.out.println();
    }

    public void returnBook(int numberOfBooks) {
        System.out.println(fullName + " вернул " + numberOfBooks + " книги");
    }
}
class Car {
    protected String brand;
    protected String model;
    protected int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}

class Truck extends Car {
    private int wheelCount;
    private double maxWeight;

    public Truck(String brand, String model, int year, int wheelCount, double maxWeight) {
        super(brand, model, year);
        this.wheelCount = wheelCount;
        this.maxWeight = maxWeight;
    }

    public void newWheels(int wheels) {
        wheelCount = wheels;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Wheel Count: " + wheelCount);
        System.out.println("Max Weight: " + maxWeight);
    }
}

public class Main {

    public static void main(String[] args) {


        String str = "Hello, World!";

        System.out.println(str.charAt(2)); // Третий символ
        System.out.println(str.charAt(str.length() - 2)); // Предпоследний символ
        System.out.println(str.substring(0, 5)); // Первые пять символов
        System.out.println(str.substring(0, str.length() - 2)); // Вся строка, кроме последних двух символов

        for (int i = 0; i < str.length(); i += 2) {
            System.out.print(str.charAt(i)); // Символы с четными индексами
        }
        System.out.println();

        for (int i = 1; i < str.length(); i += 2) {
            System.out.print(str.charAt(i)); // Символы с нечетными индексами
        }
        System.out.println();

        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i)); // Символы в обратном порядке
        }
        System.out.println();

        for (int i = str.length() - 1; i >= 0; i -= 2) {
            System.out.print(str.charAt(i)); // Символы через один в обратном порядке
        }
        System.out.println();

        System.out.println(str.length()); // Длина строки
    }

}