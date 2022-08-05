import ethicalengine.*;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * description: EthicalEngine
 * Contain the main functions and coordinate the program flow
 * @author: delongh
 */
public class EthicalEngine extends Human{
	public enum Decision {
	    PEDESTRIANS,PASSENGERS;

	}

    private static ArrayList<String> whosaved = new ArrayList<>();
    private static int runCount;










	/**
     * Decision algorithm
     * @param scenario Scene entity class
     */
    public static Decision decide(Scenario scenario){
        int passengersLive =0 ;
        int pedestriansLive =0 ;
        ArrayList<Persona> passengersList = scenario.getPassengersList();
        ArrayList<Persona> pedestriansList = scenario.getPedestriansList();
        for (Persona persona : passengersList) {
            passengersLive = passengersLive + survivalRate(persona);
        }
        for (Persona persona : pedestriansList) {
            pedestriansLive = pedestriansLive + survivalRate(persona);
        }
        if (passengersLive>pedestriansLive){
            return Decision.PASSENGERS;
        }else {
            return Decision.PEDESTRIANS;
        }
    }
    
    public static Decision interdecide(int whosaved){
        if (whosaved==1){
            return Decision.PASSENGERS;
        }else {
            return Decision.PEDESTRIANS;
        }
    }
    


    /**
     * Calculate weight
     * @param persona Entity class object
     * @return Survival value
     */
    public static int survivalRate(Persona persona) {
        int live = 0;


        if (persona instanceof Human) {
            live = live + 10;
            Human human = (Human) persona;
            live = live + 100 - human.getAge();

            String professional = human.getProfeSsional().toString();
            if (professional.equals("DOCTOR")){
                live = live +50;
            }
            if (professional.equals("CEO")){
                live = live +60;
            }
            if (professional.equals("CRIMINAL")){
                live = live +40;
            }
            if (professional.equals("HOMELESS")){
                live = live +30;
            }
            if (professional.equals("UNEMPLOYED")){
                live = live +30;
            }
            if (professional.equals("NONE")){
            }
            if (professional.equals("DRIVER")){
                live = live +30;
            }
            if (professional.equals("CHEF")){
                live = live +30;
            }else {
                live = live + 10;
            }


            String bodyType = human.getBodyType().toString();
            if (bodyType.equals("AVERAGE")){
                live = live+40;
            }
            if (bodyType.equals("ATHLETIC")){
                live = live+50;
            }
            if (bodyType.equals("OVERWEIGHT")){
                live = live+30;
            }
            if (bodyType.equals("UNSPECIFIED")){
                live = live+20;
            }

            String gender = human.getGender().toString();
            if (gender.equals("FEMALE")){
                live = live+60;
            }
            if (gender.equals("MALE")){
                live = live+40;
            }else {
                live = live + 10;
            }

            if (human.isPregnant()){
                live = live +50;
            }

            if (human.isYou()){
                live = live +5;
            }

        } else {
            live = live + 1;
            Animal animal = (Animal) persona;
        }
        return live;

    }









	/**
     * Create a scene from CSV
     * @param filePath File address
     * @return Scene entity
     */
    public static ArrayList<Scenario> getByCsv(String filePath){
        boolean isLegalCrossing = false;
        ArrayList<Persona> passengersList = new ArrayList<>(10);
        ArrayList<Persona> pedestriansList = new ArrayList<>(10);
        ArrayList<Scenario> scenarioList = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        String path = filePath;
        int i = 0;


        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));

            reader.readLine();
            String line1 = null;
            while ((line1=reader.readLine())!=null){
                list.add(line1);

            }
            for (String line : list) {
                i++;

                String[] strings = line.split(",");

                if (strings[0].contains("scenario")){
                    scenarioList.add(new Scenario(passengersList.toArray(new Persona[0]),pedestriansList.toArray(new Persona[0]),isLegalCrossing));

                    isLegalCrossing = false;
                    passengersList.clear();
                    pedestriansList.clear();

                    if (strings[0].contains("green")){
                        isLegalCrossing = true;
                    }else {
                        isLegalCrossing = false;
                    }
                }

                else {

                    if (!(strings.length ==10)){
                        throw new InvalidDataFormatException("WARNING: invalid data format in config file in line "+i);
                    }
                    String clazz = strings[0];

                    if (clazz.equals("human")){
                    	if(Character.isDigit(strings[2].charAt(0)))
                    		strings[2]=strings[2];
                    	else
                    		strings[2] = "50";
                        Human human = new Human((Integer.parseInt(strings[2])), getRandomProfession(strings[4]), getRandomGender(strings[1]), getRandombodyType(strings[3]), getPregnant(strings[5]));
                        human.setAsYou(getIsYou(strings[6]));
                        if (strings[9].equals("passenger")){
                            passengersList.add(human);
                        }else {
                            pedestriansList.add(human);
                        }
                    }else {
                    	if(Character.isDigit(strings[2].charAt(0)))
                    		strings[2]=strings[2];
                    	else
                    		strings[2] = "50";
                        Animal animal = new Animal((Integer.parseInt(strings[2])),getRandomGender(strings[1]), getRandombodyType(strings[3]), strings[7]);
                        animal.setPet(getIsPet(strings[8]));
                        if (strings[9].equals("passenger")){
                            passengersList.add(animal);
                        }else {
                            pedestriansList.add(animal);
                        }
                    }
                }
                if (line == list.get(list.size()-1)){
                    scenarioList.add(new Scenario(passengersList.toArray(new Persona[0]),pedestriansList.toArray(new Persona[0]),isLegalCrossing));
                }
            }
            scenarioList.remove(0);
            return scenarioList;
        } catch (NumberFormatException | IOException | InvalidDataFormatException e) {
            NumberFormatException numberFormatException = new NumberFormatException("WARNING: invalid number format in config file in line "+i );
            numberFormatException.printStackTrace();
            return null;
        }
    }

    public static Profession getRandomProfession(String i) {
        switch (i) {
            case "doctor":
                return Profession.DOCTOR;
            case "ceo":
                return Profession.CEO;
            case "criminal":
                return Profession.CRIMINAL;
            case "homeless":
                return Profession.HOMELESS;
            case "unemployed":
                return Profession.UNEMPLOYED;
            case "none":
                return Profession.NONE;
            case "driver":
                return Profession.DRIVER;
            case "chef":
                return Profession.CHEF;
            default:
                return Profession.NONE;
        }
    }

    public static Gender getRandomGender(String i) {
        switch (i) {
            case "female":
                return Gender.FEMALE;
            case "male":
                return Gender.MALE;
            case "unknown":
                return Gender.UNKNOWN;
            default:
                return Gender.UNKNOWN;
        }
    }

    public static BodyType getRandombodyType(String i) {
        switch (i) {
            case "average":
                return BodyType.AVERAGE;
            case "athletic":
                return BodyType.ATHLETIC;
            case "overweight":
                return BodyType.OVERWEIGHT;
            case "unspecified":
                return BodyType.UNSPECIFIED;
            default:
                return BodyType.UNSPECIFIED;
        }
    }

    public static boolean getPregnant(String i) {
        switch (i) {
            case "false":
                return false;
            case "true":
                return true;
            default:
                return false;
        }
    }

    public static boolean getIsYou(String i) {
        switch (i) {
            case "false":
                return false;
            case "true":
                return true;
            default:
                return false;
        }
    }
    
    public static boolean getIsPet(String i) {
        switch (i) {
            case "false":
                return false;
            case "true":
                return true;
            default:
                return false;
        }
    }



    public static void main(String[] args) throws IOException {
    	boolean user = false;
    	boolean save = true;


        StringBuilder output = new StringBuilder();
        String s ;
        File file = new File(System.getProperty("user.dir") + "/welcome.ascii");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while ((s = reader.readLine()) != null) {
            output.append(s).append("\n");
            System.out.println(s);
        }
        
        for(int i=0;i<args.length;i++) {
        	if(args [args.length-1].contains("-c")) {
                System.out.println("Arguments:");
                System.out.println("     -c or --config Optional: path to config file");
                System.out.println("     -h or --help Print Help (this message) and exit");
                System.out.println("     -r or --results Optional: path to results log file");
                System.out.println("     -i or --interactive Optional: launches interactive mode");
                return;
        	}
        	if(args [i].contains("-h") || (args [i].contains("-c")&&!args [i+1].contains(".csv"))) {
                System.out.println("Arguments:");
                System.out.println("     -c or --config Optional: path to config file");
                System.out.println("     -h or --help Print Help (this message) and exit");
                System.out.println("     -r or --results Optional: path to results log file");
                System.out.println("     -i or --interactive Optional: launches interactive mode");
                return;
        	}
        }
        
        ArrayList<Scenario> scenarioArrayList = new ArrayList<>();
        boolean cFlag = false;
        for(int i=0;i<args.length;i++) {
        	if(args [i].contains("-c") && args [i+1].contains(".csv")) {
        		String importpath = " ";
        		if(args [i+1].contains(":") || args [i+1].substring(0, 1).equals("/")) {
        			importpath = args [i+1];
        		}
        		else {
            		importpath = System.getProperty("user.dir")+ "/" + args [i+1];
        		}
        		scenarioArrayList = EthicalEngine.getByCsv(importpath);
        		cFlag = true;
        		break;
        	}
        }
        if(!cFlag) {

        	for(int i=0;i<100;i++) {
                ScenarioGenerator generator = new ScenarioGenerator();
                Scenario generate = generator.generate();
                scenarioArrayList.add(generate);
        	}
        }
        
        
        boolean rFlag = false;
        boolean pathFlag = true;
        String logpath = " ";
        boolean checkargs = true;
        
        if(args.length==0)
        	checkargs = false;
        if(checkargs) {
            if(args [args.length-1].contains("-r"))
            	pathFlag = false;
            if(pathFlag) {
            	for(int i=0;i<args.length;i++) {
            		if(args [i].contains("-r") && args [i+1].contains(".log")) {
            			if(args [i+1].contains(":") || args [i+1].substring(0, 1).equals("/")) {
            				logpath = args [i+1];
            			}
            			else {
                       		logpath = System.getProperty("user.dir")+ "/" + args [i+1];
            			}
                		rFlag = true;
                		break;
                	}
            	}
            }
        }

        
        
        int iFlag = 0;
        for(int i=0;i<args.length;i++) {
        	if(args [i].contains("-i")) {
        		iFlag = 1;
        		user = true;
        	}
        }
        if(iFlag==0) {
            Audit audit = new Audit();
            audit.setAuditType("Algorithm");
            for (Scenario scenario : scenarioArrayList) {
                System.out.println(scenario.toString());
                Decision decision = EthicalEngine.decide(scenario);
                whosaved.add(decision.toString());
            }
            audit.run(scenarioArrayList, whosaved);
            System.out.println(audit.toString());
        }
        else {
        	if(scenarioArrayList.size()<=3) {
            	Scanner scanner = new Scanner(System.in);
                System.out.println("Do you consent to have your decisions saved to a file? (yes/no)");
                String FileSave = scanner.nextLine();
                while(!FileSave.equals("yes") && !FileSave.equals("no")) {
                	System.out.println("Invalid response. Do you consent to have your decisions saved to a file? (yes/no)");
                	FileSave = scanner.nextLine();
                }
                if(FileSave.equals("no"))
                	save = false;
                Audit audit = new Audit();
                for (Scenario scenario : scenarioArrayList) {
                    System.out.println(scenario.toString());
                    System.out.println("Who should be saved? (passenger(s) [1] or pedestrian(s) [2])");
                    String SaveOrder = scanner.nextLine();
                    while(!SaveOrder.equals("1") && !SaveOrder.equals("2")) {
                    	System.out.println("Invalid response. Who should be saved? (passenger(s) [1] or pedestrian(s) [2])");
                    	SaveOrder = scanner.nextLine();
                    }
                    if(SaveOrder.equals("1")) {
                    	whosaved.add("PASSENGERS");
                    }
                    else
                    	whosaved.add("PEDESTRIANS");
                }
                audit.run(scenarioArrayList, whosaved);
                System.out.println(audit.toString());
        	}
        	else if(scenarioArrayList.size()>3) {
            	Scanner scanner = new Scanner(System.in);
                System.out.println("Do you consent to have your decisions saved to a file? (yes/no)");
                String FileSave = scanner.nextLine();
                while(!FileSave.equals("yes") && !FileSave.equals("no")) {
                	System.out.println("Invalid response. Do you consent to have your decisions saved to a file? (yes/no)");
                	FileSave = scanner.nextLine();
                }
                if(FileSave.equals("no"))
                	save = false;
                Audit audit = new Audit();
                runCount = 0;
                boolean KeepOrder = true;
                while(KeepOrder) {
                	while(runCount+3<=scenarioArrayList.size()) {
                        for (int i = 0;i<3;i++) {
                            System.out.println(scenarioArrayList.get(runCount).toString());
                            System.out.println("Who should be saved? (passenger(s) [1] or pedestrian(s) [2])");
                            String SaveOrder = scanner.nextLine();
                            while(!SaveOrder.equals("1") && !SaveOrder.equals("2")) {
                            	System.out.println("Invalid response. Who should be saved? (passenger(s) [1] or pedestrian(s) [2])");
                            	SaveOrder = scanner.nextLine();
                            }
                            if(SaveOrder.equals("1")) {
                            	whosaved.add("PASSENGERS");
                            }
                            else
                            	whosaved.add("PEDESTRIANS");
                            runCount = runCount + 1;
                        }
                        runCount = runCount - 3;
                        audit.run(scenarioArrayList, whosaved, runCount);
                        System.out.println(audit.toString());
                        runCount = runCount + 3;
                        System.out.println("Would you like to continue? (yes/no)");
                        String ContinueOrder = scanner.nextLine();
                        while(!ContinueOrder.equals("yes") && !ContinueOrder.equals("no")) {
                        	System.out.println("Invalid response. Would you like to continue? (yes/no)");
                        	ContinueOrder = scanner.nextLine();
                        }
                        if(ContinueOrder.equals("no")) {
                        	KeepOrder = false;
                        	break;
                        }

                	}
                	if(runCount+3>scenarioArrayList.size() && KeepOrder) {
                		int finalTime = scenarioArrayList.size() - runCount;
                        for (int i = 0;i<finalTime;i++) {
                            System.out.println(scenarioArrayList.get(runCount).toString());
                            System.out.println("Who should be saved? (passenger(s) [1] or pedestrian(s) [2])");
                            String SaveOrder = scanner.nextLine();
                            while(!SaveOrder.equals("1") && !SaveOrder.equals("2")) {
                            	System.out.println("Invalid response. Who should be saved? (passenger(s) [1] or pedestrian(s) [2])");
                            	SaveOrder = scanner.nextLine();
                            }
                            if(SaveOrder.equals("1")) {
                            	whosaved.add("PASSENGERS");
                            }
                            else
                            	whosaved.add("PEDESTRIANS");
                            runCount = runCount + 1;
                        }
                        runCount = runCount - finalTime;
                        audit.run(scenarioArrayList, whosaved, runCount);
                        System.out.println(audit.toString());
                        KeepOrder = false;
                	}

                }

        	}
        	
        }

        for(int i=0;i<args.length;i++) {
        	if(args [i].contains("-r")) {
        		if(!rFlag)
                    System.out.println("log is in "+System.getProperty("user.dir"));
        		else {
                    System.out.println("log is in "+logpath);
        		}

        	}

        }
        System.out.println("That's all. Press Enter to quit.");
        if(!rFlag) {
            String filename = "results.log";
            if(user)
            	filename = "user.log";
            if(save)
            EthicalEngine.exit(filename);
        }
        else {
        	String filename = logpath;
        	if(save)
        		EthicalEngine.exit(filename);
        }
    }
    
	public static void exit(String filename) {
		ObjectOutputStream outputStream = null;		
		try
		{
			outputStream = new ObjectOutputStream(new FileOutputStream(filename, true));
			SaveResult saveResult = new SaveResult(Audit.getResult());
			outputStream.writeObject(saveResult);
			outputStream.close();
		}
		catch(IOException e)
		{
			System.out.println("Could not open file: " + filename);
			System.out.println(e);
		}
	}




	}
class SaveResult implements Serializable {
    public StringBuilder result = new StringBuilder();

	//constructor
	public SaveResult (StringBuilder result) {
		this.result = result;
	}
}

