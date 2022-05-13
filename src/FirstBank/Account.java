package FirstBank;

import jdk.swing.interop.SwingInterOpUtils;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Account {
    private String customerId;
    private String customerName;
    private Integer previousTransaction;
    private Double balance = 0.0;
    private Double interests = 0.185;

    public Account(String customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }

    void deposit(Integer amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(Integer amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = - amount;
        }
    }

    void viewPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Your have deposited:  " + Math.abs(previousTransaction));
        } else if (previousTransaction < 0) {
            System.out.println("You have withdrawed: " + Math.abs(previousTransaction));
        } else {
            System.out.println("You have not done anything! What are you waiting for?");
        }
    }

    void calculateInterests(Integer years) {
        System.out.println("The current interest is: " + interests * 100 + "%");
        Double balance1 = balance + interests * balance * years;
        System.out.println("After " + years + ", " + "Your total balance will be: " + balance1);
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerId);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");


        do{
            System.out.println();
            System.out.println("Please enter your option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                case 'A':
                    System.out.println("======================================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("======================================");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    Integer amountToDeposit = scanner.nextInt();
                    this.deposit(amountToDeposit);
                    System.out.println();
                    break;

                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    Integer amountToWithdraw = scanner.nextInt();
                    this.withdraw(amountToWithdraw);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("======================================");
                    this.viewPreviousTransaction();
                    System.out.println("======================================");
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("Enter the amount of years: ");
                    Integer years = scanner.nextInt();
                    this.calculateInterests(years);
                    break;
                case 'F':
                    System.out.println("====================================");
                    break;
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, or E or access services.");
                    break;
            }
        }while(option !='F');
        System.out.println("Thank you for banking with us.");


    }

}
