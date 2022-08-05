package ethicalengine;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * description: Scenario
 * contains all relevant information about a presented scenario
 * @author: delongh
 */
public class Scenario {

    private ArrayList<Persona> passengersList = new ArrayList<>();

    private ArrayList<Persona> pedestriansList = new ArrayList<>();

    public void setLegalCrossing(boolean legalCrossing) {
        isLegalCrossing = legalCrossing;
    }

    private boolean isLegalCrossing = false;

    public Scenario(Persona[] passengers, Persona[] pedestrians, boolean isLegalCrossing) {
        passengersList.addAll(Arrays.asList(passengers));
        pedestriansList.addAll(Arrays.asList(pedestrians));
        this.isLegalCrossing = isLegalCrossing;
    }

    public boolean hasYouInCar() {
    	for(int i=0;i<this.passengersList.size();i++) {
    		if(this.passengersList.get(i).isYou())
    			return true;
    	}
        return false;
    }

    public boolean hasYouInLane() {
    	for(int i=0;i<this.pedestriansList.size();i++)
    		if(this.pedestriansList.get(i).isYou())
    			return true;
        return false;
    }

    public Persona[] getPassengers() {
        return passengersList.toArray(new Persona[0]);
    }

    public Persona[] getPedestrians() {
        return pedestriansList.toArray(new Persona[0]);
    }

    public boolean isLegalCrossing() {
        return this.isLegalCrossing;
    }

    public int getPassengerCount() {
        return this.passengersList.size();
    }

    public int getPedestrianCount() {
        return this.pedestriansList.size();
    }

    public ArrayList<Persona> getPassengersList() {
        return passengersList;
    }

    public ArrayList<Persona> getPedestriansList() {
        return pedestriansList;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("======================================");
        result.append("\n");

        result.append("# Scenario");
        result.append("\n");

        result.append("======================================");
        result.append("\n");

        result.append("Legal Crossing: ");
        if (isLegalCrossing) {
            result.append("yes");
        } else {
            result.append("no");
        }
        result.append("\n");

        result.append("Passengers ").append("(").append(this.getPassengerCount()).append(")").append("\n");

        for (int i=0;i<this.passengersList.size();i++) {
                result.append("- ");
                result.append(this.passengersList.get(i).toString());
                result.append("\n");
        }

        result.append("Pedestrians ").append("(").append(this.getPedestrianCount()).append(")").append("\n");

        for (int i=0;i<this.pedestriansList.size();i++) {
            result.append("- ");
            result.append(this.pedestriansList.get(i).toString());
            result.append("\n");
        }

        return result.deleteCharAt(result.length()-1).toString();
    }




}
