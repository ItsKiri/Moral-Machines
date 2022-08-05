package ethicalengine;




/**
 * description: Persona
 * an Abstract Class from which all Persona types inherit
 * @author: delongh
 */
public abstract class Persona {
	public enum BodyType {
	    AVERAGE,ATHLETIC,OVERWEIGHT,UNSPECIFIED;
	}
	public enum Gender {
	    FEMALE,MALE,UNKNOWN;

	}

    private int age = 0;

    private Gender gender = Gender.UNKNOWN;

    private BodyType bodyType = BodyType.UNSPECIFIED;

    public Persona(){
        this.gender = Gender.UNKNOWN;
        this.bodyType = BodyType.UNSPECIFIED;
        this.age = 0;
    }

    public Persona(int age, Gender gender, BodyType bodyType) {
        this.age = age;
        this.gender = gender;
        this.bodyType = bodyType;
    }

    public Persona(Persona otherPersona){
        this.bodyType = otherPersona.bodyType;
        this.age = otherPersona.age;
        this.gender = otherPersona.gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

	public abstract boolean isYou();

	public abstract String getSpecies();

	public abstract boolean isPet();

}
