package ethicalengine;



import java.util.ArrayList;
import java.util.Random;

/**
 * description: ScenarioGenerator
 * create a variety of scenarios
 * @author: delongh
 */
public class ScenarioGenerator extends Human{
    private Random random;
    private int passengerCountMinimum;
    private int passengerCountMaximum;
    private int pedestrianCountMinimum;
    private int pedestrianCountMaximum;


    public ScenarioGenerator() {
        random = new Random();
    }

    public ScenarioGenerator(long seed) {
        random = new Random(seed);
    }


    public ScenarioGenerator(long seed, int passengerCountMinimum, int passengerCountMaximum, int pedestrianCountMinimum, int pedestrianCountMaximum) {
        random = new Random(seed);
        this.passengerCountMinimum = passengerCountMinimum;
        this.passengerCountMaximum = passengerCountMaximum;
        this.pedestrianCountMinimum = pedestrianCountMinimum;
        this.pedestrianCountMaximum = pedestrianCountMaximum;
    }
    public int getPassengerCountMinimum() {
        return passengerCountMinimum;
    }

    public void setPassengerCountMin(int passengerCountMinimum) {
        this.passengerCountMinimum = passengerCountMinimum;
    }

    public int getPassengerCountMaximum() {
        return passengerCountMaximum;
    }

    public void setPassengerCountMax(int passengerCountMaximum) {
        this.passengerCountMaximum = passengerCountMaximum;
    }

    public int getPedestrianCountMinimum() {
        return pedestrianCountMinimum;
    }

    public void setPedestrianCountMin(int pedestrianCountMinimum) {
        this.pedestrianCountMinimum = pedestrianCountMinimum;
    }

    public int getPedestrianCountMaximum() {
        return pedestrianCountMaximum;
    }

    public void setPedestrianCountMax(int pedestrianCountMaximum) {
        this.pedestrianCountMaximum = pedestrianCountMaximum;
    }

    public Human getRandomHuman() {
        int i = this.random.nextInt(100);
        if(i % 3 == 0)
        return new Human(i, getRandomProfession(i % 8), getRandomGender(i % 3), getRandombodyType(i % 4), i % 2 == 0);
        return new Human(i, getRandomProfession(i % 8), getRandomGender(i % 3), getRandombodyType(i % 4), false);
    }

    public Animal getRandomAnimal() {
        int i = this.random.nextInt(100);
        if(i % 3 == 0)
        	return new Animal(i, getRandomGender(i % 3), getRandombodyType(i % 4), "randomspecie");
        return new Animal(i, getRandomGender(i % 3), getRandombodyType(i % 4), "randomspecie");
    }

    public Scenario generate() {
        ArrayList<Persona> list2 = new ArrayList<>();
        ArrayList<Persona> list1 = new ArrayList<>();
        int l = random.nextInt(100);
        int j = random.nextInt(100);

        int x = j % 6;
        if (x == 0) {
            x = 1;
        }
        for (int i = 0; i < x; i++) {
            int r = random.nextInt(4)+1;
            if(r==1)
            list2.add(this.getRandomAnimal());
            else
            	list2.add(this.getRandomHuman());
        }


        int q = l % 6;
        if (q == 0) {
            q = 1;
        }
        for (int i = 0; i < q; i++) {
        	int r = random.nextInt(4)+1;
        	if(r==1)
            list1.add(this.getRandomAnimal());
        	else
        		list1.add(this.getRandomHuman());
        }

        return new Scenario(list1.toArray(new Persona[0]), list2.toArray(new Persona[0]), random.nextInt(47) % 2 == 0);
    }

    public Scenario generate(int min, int max) {
        if (min>max){
            max = min;
            min = 0;
        }
        int i = random.nextInt(max) + min;
        ArrayList<Persona> list2 = new ArrayList<>();
        ArrayList<Persona> list1 = new ArrayList<>();
        for (int i1 = 0; i1 < i; i1++) {
        	int r = random.nextInt(4)+1;
            if(r==1)
            list2.add(this.getRandomAnimal());
            else
            	list2.add(this.getRandomHuman());
        	if(r==1)
            list1.add(this.getRandomAnimal());
        	else
        		list1.add(this.getRandomHuman());
        }
        return new Scenario(list1.toArray(new Persona[0]), list2.toArray(new Persona[0]), random.nextInt(47) % 2 == 0);

    }



    public static Profession getRandomProfession(int i) {
        switch (i) {
            case 0:
                return Profession.DOCTOR;
            case 1:
                return Profession.CEO;
            case 2:
                return Profession.CRIMINAL;
            case 3:
                return Profession.HOMELESS;
            case 4:
                return Profession.UNEMPLOYED;
            case 5:
                return Profession.NONE;
            case 6:
                return Profession.DRIVER;
            case 7:
                return Profession.CHEF;
            default:
                return Profession.NONE;
        }
    }

    public static Gender getRandomGender(int i) {
        switch (i) {
            case 0:
                return Gender.FEMALE;
            case 1:
                return Gender.MALE;
            case 2:
                return Gender.UNKNOWN;
            default:
                return Gender.UNKNOWN;
        }
    }

    public static BodyType getRandombodyType(int i) {
        switch (i) {
            case 0:
                return BodyType.AVERAGE;
            case 1:
                return BodyType.ATHLETIC;
            case 2:
                return BodyType.OVERWEIGHT;
            case 3:
                return BodyType.UNSPECIFIED;
            default:
                return BodyType.UNSPECIFIED;
        }
    }

}
