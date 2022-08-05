package ethicalengine;



/**
 * description: Human
 * This class represents a human in the scenarios
 * @author: delongh
 */
public class Human extends Persona {
	public enum Profession {
	    DOCTOR,CEO, CRIMINAL, HOMELESS, UNEMPLOYED, NONE,DRIVER,CHEF;
	    }
	public enum AgeCategory {
	    BABY,CHILD,ADULT,SENIOR;

	}
    private int age ;



    private Profession profession;
    private Gender gender;
    private BodyType bodytype;
    private boolean isPregnant = false;
    private boolean isYou = false;

    public String getMyGender(){
        return gender.toString();
    }
    public String getMyProfession(){
        return profession.toString();
    }
    public String getMyBodyType(){
        return bodytype.toString();
    }
    public Integer getMyAge(){
        return age;
    }
    
    public Gender getGender(){
        return gender;
    }
    public Profession getProfession(){
        return profession;
    }
    public BodyType getBodyType(){
        return bodytype;
    }
    public int getAge(){
        return age;
    }

    public Human(int age, Profession profession, Gender gender, BodyType bodytype, boolean isPregnant){
        this.age = age;
        this.profession = profession;
        this.gender = gender;
        this.bodytype = bodytype;
        this.isPregnant = isPregnant;
    }

    public Human(Human otherHuman){
        this.age = otherHuman.age;
        this.profession = otherHuman.profession;
        this.gender = otherHuman.gender;
        this.bodytype = otherHuman.bodytype;
        this.isPregnant = otherHuman.isPregnant;
    }

    public Human() {
    	this.age=0;
    	this.profession=Profession.NONE;
    	this.gender=Gender.UNKNOWN;
    	this.bodytype=BodyType.UNSPECIFIED;
    	this.isPregnant=false;
    	this.isYou=false;

    }

    public BodyType getBodytype() {
		return bodytype;
	}
	public void setBodytype(BodyType bodytype) {
		this.bodytype = bodytype;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Human(int i, Gender gender, BodyType bodyType) {
        this.age = i;
        this.gender = gender;
        this.bodytype = bodyType;
    }


    public AgeCategory getAgeCategory(){
        if (this.age>=0&&this.age<=4){
            return AgeCategory.BABY;
        }
        if (this.age>=5&&this.age<=16){
            return AgeCategory.CHILD;
        }
        if (this.age>=17&&this.age<=68){
            return AgeCategory.ADULT;
        }
        if (this.age>68){
            return AgeCategory.SENIOR;
        }else {
            return null;
        }
    }

    public Profession getProfeSsional(){
        if (this.age>=17){
            return this.profession;
        }else {
            return Profession.NONE;
        }
    }

    public boolean isPregnant(){
        if ("FEMALE".equals(this.gender.toString())){
            return this.isPregnant;
        }else {
            return false;
        }
    }

    public void setPregnant(boolean pregnant){
        if ("FEMALE".equals(this.gender.toString())){
            this.isPregnant = pregnant;
        }
    }

    public boolean isYou(){
        return this.isYou;
    }

    public void setAsYou(boolean isYou){
        this.isYou = isYou;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (this.isYou){
            result.append("you");
            result.append(" ");
        }

        result.append(this.bodytype.toString());
        result.append(" ");

        result.append(this.getAgeCategory().toString());
        result.append(" ");

        if (this.age>=17){
            if (!"NONE".equals(this.profession.toString())){
                result.append(this.profession.toString());
                result.append(" ");
            }
        }

        result.append(this.gender.toString());
        result.append(" ");

        if (this.isPregnant&& "FEMALE".equals(this.gender.toString())){
            result.append("pregnant");
            result.append(" ");
        }
        result.deleteCharAt(result.length()-1);
        return result.toString().toLowerCase();
    }
	@Override
	public String getSpecies() {
		return null;
	}
	@Override
	public boolean isPet() {
		return false;
	}



}
