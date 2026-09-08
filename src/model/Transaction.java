package model;

public class Transaction {
    private StringBuilder name; //I'm using a string builder instead of a string for efficiency
    private double value;
    private Boolean fixed;

    // Class Constructor  ----------------------------------------------------------

    /*  If the user provides invalid input to fulfill an attribute,
        the constructor will assing it a standard value.

        Standard transaction name: Unnamed
        Standard transaction value: 01.00
    */
    public Transaction(String transactionName, Double transactionValue, Boolean fixedStatus){

        if(transactionName.isEmpty() || transactionName == null || transactionName.isBlank()){
            this.name = new StringBuilder("Unnamed");
        }
        else{
            this.name = new StringBuilder(transactionName);
        }
        
        if(transactionValue < 0){
            this.value = 0.0;
        }
        else{
            this.value = transactionValue;
        }
        
        this.fixed = fixedStatus;
    }

    // Setters and getter Methods --------------------------------------------------

    /* If a setter method receives an invalid value as parameter, the method
       won't update the object's attribute  value and it will throw an exception */
       
    public void set_name(String newName){

        if(newName.isEmpty() || newName == null || newName.isBlank()){
            // throws exception
            return;
        }

        name.replace(0,name.length(), newName);
    }
    public String get_name(){
        return name.toString();
    }

    public void set_value(Double newValue){

        if(newValue < 0){
            //throws exception
            return;
        }

        this.value = newValue;
    }
    public Double get_value(){
        return value;
    }

    public void set_fixed_status(Boolean newStatus){
        this.fixed = newStatus;
    }
    public Boolean get_fixed_status(){
        return fixed;
    }

}