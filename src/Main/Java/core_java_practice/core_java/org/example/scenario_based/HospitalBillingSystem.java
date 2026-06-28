package Main.Java.core_java_practice.core_java.org.example.scenario_based;

import java.util.Scanner;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBillingSystem {

    static void calculateBill(int totalAmount, int items) {
        try {
            int bill = totalAmount / items;
            System.out.println("Bill per item: " + bill);
        } catch (ArithmeticException e) {
            System.out.println("Error: Number of items cannot be zero.");
        } finally {
            System.out.println("Bill calculation completed.");
        }
    }

    static void checkPatient(int[] patients, int index) {
        try {
            System.out.println("Patient ID: " + patients[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid patient index.");
        }
    }

    static void readAge(String age) {
        try {
            int value = Integer.parseInt(age);
            System.out.println("Patient Age: " + value);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format.");
        }
    }

    static void makePayment(double balance, double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Payment failed: Insufficient funds.");
        }
        System.out.println("Payment Successful.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total bill amount: ");
        int total = sc.nextInt();

        System.out.print("Enter number of items: ");
        int items = sc.nextInt();

        calculateBill(total, items);

        int[] patients = {101, 102, 103, 104};

        System.out.print("Enter patient index: ");
        int index = sc.nextInt();

        checkPatient(patients, index);

        sc.nextLine();

        System.out.print("Enter patient age: ");
        String age = sc.nextLine();

        readAge(age);

        System.out.print("Enter account balance: ");
        double balance = sc.nextDouble();

        System.out.print("Enter payment amount: ");
        double payment = sc.nextDouble();

        try {
            makePayment(balance, payment);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}