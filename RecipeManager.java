package DSAproject;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class RecipeManager {
  static ArrayList<String> recipies= new ArrayList<>();
  static void addRecipe(){ 
    Recipe recipe = new Recipe();
    recipe.addTitle();    
    recipe.addIngridients(); 
    recipe.addProcedure(); 
    recipies.add(recipe.recipeToString()); 
  }
  static void removeRecipe(String recipe){ 
    for(String r:recipies){  
        if(recipe.equals(r)){  
          recipies.remove(r); 
          break;
      }
    }
  }
  static void viewRecipe(){       
      
      if(recipies!=null){ 
        for(String r:recipies){ 
     	 System.out.println(r); 
      }  
      }
      else{ 
        System.out.println("nothing to see here"); 
      }
      
   
    
    
  }
  static String search(String item){  
    Iterator <String>searchFor= recipies.iterator();
    while(searchFor.hasNext()){
      String a=searchFor.next();
      if(a.toLowerCase().contains(item.toLowerCase())){ 
        return a;
        
      }
      
    }
    return "We cant find what you are looking for";
  }


//This main method is just for testing the methods 
  public static void main(String[] args) {   
    Scanner sc= new Scanner(System.in);
    boolean exit= true;
    while(exit){
            System.out.println("Welcome to our Recipie Manager App");
            System.out.println("1. Add Recipies");
            System.out.println("2. Delete Recipies");
            System.out.println("3. View Recipies");
            System.out.println("4. Search Recipies");
            System.out.println("5. Exit");
            System.out.print("Enter the number of the task you want to do: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume the leftover newline character
            switch (choice){
                case 1:
                    System.out.print("Add your recipe! ");
                    addRecipe();    
                    break;
                case 2:
                	System.out.print("Enter the number of the recipie you want to delete: ");
                	//also here the user should add a number to delete but after a button is made that button will access the recipie's index and use delete that recipie from the arraylist
                	int delete= sc.nextInt();
                	sc.nextLine();  // Consume the leftover newline character
                	removeRecipe(recipies.get(delete-1));
                	break;
                case 3:
                    viewRecipe();  
                    
                    
                    break;
                case 4:
                    System.out.print("Enter what you want to search in recipies: "); 
                    String searching = sc.nextLine(); 
                    System.out.println(search(searching));  
                    break;
                case 5: 
                    exit = false;
                    break; 
                default:
                    System.out.println("Please choose numbers from 1 to 4"); 
            }
    }
    sc.close();
    
    
  }

}
//I didnt do sorting that's left for the next backend coder 
//also i didnt add exceptions because after GUI we will have completly different exceptions so it didnt seem neccessary
