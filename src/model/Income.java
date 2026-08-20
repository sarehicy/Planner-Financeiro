package model;

public class Income {
    private StringBuilder name; //I'm using a string builder instead of a string for efficiency
    private Double value;
    private Boolean fixed;

    // # Class Constructor #
    public Income(String incomeName, Double incomeValue, Boolean fixedStatus){
        this.name = new StringBuilder(incomeName);
        this.value = incomeValue;
        this.fixed = fixedStatus;
    }

    // # Name setter and getter #
    public void set_name(String newName){
        name.replace(0,name.length(), "newName");
    }

    public String get_name(){
        return name.toString();
    }

    // # Value setter and getter #
    public void set_value(Double newValue){

        //Business logic should be kept in the model!
        // this will throw an excpetion 
        if(newValue <=0){
            return;
        }

        this.value = newValue;
    }

    public Double get_value(){
        return value;
    }

    // # Fixed status setter and getter #
    public void set_fixed_status(Boolean newStatus){
        this.fixed = newStatus;
    }

    public Boolean get_fixed_status(){
        return fixed;
    }


}
