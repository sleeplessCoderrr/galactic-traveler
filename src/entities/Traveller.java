package entities;

public class Traveller {

	private Integer travelerID;
    private String name;

    public Traveller(Integer travelerID, String name){
        this.travelerID = travelerID;
        this.name = name;
    }

    public Integer getTravellerID() {
        return this.travelerID;
    }

    public String getName(){
        return this.name;
    }

    public void setTravellerID(Integer travelerID){
        this.travelerID = travelerID;
    }

    public void setName(String name){
        this.name = name;
    }

}
