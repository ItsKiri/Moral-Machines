import ethicalengine.*;


import java.io.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * description: Audit
 * inspection of algorithm
 * @author: delongh
 */
public class Audit extends Human implements Serializable {
	
    private String auditType = "User";

    public static StringBuilder getResult() {
        return result;
    }

    public void setResult(StringBuilder result) {
        this.result = result;
    }

    private static StringBuilder result = new StringBuilder();

    public Audit(){
        ScenarioGenerator scenarioGenerator = new ScenarioGenerator(47);
        Scenario generate = scenarioGenerator.generate();
    }

    public void setAuditType(String name){
        auditType = name;
    }

    public String getAuditType(){
        return auditType;
    }

    public void run(ArrayList<Scenario> list, ArrayList<String> whosaved){
    	result = new StringBuilder();

        int totalAge = 0;
        
        int totalBaby = 0;
        int totalChild = 0;
        int totalAdult = 0;
        int totalSenior = 0;

        int totalAverage = 0;
        int totalAthletic = 0;
        int totalOverweight = 0;

        int totalFemale = 0;
        int totalMale = 0;
        
        int totalPassenger = 0;
        int totalPedestrian = 0;


        int liveGreen=0;
        int totalGreen=0;
        int liveRed=0;
        int totalRed=0;

        int totalDoctor =0 ;
        int totalCeo = 0;
        int totalCriminal = 0;
        int totalHomeless = 0;
        int totalUnemployed = 0;
        int totalDriver= 0;
        int totalChef = 0;
        
        int totalPregnant = 0;
        
        int totalHuman = 0;
        int totalAnimal = 0;
        
        int totalCat = 0;
        int totalDog = 0;
        int totalBird = 0;
        int totalFerret = 0;
        
        int totalPet = 0;
        
        int liveBaby = 0;
        int liveChild = 0;
        int liveAdult = 0;
        int liveSenior = 0;

        int liveAverage = 0;
        int liveAthletic = 0;
        int liveOverweight = 0;

        int liveFemale = 0;
        int liveMale = 0;
        
        int livePassenger = 0;
        int livePedestrian = 0;

        int liveDoctor =0 ;
        int liveCeo = 0;
        int liveCriminal = 0;
        int liveHomeless = 0;
        int liveUnemployed = 0;
        int liveDriver= 0;
        int liveChef = 0;
        
        int livePregnant = 0;
        
        int liveHuman = 0;
        int liveAnimal = 0;
        
        int liveCat = 0;
        int liveDog = 0;
        int liveBird = 0;
        int liveFerret = 0;
        
        int livePet = 0;
        
        int liveYou = 0;
        int totalYou = 0;


        for (int i=0;i<list.size();i++) {
            ArrayList<Persona> passengersList = list.get(i).getPassengersList();
            ArrayList<Persona> pedestriansList = list.get(i).getPedestriansList();
            totalPassenger = totalPassenger+passengersList.size();
            totalPedestrian = totalPedestrian+pedestriansList.size();


            
            if(whosaved.get(i).equals("PASSENGERS")) {
            		livePassenger = livePassenger + passengersList.size();
            for(Persona persona : passengersList) {
            	if(list.get(i).isLegalCrossing()) {
            		liveGreen++;
            		totalGreen++;
            	}
            	else {
            		liveRed++;
            		totalRed++;
            	}
            	if(persona instanceof Animal) {
            		liveAnimal = liveAnimal + 1;
            		totalAnimal = totalAnimal +1;
            		if(persona.getSpecies().equals("cat")) {
            			liveCat = liveCat + 1;
            			totalCat=totalCat+1;}
            		else if(persona.getSpecies().equals("dog")) {
            			totalDog=totalDog+1;
            			liveDog = liveDog + 1;
            		}
            		else if(persona.getSpecies().equals("bird")) {
            			totalBird=totalBird+1;
            			liveBird = liveBird + 1;
            		}
            		else {
            			liveFerret = liveFerret + 1;
            			totalFerret=totalFerret+1;
            		}
            		if(persona.isPet()) {
            			totalPet++;
            			livePet = livePet+1;
            		}
            	}
            	else if(persona instanceof Human) {
            		liveHuman=liveHuman+1;
            		totalHuman++;
            		if(persona.isYou()) {
            			liveYou++;
            			totalYou++;
            		}
            		if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("baby")) {
            			totalBaby++;
            			liveBaby++;
            		}
            		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("adult")) {
            			totalAdult++;
            			liveAdult++;
            		}
            		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("child")) {
            			totalChild++;
            			liveChild++;
            		}
            		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("senior")) {
            			totalSenior++;
            			liveSenior++;
            		}
            		if(((Human) persona).getProfession().toString().equalsIgnoreCase("doctor")) {
            			totalDoctor++;
            			liveDoctor=liveDoctor+1;
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("ceo")) {
            			totalCeo++;
            			liveCeo=liveCeo+1;
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("criminal")) {
            			totalCriminal++;
            			liveCriminal=liveCriminal+1;
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("homeless")) {
            			totalHomeless++;
            			liveHomeless++;
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("unemployed")) {
            			totalUnemployed++;
            			liveUnemployed++;
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("driver")) {
            			liveDriver++;
            			totalDriver++;
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("chef")) {
            			totalChef++;
            			liveChef++;
            		}
            		if(((Human) persona).isPregnant()) {
            			totalPregnant++;
            			livePregnant++;
            		}
            		
            	
            	totalAge = totalAge+ ((Human) persona).getAge();
            	if(((Human) persona).getGender().toString().equalsIgnoreCase("male")) {
            		totalMale++;
            		liveMale++;
            	}
            	else if(((Human) persona).getGender().toString().equalsIgnoreCase("female")) {
            		totalFemale++;
            		liveFemale++;
            	}
            	if(((Human) persona).getBodyType().toString().equalsIgnoreCase("average")) {
            		totalAverage++;
            		liveAverage++;
            	}
            	else if(((Human) persona).getBodyType().toString().equalsIgnoreCase("overweight")) {
            		totalOverweight++;
            		liveOverweight++;
            	}
            	else if(((Human) persona).getBodyType().toString().equalsIgnoreCase("athletic")) {
            		totalAthletic++;
            		liveAthletic++;
            	}
            	}
            }
            
            for (Persona persona : pedestriansList) {
            	if(list.get(i).isLegalCrossing()) {
  
            		totalGreen++;
            	}
            	else {
    
            		totalRed++;
            	}

            	if(persona instanceof Animal) {

            		totalAnimal = totalAnimal +1;
            		if(persona.getSpecies().equals("cat")) {

            			totalCat=totalCat+1;}
            		else if(persona.getSpecies().equals("dog")) {
            			totalDog=totalDog+1;
 
            		}
            		else if(persona.getSpecies().equals("bird")) {
            			totalBird=totalBird+1;
            		
            		}
            		else {
            	
            			totalFerret=totalFerret+1;
            		}
            		if(persona.isPet()) {
            			totalPet++;
            
            		}
            	}
            	else if(persona instanceof Human) {
            		totalHuman++;
            		if(persona.isYou())
            			totalYou++;
            		if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("baby")) {
            			totalBaby++;
 
            		}
            		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("adult")) {
            			totalAdult++;
       
            		}
            		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("child")) {
            			totalChild++;
      
            		}
            		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("senior")) {
            			totalSenior++;
          
            		}
            		if(((Human) persona).getProfession().toString().equalsIgnoreCase("doctor")) {
            			totalDoctor++;
            
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("ceo")) {
            			totalCeo++;
          
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("criminal")) {
            			totalCriminal++;
           
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("homeless")) {
            			totalHomeless++;
      
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("unemployed")) {
            			totalUnemployed++;
           
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("driver")) {
          
            			totalDriver++;
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("chef")) {
            			totalChef++;
           
            		}
            		if(((Human) persona).isPregnant()) {
            			totalPregnant++;
          
            		}
            		
            	
            	if(((Human) persona).getGender().toString().equalsIgnoreCase("male")) {
            		totalMale++;
   
            	}
            	else if(((Human) persona).getGender().toString().equalsIgnoreCase("female")) {
            		totalFemale++;
       
            	}
            	if(((Human) persona).getBodyType().toString().equalsIgnoreCase("average")) {
            		totalAverage++;
       
            	}
            	else if(((Human) persona).getBodyType().toString().equalsIgnoreCase("overweight")) {
            		totalOverweight++;
      
            	}
            	else if(((Human) persona).getBodyType().toString().equalsIgnoreCase("athletic")) {
            		totalAthletic++;
            	}
            	}
            }
            }
            else if(whosaved.get(i).equals("PEDESTRIANS")) {

    		livePedestrian = livePedestrian + pedestriansList.size();
    for(Persona persona : pedestriansList) {
    	if(list.get(i).isLegalCrossing()) {
    		liveGreen++;
    		totalGreen++;
    	}
    	else {
    		liveRed++;
    		totalRed++;
    	}
    	if(persona instanceof Animal) {
    		liveAnimal = liveAnimal + 1;
    		totalAnimal = totalAnimal +1;
    		if(persona.getSpecies().equals("cat")) {
    			liveCat = liveCat + 1;
    			totalCat=totalCat+1;}
    		else if(persona.getSpecies().equals("dog")) {
    			totalDog=totalDog+1;
    			liveDog = liveDog + 1;
    		}
    		else if(persona.getSpecies().equals("bird")) {
    			totalBird=totalBird+1;
    			liveBird = liveBird + 1;
    		}
    		else {
    			liveFerret = liveFerret + 1;
    			totalFerret=totalFerret+1;
    		}
    		if(persona.isPet()) {
    			totalPet++;
    			livePet = livePet+1;
    		}
    	}
    	else if(persona instanceof Human) {
    		liveHuman=liveHuman+1;
    		totalHuman++;
    		if(persona.isYou()) {
    			totalYou++;
    			liveYou++;
    		}
    		if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("baby")) {
    			totalBaby++;
    			liveBaby++;
    		}
    		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("adult")) {
    			totalAdult++;
    			liveAdult++;
    		}
    		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("child")) {
    			totalChild++;
    			liveChild++;
    		}
    		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("senior")) {
    			totalSenior++;
    			liveSenior++;
    		}
    		if(((Human) persona).getProfession().toString().equalsIgnoreCase("doctor")) {
    			totalDoctor++;
    			liveDoctor=liveDoctor+1;
    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("ceo")) {
    			totalCeo++;
    			liveCeo=liveCeo+1;
    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("criminal")) {
    			totalCriminal++;
    			liveCriminal=liveCriminal+1;
    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("homeless")) {
    			totalHomeless++;
    			liveHomeless++;
    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("unemployed")) {
    			totalUnemployed++;
    			liveUnemployed++;
    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("driver")) {
    			liveDriver++;
    			totalDriver++;
    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("chef")) {
    			totalChef++;
    			liveChef++;
    		}
    		if(((Human) persona).isPregnant()) {
    			totalPregnant++;
    			livePregnant++;
    		}
    		
    	
    	totalAge = totalAge+ ((Human) persona).getAge();
    	if(((Human) persona).getGender().toString().equalsIgnoreCase("male")) {
    		totalMale++;
    		liveMale++;
    	}
    	else if(((Human) persona).getGender().toString().equalsIgnoreCase("female")) {
    		totalFemale++;
    		liveFemale++;
    	}
    	if(((Human) persona).getBodyType().toString().equalsIgnoreCase("average")) {
    		totalAverage++;
    		liveAverage++;
    	}
    	else if(((Human) persona).getBodyType().toString().equalsIgnoreCase("overweight")) {
    		totalOverweight++;
    		liveOverweight++;
    	}
    	else if(((Human) persona).getBodyType().toString().equalsIgnoreCase("athletic")) {
    		totalAthletic++;
    		liveAthletic++;
    	}
    	}
    }
    
    for (Persona persona : passengersList) {
    	if(list.get(i).isLegalCrossing()) {
 
    		totalGreen++;
    	}
    	else {

    		totalRed++;
    	}

    	if(persona instanceof Animal) {

    		totalAnimal = totalAnimal +1;
    		if(persona.getSpecies().equals("cat")) {

    			totalCat=totalCat+1;}
    		else if(persona.getSpecies().equals("dog")) {
    			totalDog=totalDog+1;

    		}
    		else if(persona.getSpecies().equals("bird")) {
    			totalBird=totalBird+1;
    		
    		}
    		else {
    	
    			totalFerret=totalFerret+1;
    		}
    		if(persona.isPet()) {
    			totalPet++;
    
    		}
    	}
    	else if(persona instanceof Human) {
    		totalHuman++;
    		if(persona.isYou())
    			totalYou++;
    		if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("baby")) {
    			totalBaby++;
   
    		}
    		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("adult")) {
    			totalAdult++;
    
    		}
    		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("child")) {
    			totalChild++;
  
    		}
    		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("senior")) {
    			totalSenior++;
 
    		}
    		if(((Human) persona).getProfession().toString().equalsIgnoreCase("doctor")) {
    			totalDoctor++;
    
    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("ceo")) {
    			totalCeo++;
  
    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("criminal")) {
    			totalCriminal++;
   
    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("homeless")) {
    			totalHomeless++;

    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("unemployed")) {
    			totalUnemployed++;
   
    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("driver")) {
  
    			totalDriver++;
    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("chef")) {
    			totalChef++;
   
    		}
    		if(((Human) persona).isPregnant()) {
    			totalPregnant++;
  
    		}
    		
    	
    		if(((Human) persona).getGender().toString().equalsIgnoreCase("male")) {
    		totalMale++;

    	}
    	else if(((Human) persona).getGender().toString().equalsIgnoreCase("female")) {
    		totalFemale++;

    	}
    	if(((Human) persona).getBodyType().toString().equalsIgnoreCase("average")) {
    		totalAverage++;

    	}
    	else if(((Human) persona).getBodyType().toString().equalsIgnoreCase("overweight")) {
    		totalOverweight++;

    	}
    	else if(((Human) persona).getBodyType().toString().equalsIgnoreCase("athletic")) {
    		totalAthletic++;
    	}
    	}
    }
            }
    }


        
        


        
       
        

        result.append("======================================\n");
        result.append("# "+this.auditType+" Audit\n");
        result.append("======================================\n");
        result.append("- % SAVED AFTER ");
        result.append(list.size());
        result.append(" RUNS\n");
        if(totalAverage!=0) {
            float aveAverage = (float)liveAverage/(float)totalAverage;
            result.append("average: ").append(String.format("%.2f",aveAverage)).append("\n");
        }
        if(totalAthletic!=0) {
            float aveAthletic = (float)liveAthletic/(float)totalAthletic;
            result.append("athletic: ").append(String.format("%.2f",aveAthletic)).append("\n");
        }
        if(totalOverweight!=0) {
            float aveOverweight = (float)liveOverweight/(float)totalOverweight;
            result.append("overweight: ").append(String.format("%.2f",aveOverweight)).append("\n");
        }
        
        if(totalBaby!=0) {
            float aveBaby = (float)liveBaby/(float)totalBaby;
            result.append("baby: ").append(String.format("%.2f",aveBaby)).append("\n");
        }
        if(totalChild!=0) {
            float aveChild = (float)liveChild/(float)totalChild;
            result.append("child: ").append(String.format("%.2f",aveChild)).append("\n");
        }
        if(totalAdult!=0) {
            float aveAdult = (float)liveAdult/(float)totalAdult;
            result.append("adult: ").append(String.format("%.2f",aveAdult)).append("\n");
        }
        if(totalSenior!=0) {
            float aveSenior = (float)liveSenior/(float)totalSenior;
            result.append("senior: ").append(String.format("%.2f",aveSenior)).append("\n");
        }
        if(totalFemale!=0) {
            float aveFemale = (float)liveFemale/(float)totalFemale;
            result.append("female: ").append(String.format("%.2f",aveFemale)).append("\n");
        }
        if(totalMale!=0) {
            float aveMale = (float)liveMale/(float)totalMale;
            result.append("male: ").append(String.format("%.2f",aveMale)).append("\n");
        }
        if(totalDoctor!=0) {
            float aveDoctor = (float)liveDoctor/(float)totalDoctor;
            result.append("doctor: ").append(String.format("%.2f",aveDoctor)).append("\n");
        }
        if(totalCeo!=0) {
            float aveCeo = (float)liveCeo/(float)totalCeo;
            result.append("ceo: ").append(String.format("%.2f",aveCeo)).append("\n");
        }
        if(totalChef!=0) {
            float aveChef = (float)liveChef/(float)totalChef;
            result.append("chef: ").append(String.format("%.2f",aveChef)).append("\n");
        }
        if(totalCriminal!=0) {
            float aveCriminal = (float)liveCriminal/(float)totalCriminal;
            result.append("criminal: ").append(String.format("%.2f",aveCriminal)).append("\n");
        }
        if(totalHomeless!=0) {
            float aveHomeless = (float)liveHomeless/(float)totalHomeless;
            result.append("homeless: ").append(String.format("%.2f",aveHomeless)).append("\n");
        }
        if(totalDriver!=0) {
            float aveDriver = (float)liveDriver/(float)totalDriver;
            result.append("driver: ").append(String.format("%.2f",aveDriver)).append("\n");
        }
        if(totalUnemployed!=0) {
            float aveUnemployed = (float)liveUnemployed/(float)totalUnemployed;
            result.append("unemployed: ").append(String.format("%.2f",aveUnemployed)).append("\n");
        }
        if(totalPregnant!=0) {
            float avePregnant = (float)livePregnant/(float)totalPregnant;
            result.append("pregnant: ").append(String.format("%.2f",avePregnant)).append("\n");
        }
        if(totalHuman!=0) {
            float aveHuman = (float)liveHuman/(float)totalHuman;
            result.append("human: ").append(String.format("%.2f",aveHuman)).append("\n");
        }
        if(totalAnimal!=0) {
            float aveAnimal = (float)liveAnimal/(float)totalAnimal;
            result.append("animal: ").append(String.format("%.2f",aveAnimal)).append("\n");
        }
        if(totalCat!=0) {
            float aveCat = (float)liveCat/(float)totalCat;
            result.append("cat: ").append(String.format("%.2f",aveCat)).append("\n");
        }
        if(totalDog!=0) {
            float aveDog = (float)liveDog/(float)totalDog;
            result.append("dog: ").append(String.format("%.2f",aveDog)).append("\n");
        }
        if(totalBird!=0) {
            float aveBird = (float)liveBird/(float)totalBird;
            result.append("bird: ").append(String.format("%.2f",aveBird)).append("\n");
        }
        if(totalFerret!=0) {
            float aveFerret = (float)liveFerret/(float)totalFerret;
            result.append("ferret: ").append(String.format("%.2f",aveFerret)).append("\n");
        }
        if(totalPet!=0) {
            float avePet = (float)livePet/(float)totalPet;
            result.append("pet: ").append(String.format("%.2f",avePet)).append("\n");
        }
        if(totalGreen!=0) {
            float aveGreen = (float)liveGreen/(float)totalGreen;
            result.append("green: ").append(String.format("%.2f",aveGreen)).append("\n");
        }
        if(totalRed!=0) {
            float aveRed = (float)liveRed/(float)totalRed;
            result.append("red: ").append(String.format("%.2f",aveRed)).append("\n");
        }




        if(totalPassenger!=0) {
            float avePassenger = (float)livePassenger/(float)totalPassenger;
            result.append("passengers: ").append(String.format("%.2f",avePassenger)).append("\n");
        }
        if(totalPedestrian!=0) {
            float avePedestrian = (float)livePedestrian/(float)totalPedestrian;
            result.append("pedestrians: ").append(String.format("%.2f",avePedestrian)).append("\n");
        }
        


        if(totalYou!=0) {
            float aveYou = (float)liveYou/(float)totalYou;
            result.append("you: ").append(String.format("%.2f",aveYou)).append("\n");
        }

        result.append("--\n");
        if(liveHuman!=0) {
            float aveAge = (float)totalAge/(float)liveHuman;
            result.append("average age: ").append(String.format("%.2f",aveAge)).append("\n");
        }
        else {
        	result.append("average age: ").append(String.format("%.2f",0.00)).append("\n");
        }

        }
    
    public void run(int runCount) {
    	result = new StringBuilder();

    	int totalAge = 0;
            int num = 1;

            int totalAverage = 0;
            int totalAthletic = 0;
            int totalOverweight = 0;
            int totalUnspecified = 0;

            int totalFemale = 0;
            int totalMale = 0;
            int totalUnknown = 0;


            int liveAverage = 0;
            int liveAthletic = 0;
            int liveOverweight = 0;
            int liveUnspecified = 0;

            int liveFemale = 0;
            int liveMale = 0;
            int liveUnknown = 0;

            if (runCount<=0){
                runCount = 5;
            }
                ScenarioGenerator scenarioGenerator = new ScenarioGenerator();
                Scenario generate = scenarioGenerator.generate(3, 5);
                ArrayList<Persona> passengersList = generate.getPassengersList();
                ArrayList<Persona> pedestriansList = generate.getPedestriansList();


                for (Persona persona : passengersList) {

                    totalAge = totalAge +persona.getAge();
                    num = num +1;

                    BodyType bodyType = persona.getBodyType();
                    if (bodyType.toString().equals("AVERAGE")){
                        totalAverage ++;
                    }
                    if (bodyType.toString().equals("ATHLETIC")){
                        totalAthletic ++;
                    }
                    if (bodyType.toString().equals("OVERWEIGHT")){
                        totalOverweight ++;
                    }
                    if (bodyType.toString().equals("UNSPECIFIED")){
                        totalUnspecified ++;
                    }

                    String gender = persona.getGender().toString();
                    System.out.println(gender);
                    if (gender.equals("FEMALE")){
                        totalFemale++;
                    }
                    if (gender.equals("MALE")){
                        totalMale++;
                    }
                    if (gender.equals("UNKNOWN")){
                        totalUnknown++;
                    }
                }


                for (Persona persona : pedestriansList) {

                    totalAge = totalAge +persona.getAge();
                    num = num +1;

                    BodyType bodyType = persona.getBodyType();
                    if (bodyType.toString().equals("AVERAGE")){
                        totalAverage ++;
                    }
                    if (bodyType.toString().equals("ATHLETIC")){
                        totalAthletic ++;
                    }
                    if (bodyType.toString().equals("OVERWEIGHT")){
                        totalOverweight ++;
                    }
                    if (bodyType.toString().equals("UNSPECIFIED")){
                        totalUnspecified ++;
                    }

                    String gender = persona.getGender().toString();
                    if (gender.equals("FEMALE")){
                        totalFemale++;
                    }
                    if (gender.equals("MALE")){
                        totalMale++;
                    }
                    if (gender.equals("UNKNOWN")){
                        totalUnknown++;
                    }
                }


                String decide = "PEDESTRIANS";
                System.out.println(decide.toString());
                if (decide.toString().equals("PEDESTRIANS")){
                    for (Persona persona : pedestriansList) {

                        BodyType bodyType = persona.getBodyType();
                        if (bodyType.toString().equals("AVERAGE")){
                            liveAverage ++;
                        }
                        if (bodyType.toString().equals("ATHLETIC")){
                            liveAthletic ++;
                        }
                        if (bodyType.toString().equals("OVERWEIGHT")){
                            liveOverweight ++;
                        }
                        if (bodyType.toString().equals("UNSPECIFIED")){
                            liveUnspecified ++;
                        }

                        String gender = persona.getGender().toString();
                        if (gender.equals("FEMALE")){
                            liveFemale++;
                        }
                        if (gender.equals("FEMALE")){
                            liveMale++;
                        }
                        if (gender.equals("FEMALE")){
                            liveUnknown++;
                        }
                    }
                }else {
                    for (Persona persona : passengersList) {
       
                        BodyType bodyType = persona.getBodyType();
                        if (bodyType.toString().equals("AVERAGE")){
                            liveAverage ++;
                        }
                        if (bodyType.toString().equals("ATHLETIC")){
                            liveAthletic ++;
                        }
                        if (bodyType.toString().equals("OVERWEIGHT")){
                            liveOverweight ++;
                        }
                        if (bodyType.toString().equals("UNSPECIFIED")){
                            liveUnspecified ++;
                        }

                        String gender = persona.getGender().toString();
                        if (gender.equals("FEMALE")){
                            liveFemale++;
                        }
                        if (gender.equals("FEMALE")){
                            liveMale++;
                        }
                        if (gender.equals("FEMALE")){
                            liveUnknown++;
                        }
                    }
                }


                double aveAge = totalAge/num;

                double aveAverage = liveAverage/num;
                double aveAthletic = liveAthletic/num;
                double aveOverweight = liveOverweight/num;
                double aveUnspecified = liveUnspecified/num;

                double aveFemale = liveFemale/num;
                double aveMale = liveMale/num;
                double aveUnknown = liveUnknown/num;




                result.append("======================================\n");
                result.append("# Algorithm Audit\n");
                result.append("======================================\n");
                result.append("- % SAVED AFTER ");
                result.append(runCount);
                result.append(" RUNS\n");
                result.append("average: ").append(String.format("%.2f",aveAverage)).append("\n");
                result.append("athletic: ").append(String.format("%.2f",aveAthletic)).append("\n");
                result.append("overweight: ").append(String.format("%.2f",aveOverweight)).append("\n");
                result.append("unspecified: ").append(String.format("%.2f",aveUnspecified)).append("\n");
                result.append("female: ").append(String.format("%.2f",aveFemale)).append("\n");
                result.append("male: ").append(String.format("%.2f",aveMale)).append("\n");
                result.append("unknown: ").append(String.format("%.2f",aveUnknown)).append("\n");
                result.append("--\n");
                result.append("average age: ").append(String.format("%.2f",aveAge)).append("\n");
            
        }
    
    public void run(ArrayList<Scenario> list, ArrayList<String> whosaved, int runCount){
    	result = new StringBuilder();

        int totalAge = 0;
        
        int totalBaby = 0;
        int totalChild = 0;
        int totalAdult = 0;
        int totalSenior = 0;

        int totalAverage = 0;
        int totalAthletic = 0;
        int totalOverweight = 0;

        int totalFemale = 0;
        int totalMale = 0;
        
        int totalPassenger = 0;
        int totalPedestrian = 0;


        int liveGreen=0;
        int totalGreen=0;
        int liveRed=0;
        int totalRed=0;

        int totalDoctor =0 ;
        int totalCeo = 0;
        int totalCriminal = 0;
        int totalHomeless = 0;
        int totalUnemployed = 0;
        int totalDriver= 0;
        int totalChef = 0;
        
        int totalPregnant = 0;
        
        int totalHuman = 0;
        int totalAnimal = 0;
        
        int totalCat = 0;
        int totalDog = 0;
        int totalBird = 0;
        int totalFerret = 0;
        
        int totalPet = 0;
        
        int liveBaby = 0;
        int liveChild = 0;
        int liveAdult = 0;
        int liveSenior = 0;

        int liveAverage = 0;
        int liveAthletic = 0;
        int liveOverweight = 0;

        int liveFemale = 0;
        int liveMale = 0;
        
        int livePassenger = 0;
        int livePedestrian = 0;

        int liveDoctor =0 ;
        int liveCeo = 0;
        int liveCriminal = 0;
        int liveHomeless = 0;
        int liveUnemployed = 0;
        int liveDriver= 0;
        int liveChef = 0;
        
        int livePregnant = 0;
        
        int liveHuman = 0;
        int liveAnimal = 0;
        
        int liveCat = 0;
        int liveDog = 0;
        int liveBird = 0;
        int liveFerret = 0;
        
        int livePet = 0;
        
        int liveYou = 0;
        int totalYou = 0;
        int runTime = 0;
        

        if(runCount+3>list.size())
        	runTime = list.size() - runCount;
        else
        	runTime = 3;

        for (int i=0;i<runCount+runTime;i++) {
            ArrayList<Persona> passengersList = list.get(i).getPassengersList();
            ArrayList<Persona> pedestriansList = list.get(i).getPedestriansList();
            totalPassenger = totalPassenger+passengersList.size();
            totalPedestrian = totalPedestrian+pedestriansList.size();


            
            if(whosaved.get(i).equals("PASSENGERS")) {
            		livePassenger = livePassenger + passengersList.size();
            for(Persona persona : passengersList) {
            	if(list.get(i).isLegalCrossing()) {
            		liveGreen++;
            		totalGreen++;
            	}
            	else {
            		liveRed++;
            		totalRed++;
            	}
            	if(persona instanceof Animal) {
            		liveAnimal = liveAnimal + 1;
            		totalAnimal = totalAnimal +1;
            		if(persona.getSpecies().equals("cat")) {
            			liveCat = liveCat + 1;
            			totalCat=totalCat+1;}
            		else if(persona.getSpecies().equals("dog")) {
            			totalDog=totalDog+1;
            			liveDog = liveDog + 1;
            		}
            		else if(persona.getSpecies().equals("bird")) {
            			totalBird=totalBird+1;
            			liveBird = liveBird + 1;
            		}
            		else {
            			liveFerret = liveFerret + 1;
            			totalFerret=totalFerret+1;
            		}
            		if(persona.isPet()) {
            			totalPet++;
            			livePet = livePet+1;
            		}
            	}
            	else if(persona instanceof Human) {
            		liveHuman=liveHuman+1;
            		totalHuman++;
            		if(persona.isYou()) {
            			liveYou++;
            			totalYou++;
            		}
            		if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("baby")) {
            			totalBaby++;
            			liveBaby++;
            		}
            		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("adult")) {
            			totalAdult++;
            			liveAdult++;
            		}
            		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("child")) {
            			totalChild++;
            			liveChild++;
            		}
            		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("senior")) {
            			totalSenior++;
            			liveSenior++;
            		}
            		if(((Human) persona).getProfession().toString().equalsIgnoreCase("doctor")) {
            			totalDoctor++;
            			liveDoctor=liveDoctor+1;
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("ceo")) {
            			totalCeo++;
            			liveCeo=liveCeo+1;
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("criminal")) {
            			totalCriminal++;
            			liveCriminal=liveCriminal+1;
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("homeless")) {
            			totalHomeless++;
            			liveHomeless++;
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("unemployed")) {
            			totalUnemployed++;
            			liveUnemployed++;
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("driver")) {
            			liveDriver++;
            			totalDriver++;
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("chef")) {
            			totalChef++;
            			liveChef++;
            		}
            		if(((Human) persona).isPregnant()) {
            			totalPregnant++;
            			livePregnant++;
            		}
            		
            	
            	totalAge = totalAge+ ((Human) persona).getAge();
            	if(((Human) persona).getGender().toString().equalsIgnoreCase("male")) {
            		totalMale++;
            		liveMale++;
            	}
            	else if(((Human) persona).getGender().toString().equalsIgnoreCase("female")) {
            		totalFemale++;
            		liveFemale++;
            	}
            	if(((Human) persona).getBodyType().toString().equalsIgnoreCase("average")) {
            		totalAverage++;
            		liveAverage++;
            	}
            	else if(((Human) persona).getBodyType().toString().equalsIgnoreCase("overweight")) {
            		totalOverweight++;
            		liveOverweight++;
            	}
            	else if(((Human) persona).getBodyType().toString().equalsIgnoreCase("athletic")) {
            		totalAthletic++;
            		liveAthletic++;
            	}
            	}
            }
            
            for (Persona persona : pedestriansList) {
            	if(list.get(i).isLegalCrossing()) {
  
            		totalGreen++;
            	}
            	else {
    
            		totalRed++;
            	}

            	if(persona instanceof Animal) {

            		totalAnimal = totalAnimal +1;
            		if(persona.getSpecies().equals("cat")) {

            			totalCat=totalCat+1;}
            		else if(persona.getSpecies().equals("dog")) {
            			totalDog=totalDog+1;
 
            		}
            		else if(persona.getSpecies().equals("bird")) {
            			totalBird=totalBird+1;
            		
            		}
            		else {
            	
            			totalFerret=totalFerret+1;
            		}
            		if(persona.isPet()) {
            			totalPet++;
            
            		}
            	}
            	else if(persona instanceof Human) {
            		totalHuman++;
            		if(persona.isYou())
            			totalYou++;
            		if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("baby")) {
            			totalBaby++;
 
            		}
            		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("adult")) {
            			totalAdult++;
       
            		}
            		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("child")) {
            			totalChild++;
      
            		}
            		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("senior")) {
            			totalSenior++;
          
            		}
            		if(((Human) persona).getProfession().toString().equalsIgnoreCase("doctor")) {
            			totalDoctor++;
            
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("ceo")) {
            			totalCeo++;
          
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("criminal")) {
            			totalCriminal++;
           
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("homeless")) {
            			totalHomeless++;
      
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("unemployed")) {
            			totalUnemployed++;
           
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("driver")) {
          
            			totalDriver++;
            		}
            		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("chef")) {
            			totalChef++;
           
            		}
            		if(((Human) persona).isPregnant()) {
            			totalPregnant++;
          
            		}
            		
            	
            	if(((Human) persona).getGender().toString().equalsIgnoreCase("male")) {
            		totalMale++;
   
            	}
            	else if(((Human) persona).getGender().toString().equalsIgnoreCase("female")) {
            		totalFemale++;
       
            	}
            	if(((Human) persona).getBodyType().toString().equalsIgnoreCase("average")) {
            		totalAverage++;
       
            	}
            	else if(((Human) persona).getBodyType().toString().equalsIgnoreCase("overweight")) {
            		totalOverweight++;
      
            	}
            	else if(((Human) persona).getBodyType().toString().equalsIgnoreCase("athletic")) {
            		totalAthletic++;
            	}
            	}
            }
            }
            else if(whosaved.get(i).equals("PEDESTRIANS")) {

    		livePedestrian = livePedestrian + pedestriansList.size();
    for(Persona persona : pedestriansList) {
    	if(list.get(i).isLegalCrossing()) {
    		liveGreen++;
    		totalGreen++;
    	}
    	else {
    		liveRed++;
    		totalRed++;
    	}
    	if(persona instanceof Animal) {
    		liveAnimal = liveAnimal + 1;
    		totalAnimal = totalAnimal +1;
    		if(persona.getSpecies().equals("cat")) {
    			liveCat = liveCat + 1;
    			totalCat=totalCat+1;}
    		else if(persona.getSpecies().equals("dog")) {
    			totalDog=totalDog+1;
    			liveDog = liveDog + 1;
    		}
    		else if(persona.getSpecies().equals("bird")) {
    			totalBird=totalBird+1;
    			liveBird = liveBird + 1;
    		}
    		else {
    			liveFerret = liveFerret + 1;
    			totalFerret=totalFerret+1;
    		}
    		if(persona.isPet()) {
    			totalPet++;
    			livePet = livePet+1;
    		}
    	}
    	else if(persona instanceof Human) {
    		liveHuman=liveHuman+1;
    		totalHuman++;
    		if(persona.isYou()) {
    			totalYou++;
    			liveYou++;
    		}
    		if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("baby")) {
    			totalBaby++;
    			liveBaby++;
    		}
    		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("adult")) {
    			totalAdult++;
    			liveAdult++;
    		}
    		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("child")) {
    			totalChild++;
    			liveChild++;
    		}
    		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("senior")) {
    			totalSenior++;
    			liveSenior++;
    		}
    		if(((Human) persona).getProfession().toString().equalsIgnoreCase("doctor")) {
    			totalDoctor++;
    			liveDoctor=liveDoctor+1;
    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("ceo")) {
    			totalCeo++;
    			liveCeo=liveCeo+1;
    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("criminal")) {
    			totalCriminal++;
    			liveCriminal=liveCriminal+1;
    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("homeless")) {
    			totalHomeless++;
    			liveHomeless++;
    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("unemployed")) {
    			totalUnemployed++;
    			liveUnemployed++;
    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("driver")) {
    			liveDriver++;
    			totalDriver++;
    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("chef")) {
    			totalChef++;
    			liveChef++;
    		}
    		if(((Human) persona).isPregnant()) {
    			totalPregnant++;
    			livePregnant++;
    		}
    		
    	
    	totalAge = totalAge+ ((Human) persona).getAge();
    	if(((Human) persona).getGender().toString().equalsIgnoreCase("male")) {
    		totalMale++;
    		liveMale++;
    	}
    	else if(((Human) persona).getGender().toString().equalsIgnoreCase("female")) {
    		totalFemale++;
    		liveFemale++;
    	}
    	if(((Human) persona).getBodyType().toString().equalsIgnoreCase("average")) {
    		totalAverage++;
    		liveAverage++;
    	}
    	else if(((Human) persona).getBodyType().toString().equalsIgnoreCase("overweight")) {
    		totalOverweight++;
    		liveOverweight++;
    	}
    	else if(((Human) persona).getBodyType().toString().equalsIgnoreCase("athletic")) {
    		totalAthletic++;
    		liveAthletic++;
    	}
    	}
    }
    
    for (Persona persona : passengersList) {
    	if(list.get(i).isLegalCrossing()) {
 
    		totalGreen++;
    	}
    	else {

    		totalRed++;
    	}

    	if(persona instanceof Animal) {

    		totalAnimal = totalAnimal +1;
    		if(persona.getSpecies().equals("cat")) {

    			totalCat=totalCat+1;}
    		else if(persona.getSpecies().equals("dog")) {
    			totalDog=totalDog+1;

    		}
    		else if(persona.getSpecies().equals("bird")) {
    			totalBird=totalBird+1;
    		
    		}
    		else {
    	
    			totalFerret=totalFerret+1;
    		}
    		if(persona.isPet()) {
    			totalPet++;
    
    		}
    	}
    	else if(persona instanceof Human) {
    		totalHuman++;
    		if(persona.isYou())
    			totalYou++;
    		if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("baby")) {
    			totalBaby++;
   
    		}
    		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("adult")) {
    			totalAdult++;
    
    		}
    		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("child")) {
    			totalChild++;
  
    		}
    		else if(((Human) persona).getAgeCategory().toString().equalsIgnoreCase("senior")) {
    			totalSenior++;
 
    		}
    		if(((Human) persona).getProfession().toString().equalsIgnoreCase("doctor")) {
    			totalDoctor++;
    
    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("ceo")) {
    			totalCeo++;
  
    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("criminal")) {
    			totalCriminal++;
   
    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("homeless")) {
    			totalHomeless++;

    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("unemployed")) {
    			totalUnemployed++;
   
    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("driver")) {
  
    			totalDriver++;
    		}
    		else if(((Human) persona).getProfession().toString().equalsIgnoreCase("chef")) {
    			totalChef++;
   
    		}
    		if(((Human) persona).isPregnant()) {
    			totalPregnant++;
  
    		}
    		
    	
    		if(((Human) persona).getGender().toString().equalsIgnoreCase("male")) {
    		totalMale++;

    	}
    	else if(((Human) persona).getGender().toString().equalsIgnoreCase("female")) {
    		totalFemale++;

    	}
    	if(((Human) persona).getBodyType().toString().equalsIgnoreCase("average")) {
    		totalAverage++;

    	}
    	else if(((Human) persona).getBodyType().toString().equalsIgnoreCase("overweight")) {
    		totalOverweight++;

    	}
    	else if(((Human) persona).getBodyType().toString().equalsIgnoreCase("athletic")) {
    		totalAthletic++;
    	}
    	}
    }
            }
    }


        
        



        
       
        

        result.append("======================================\n");
        result.append("# "+this.auditType+" Audit\n");
        result.append("======================================\n");
        result.append("- % SAVED AFTER ");
        result.append(runCount+runTime);
        result.append(" RUNS\n");
        if(totalAverage!=0) {
            float aveAverage = (float)liveAverage/(float)totalAverage;
            result.append("average: ").append(String.format("%.2f",aveAverage)).append("\n");
        }
        if(totalAthletic!=0) {
            float aveAthletic = (float)liveAthletic/(float)totalAthletic;
            result.append("athletic: ").append(String.format("%.2f",aveAthletic)).append("\n");
        }
        if(totalOverweight!=0) {
            float aveOverweight = (float)liveOverweight/(float)totalOverweight;
            result.append("overweight: ").append(String.format("%.2f",aveOverweight)).append("\n");
        }
        
        if(totalBaby!=0) {
            float aveBaby = (float)liveBaby/(float)totalBaby;
            result.append("baby: ").append(String.format("%.2f",aveBaby)).append("\n");
        }
        if(totalChild!=0) {
            float aveChild = (float)liveChild/(float)totalChild;
            result.append("child: ").append(String.format("%.2f",aveChild)).append("\n");
        }
        if(totalAdult!=0) {
            float aveAdult = (float)liveAdult/(float)totalAdult;
            result.append("adult: ").append(String.format("%.2f",aveAdult)).append("\n");
        }
        if(totalSenior!=0) {
            float aveSenior = (float)liveSenior/(float)totalSenior;
            result.append("senior: ").append(String.format("%.2f",aveSenior)).append("\n");
        }
        if(totalFemale!=0) {
            float aveFemale = (float)liveFemale/(float)totalFemale;
            result.append("female: ").append(String.format("%.2f",aveFemale)).append("\n");
        }
        if(totalMale!=0) {
            float aveMale = (float)liveMale/(float)totalMale;
            result.append("male: ").append(String.format("%.2f",aveMale)).append("\n");
        }
        if(totalDoctor!=0) {
            float aveDoctor = (float)liveDoctor/(float)totalDoctor;
            result.append("doctor: ").append(String.format("%.2f",aveDoctor)).append("\n");
        }
        if(totalCeo!=0) {
            float aveCeo = (float)liveCeo/(float)totalCeo;
            result.append("ceo: ").append(String.format("%.2f",aveCeo)).append("\n");
        }
        if(totalChef!=0) {
            float aveChef = (float)liveChef/(float)totalChef;
            result.append("chef: ").append(String.format("%.2f",aveChef)).append("\n");
        }
        if(totalCriminal!=0) {
            float aveCriminal = (float)liveCriminal/(float)totalCriminal;
            result.append("criminal: ").append(String.format("%.2f",aveCriminal)).append("\n");
        }
        if(totalHomeless!=0) {
            float aveHomeless = (float)liveHomeless/(float)totalHomeless;
            result.append("homeless: ").append(String.format("%.2f",aveHomeless)).append("\n");
        }
        if(totalDriver!=0) {
            float aveDriver = (float)liveDriver/(float)totalDriver;
            result.append("driver: ").append(String.format("%.2f",aveDriver)).append("\n");
        }
        if(totalUnemployed!=0) {
            float aveUnemployed = (float)liveUnemployed/(float)totalUnemployed;
            result.append("unemployed: ").append(String.format("%.2f",aveUnemployed)).append("\n");
        }
        if(totalPregnant!=0) {
            float avePregnant = (float)livePregnant/(float)totalPregnant;
            result.append("pregnant: ").append(String.format("%.2f",avePregnant)).append("\n");
        }
        if(totalHuman!=0) {
            float aveHuman = (float)liveHuman/(float)totalHuman;
            result.append("human: ").append(String.format("%.2f",aveHuman)).append("\n");
        }
        if(totalAnimal!=0) {
            float aveAnimal = (float)liveAnimal/(float)totalAnimal;
            result.append("animal: ").append(String.format("%.2f",aveAnimal)).append("\n");
        }
        if(totalCat!=0) {
            float aveCat = (float)liveCat/(float)totalCat;
            result.append("cat: ").append(String.format("%.2f",aveCat)).append("\n");
        }
        if(totalDog!=0) {
            float aveDog = (float)liveDog/(float)totalDog;
            result.append("dog: ").append(String.format("%.2f",aveDog)).append("\n");
        }
        if(totalBird!=0) {
            float aveBird = (float)liveBird/(float)totalBird;
            result.append("bird: ").append(String.format("%.2f",aveBird)).append("\n");
        }
        if(totalFerret!=0) {
            float aveFerret = (float)liveFerret/(float)totalFerret;
            result.append("ferret: ").append(String.format("%.2f",aveFerret)).append("\n");
        }
        if(totalPet!=0) {
            float avePet = (float)livePet/(float)totalPet;
            result.append("pet: ").append(String.format("%.2f",avePet)).append("\n");
        }
        if(totalGreen!=0) {
            float aveGreen = (float)liveGreen/(float)totalGreen;
            result.append("green: ").append(String.format("%.2f",aveGreen)).append("\n");
        }
        if(totalRed!=0) {
            float aveRed = (float)liveRed/(float)totalRed;
            result.append("red: ").append(String.format("%.2f",aveRed)).append("\n");
        }
        
        if(totalPassenger!=0) {
            float avePassenger = (float)livePassenger/(float)totalPassenger;
            result.append("passengers: ").append(String.format("%.2f",avePassenger)).append("\n");
        }
        if(totalPedestrian!=0) {
            float avePedestrian = (float)livePedestrian/(float)totalPedestrian;
            result.append("pedestrians: ").append(String.format("%.2f",avePedestrian)).append("\n");
        }

        

        if(totalYou!=0) {
            float aveYou = (float)liveYou/(float)totalYou;
            result.append("you: ").append(String.format("%.2f",aveYou)).append("\n");
        }

        result.append("--\n");
        if(liveHuman!=0) {
            float aveAge = (float)totalAge/(float)liveHuman;
            result.append("average age: ").append(String.format("%.2f",aveAge)).append("\n");
        }
        else {
        	result.append("average age: ").append(String.format("%.2f",0.00)).append("\n");
        }

        }
    	
    





    @Override
    public String toString(){
        return  result.toString();
    }

    public void printStatistic(){
        System.out.println(result.toString());
    }

    public void printToFile(String filepath) {
        byte[] buff = new byte[]{};
        FileOutputStream o = null;
        String path =System.getProperty("user.dir")+"\\"+filepath;
        File file = new File(path);
        try{
            if (!file.getParentFile().exists()) {
                boolean mkdir = file.getParentFile().mkdirs();
                if (!mkdir) {
                    System.out.println("ERROR: could not print results. Target directory does not exist.");
                }
            }
            if (!file.exists()){
                file.createNewFile();
            }else {
                buff=result.toString().getBytes();
                o=new FileOutputStream(file,true);
                o.write(buff);
                o.flush();
                o.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
