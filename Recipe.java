package DSAproject;

import java.util.Scanner;

public class Recipe { 
  private  String Title;
  private  String Ingridients;
  private  String Procedure=""; 
  
  void addTitle(){
    Scanner input = new Scanner(System.in);
    System.out.print("Title: ");
      Title= input.nextLine();
    input.close();
    
  }
  void addIngridients(){
    Scanner input = new Scanner(System.in);
    System.out.print("Ingridients: ");
    Ingridients= input.nextLine(); 
    input.close();
     
  }
  void addProcedure(){
    boolean end= true; //here the idea is as long as the user is typing when ever they press enter it creates next step and when they press Save button exit becomes false so it breaks out of the loop 
    int counter= 1; //so the save button is for the GUI coders so just for demonstration i used this variable so currently it just adds two steps but once the GUI is done this variable should be removed
    while(counter<3){
      Scanner input=new Scanner(System.in);
      String steps= "Step" + counter+ ": ";
      System.out.print(steps);
      Procedure= Procedure + steps +input.nextLine()+ "\n";
      ++counter;
      input.close();
    }
  }
  public String getTitle(){
    return Title; 
  }
  public String getIngridients(){
    return Ingridients; 
  }
  public String getProcedure(){  
    return Procedure;  
  }
  public String recipeToString(){
    return "Title: "+ Title+"\n"+"Ingridients: "+Ingridients+"\n"+ "Procedure\n"+ Procedure;
  }

}
