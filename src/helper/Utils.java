package helper;

import java.util.ArrayList;
import java.util.Scanner;
import entities.Traveller;

public class Utils {
    private static Scanner scan = new Scanner(System.in);

    public static String getNameInput() {
        String name = null;
        boolean isNameValid = false;

        while (!isNameValid) {
            try {
                System.out.print("Input Traveler Name (3-30 chars): ");
                name = scan.nextLine();

                if (name.isEmpty()) {
                    throw new IllegalArgumentException("Name cannot be empty!");
                } else if (name.length() < 3 || name.length() > 30) {
                    throw new IllegalArgumentException("The name length should be between 3 and 30 characters.");
                }

                isNameValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage()); // Show the error message
            }
        }

        return name;
    }

    public static Boolean isUniqueName(ArrayList<Traveller> travellers, String nameToCheck){
        for(Traveller traveller : travellers){
            if(traveller.getName().equals(nameToCheck)) return false;
        }
        return true;
    }

    public static Integer getIdInput() {
        Integer id = null;
        boolean isValidId = false;

        while (!isValidId) {
            System.out.print("Enter a valid ID (1-9999): ");
            try {
                if (!scan.hasNextInt()) {
                    throw new IllegalArgumentException("Input must be an integer!");
                }
                id = scan.nextInt();
                scan.nextLine(); 
                
                if (id < 1 || id > 9999) {
                    throw new IllegalArgumentException("ID must be between 1 and 9999.");
                }

                isValidId = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                scan.nextLine(); 
            }
        }

        return id;
    }

    public static void spacer(int n){
        for(int i=0; i<n; i++) System.out.println();
    }

    public static int getIntInput(){
        int input = scan.nextInt();
        scan.nextLine();
        return input;
    }

    public static String getStringInput(){
        return scan.nextLine();
    }

    public static Integer getIntegerInput(){
        Integer input = scan.nextInt();
        scan.nextLine();
        return input;
    }

    public static String delayer(){
        spacer(1);
        System.out.println("Press Enter to continue...");
        return scan.nextLine();
    }

    public static Boolean isAnyTraveller(ArrayList<Traveller> travellers, Integer input){
        for(Traveller traveller : travellers){
            if(traveller.getTravellerID() == input) return true;
        }
        return false;
    }
}
