package app;

import java.util.ArrayList;

import entities.Traveller;
import helper.Utils;

public class App {

    private ArrayList<Traveller> travellerList = new ArrayList<>();

    public void run(){
        while(true){
            Utils.spacer(20);
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
                updateTraveller();
                break;
            case 3:
                deleteTraveller();
                break;
            case 4:
                showAllTravelers();
                Utils.delayer();
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
        Utils.spacer(20);
        String name;
        Integer id;

        id = Utils.getIdInput();
        name = Utils.getNameInput();

        if(Utils.isUniqueName(travellerList, name)){
            Traveller traveller = new Traveller(id, name);
            travellerList.add(traveller);
            return;
        } else {
            System.out.println("Name Already Taken!");
            Utils.delayer();
        }

        return;
    }

    private void showAllTravelers(){
        Utils.spacer(20);
        if(travellerList.size() == 0) {
            System.out.println("=====================================================");
            System.out.println("||              No Traveler Registered             ||");
            System.out.println("=====================================================");
        } else {
            int i = 1;
            System.out.println("=================================================");
            System.out.printf("|| %-3s | %-12s | %-22s ||\n", "No", "Traveller ID", "Traveller Name");
            System.out.println("=================================================");
            for(Traveller traveller :  travellerList){
                System.out.printf("|| %-3d | %-12d | %-22s ||\n", i, traveller.getTravellerID(), traveller.getName());
                i++;
            }
            System.out.println("=================================================");
        } 
        return;
    }

    private void updateTraveller(){
        Utils.spacer(20);
        if(travellerList.size()==0){
            System.out.println("=====================================================");
            System.out.println("||              No Traveler Registered             ||");
            System.out.println("=====================================================");
            Utils.delayer();
            return;
        } else {
            showAllTravelers();
            Utils.spacer(1);
            System.out.print("Which traveler do you want to update? (Enter 0 to return to the main menu): ");
            Integer id = Utils.getIntegerInput();
            if(Utils.isAnyTraveller(travellerList, id)){
                System.out.print("Input new Traveler ID (1-9999): ");
                Integer newId = Utils.getIdInput();
                for(Traveller traveller : travellerList){
                    if(traveller.getTravellerID() == id){
                        traveller.setTravellerID(newId);
                    }
                }
                Utils.spacer(20);
                System.out.println("Traveler Updated!");
                for(Traveller traveller : travellerList){
                    if(traveller.getTravellerID() == newId){
                        System.out.println("============================================");
                        System.out.printf("|| %-12s | %-22s ||\n",  "Traveller ID", "Traveller Name");
                        System.out.println("============================================");
                        System.out.printf("|| %-12d | %-22s ||\n", traveller.getTravellerID(), traveller.getName());
                        System.out.println("============================================");
                    }
                }
                Utils.delayer();
            } else {
                System.out.println("No traveller found!");
                Utils.delayer();
                return;
            }
        }
        return;
    }

    private void deleteTraveller(){
        Utils.spacer(20);
        if(travellerList.size()==0){
            System.out.println("=====================================================");
            System.out.println("||              No Traveler Registered             ||");
            System.out.println("=====================================================");
            Utils.delayer();
            return;
        } else {
            showAllTravelers();
            Utils.spacer(1);
            System.out.print("Which traveler do you want to delete? (Enter 0 to return to the main menu): ");
            Integer id = Utils.getIntegerInput();
            if(Utils.isAnyTraveller(travellerList, id)){
                for(int i=0; i<travellerList.size(); i++){
                    if(travellerList.get(i).getTravellerID() == id){
                        travellerList.remove(i);
                    }
                }
                System.out.println("Traveller deleted!");
                Utils.delayer();
            } else {
                System.out.println("No traveller found!");
                Utils.delayer();
                return;
            }
        }
        return;
    }
	
}
