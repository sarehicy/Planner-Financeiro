package model;

import java.util.ArrayList;

public class Month {
    private ArrayList<Income> incomes; 
    private ArrayList<Expense> expenses;
    private ArrayList<Transaction> transactions;
    private double totalIncome;
    private double totalExpense;
    private double balance;

    public Month(){
        incomes = new ArrayList<>();
        expenses = new ArrayList<>();
        transactions = new ArrayList<>();
        totalIncome = 0.0;
        totalExpense = 0.0;
        balance = 0.0;
    }
    
    public void addIncome(Income newIncome){
        
        /* # Business rule:
            The transactions of a month must all have different unique names.*/
        if(findTransaction(newIncome.get_name()) != -1){ // Transaction of the same name was found
            // throws exception
            return;
        }

        incomes.add(newIncome);

        calculateBalance();
    }

    public void rmvIncome(Income incomeToRmv){
        incomes.remove(incomeToRmv);
        calculateBalance();
    }

    public void addExpense(Expense newExpense){
        /* # Business rule:
            The transactions of a month must all have different unique names.*/
        if(findTransaction(newExpense.get_name()) != -1){ // Transaction of the same name was found
            // throws exception
            return;
        }

        expenses.add(newExpense);
        calculateBalance();
    }

    public void rmvExpense(Expense expenseToRmv){
        expenses.remove(expenseToRmv);
        calculateBalance();
    }

    // Aux methods -----------------------------------------------------------------
    private void calculateTotalIncome(){
        double aux = 0.0;

        // Adding up incomes
        for (Income income : incomes) {
            aux = aux + income.get_value();
        }

        this.totalIncome = aux;
    }

    private void calculateTotalExpense(){
        double aux = 0.0;

        // Adding up expenses
        for (Expense expense : expenses) {
            aux = aux + expense.get_value();
        }

        this.totalExpense = aux;
    }

    private void calculateBalance(){
        calculateTotalIncome();
        calculateTotalExpense();

        this.balance = totalIncome - totalExpense;
    }

    private int findTransaction(String transactionName){
        int start = 0;
        int end = transactions.size() -1;
        int mid = (start + end)/2;

        int flag;
        while (end>=start){
            flag = transactionName.compareTo(transactions.get(mid).get_name());

            if (flag == 0){
                return mid;
            }
            else if (flag == -1){ // transaction can only be in the first half
                end = mid -1;
            }
            else{ // transaction can only be in the second half
                start = mid +1;
            }

            mid = (start + end)/2;
        }
        
        // income not found
        return -1;
    }
 
    
}
