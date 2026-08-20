import model.*;

import java.util.Scanner;

public class PlannerFinanceiro {
  public static void main(String args[]){
    Scanner myObj = new Scanner(System.in);

    Income income = new Income("Salario", 912.00, true);

    System.out.println(income.get_name());
    System.out.println(income.get_value().toString());
    income.set_value(-1.0);
    System.out.println(income.get_value().toString());
    String nomenovo = myObj.nextLine();
    income.set_name(nomenovo);
    System.out.println(income.get_name());

  }  
}
