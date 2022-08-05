package ethicalengine;



/**
 * description: Animal
 * This class represents animals in the scenarios
 * @author: delongh
 */
public class Animal extends Persona{
	private int age;
    private String species;
    private boolean isPet = false;

    public Animal(String species) {
        this.species = species;
    }

    public Animal() {

    }
    
    public Animal(int age, Gender gender, BodyType bodyType, String species) {
    	this.setAge(age);
    	this.setGender(gender);
    	this.setBodyType(bodyType);
    	this.species = species;
    }

    public Animal(Animal otheranimal) {
        this.species = otheranimal.species;
        this.isPet = otheranimal.isPet;
    }
    public int getAge() {
    	return this.age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public boolean isPet() {
        return this.isPet;
    }

    public void setPet(boolean pet) {
        this.isPet = pet;
    }

    @Override
    public String  toString(){
        if (this.isPet){
            return this.species +" is pet";
        }else {
            return this.species;
        }
    }

	@Override
	public boolean isYou() {
		return false;
	}
}
