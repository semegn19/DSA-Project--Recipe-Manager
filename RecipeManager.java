package DSAproject;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
public class RecipeManager {
  static ArrayList<Recipe> recipies= new ArrayList<>();
  static void addRecipe(){ 
    Recipe recipe = new Recipe();
    recipe.addTitle();    
    recipe.addIngredients(); 
    recipe.addProcedure(); 
    recipies.add(recipe); 
  }
  static void removeRecipe(Recipe recipe){ 
    for(Recipe r:recipies){  
        if(recipe.equals(r)){  
          recipies.remove(r); 
          break; 
      }
    }
  }
  static void sortRecipe() {
        for (int i = 0; i < recipies.size() - 1; i++) {
            for (int j = 0; j < recipies.size() - i - 1; j++) {
                if (recipies.get(j).getTitle().compareTo(recipies.get(j + 1).getTitle()) > 0) {
                    Collections.swap(recipies, j, j + 1);
                }
            }
        }
    }

    static void viewRecipe() {
        sortRecipe();
        if (recipies != null && !recipies.isEmpty()) {
            for (Recipe r : recipies) {
                System.out.println(r.recipeToString());
            }
        } else {
            System.out.println("nothing to see here");
        }
    }
  static String search(String item){  
    Iterator <Recipe>searchFor= recipies.iterator();
    while(searchFor.hasNext()){
      Recipe a=searchFor.next();
      if(a.recipeToString().toLowerCase().contains(item.toLowerCase())){ 
        return a.recipeToString();
        
      }
      
    }
    return "We cant find what you are looking for";
  }
  

//This main method is just for testing the methods 
  public static void main(String[] args) {   
    
   // System.out.println(recipies.size());
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
