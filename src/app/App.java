package app;

import java.util.ArrayList;

import entities.Traveller;
import helper.Utils;

public class App {

    private ArrayList<Traveller> travellerList = new ArrayList<>();

    public void run(){
        while(true){
            menu();
            int input = Utils.getIntInput();
            if(input == 5) break;
            switching(input);
        }
        return;
    }

    private void switching(int input){
        switch (input) {
            case 1:
                createTraveler();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                break;
        }
        return;
    }

    private void menu(){
        System.out.println(">> Galactic Traveler Registry <<");
        System.out.println("1. Register Traveler");
        System.out.println("2. Update Traveler Info");
        System.out.println("3. Delete Traveler Info");
        System.out.println("4. View All Travelers");
        System.out.println("5. Close Registry");
        System.out.print(">> ");

        return;
    }

    private void createTraveler(){
        Utils.spacer(10);
        String name;
        Integer id;

        System.out.print("Input Traveler ID (1-9999): ");
        id = Utils.getIdInput();

        System.out.print("Input Traveler Name (3-30 chars): ");
        name = Utils.getNameInput();

        Traveller traveller = new Traveller(id, name);
        travellerList.add(traveller);

        return;
    }

	
}
