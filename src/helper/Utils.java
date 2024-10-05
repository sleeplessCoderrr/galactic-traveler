package helper;

import java.util.ArrayList;
import java.util.Scanner;
import entities.Traveller;

public class Utils {
    private static Scanner scan = new Scanner(System.in);

    public static String getNameInput(){
        String name = null;
        Boolean isNameValid = false;
        while(!isNameValid){
            try {
                name = scan.nextLine();
                if(name.isEmpty()){
                    throw new IllegalArgumentException("Cannot be empty!");
                } else if(name.length() < 3 || name.length() > 30){
                    throw new IllegalArgumentException("The length should between 3 and 30 characters: ");
                }
                isNameValid = true;
            } catch (Exception e) {
                e.printStackTrace();
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

    public static Integer getIdInput(){
        Integer id = null;
        Boolean isValidId = false;
        while(!isValidId){
            try {
                id = scan.nextInt();
                scan.nextLine();
                if(id < 1 || id > 9999){
                    throw new IllegalArgumentException("ID must between 1 and 9999");
                }
                isValidId = true;
            } catch (Exception e) {
               e.printStackTrace();
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

    public static String delayer(){
        spacer(1);
        System.out.println("Press Enter to continue...");
        return scan.nextLine();
    }

    public static Boolean isAnyTraveller(ArrayList<Traveller> travellers, String text){
        for(Traveller traveller : travellers){
            if(traveller.getName().equals(text)) return true;
        }
        return false;
    }
}
