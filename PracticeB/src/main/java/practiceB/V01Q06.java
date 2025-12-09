package practiceB;

/**
 *
 * @author Wong Yan Wen
 */
/*
number guessing game(dragon egg )

int 10 attempt (tries)
int 3 right ans(range 1-10)-NO DUPILCATES
-ca,cb,cc
int 2 curse
scanner 
int ans

display welcome message
genrerate 3 random number ,a b c (chest) 1-10
generate 2 random number curse1 curse2  1-10

display guess a chest (1-10):

for (int attempt=10;attempt>=10;attempt --)
    scanner ans nextInt()
    if (ans == curse)
    display you have been curse
    attempt--
    if (ans == ca|| ans == cb || ans == cc)
        dsiplay yopu found a dragon egg
    else (aans != ca cb cc)
    {   
        if (Math.abs(ans-ca)<=3 || b|| c)
        warm close
        else
          far

       if (ans<=ca|| ans<=cb || ans<=cc)
            guess higher
       else
        gueess lower
        
          display no egg
    }
    display attempts left


*/
import java.util.Scanner;
import java.util.Random;
public class V01Q06 
{
    public static void main(String[] args)
    {
       int chestA,chestB,chestC;
       int cursedA,cursedB;
       int ans;
       Scanner keyboard = new Scanner (System.in);
       
       System.out.println("Welcome to the Dragon Egg Quest! ");
       System.out.println("There are 10 chests, 3 dragon eggs, and 2 cursed chests. ");
       System.out.println("You have 10 attempts to find all dragon eggs. ");
       
       Random r = new Random ();
       chestA = r.nextInt(9)+1;
       //prevent duplicates
       do{
       chestB = r.nextInt(9)+1;
       }while(chestB==chestA);
       
       do{
       chestC = r.nextInt(9)+1;
       }while(chestC==chestA||chestC==chestB);
       
       cursedA = r.nextInt(9)+1;
       do{
       cursedB = r.nextInt(9)+1;
       }while(cursedB==cursedA);
       
       //while loop can replace for loop
       //label loop for clear break
        attemptloop:
        for (int attempt=10;attempt>0;attempt--)
       {
           System.out.print("\nGuess a chest(1-10): ");
           ans=keyboard.nextInt();
           
           if (ans==cursedA || ans==cursedB)
           {
               System.out.println("This chest is cursed! Beware!");
               attempt--;
               System.out.println(attempt);
           }
           
           if (ans==chestA||ans==chestB||ans==chestC)
           {
               System.out.println("You found a dragon egg! ");
               // makes sure user cannot guess again
                if(ans==chestA)
                    chestA=0;
                else if (ans==chestB)
                    chestB=0;
                else 
                    chestC=0;
                
                if (chestA==0 && chestB==0 && chestC==0)
                {
                    //break loop when all have been found
                    break attemptloop;
                }
           }
           else
           {
               if (Math.abs((ans-chestA))<=3||Math.abs((ans-chestB))<=3||Math.abs((ans-chestC))<=3)
               {
                   System.out.println("Warm! You're very close to a dragon egg!");
               }
               else
               {
                   System.out.println("Cold! You're far from any dragon egg!");
               }
               
               if (ans<chestA||ans<chestB||ans<chestC)
               {
                   System.out.println("Hint: Try a higher chest number.");
               }
               else if (ans>chestA||ans>chestB||ans>chestC)
               {
                   System.out.println("Hint: Try a lower chest number.");
               }
               System.out.println("No egg here, keep searching!");
           }
           
           System.out.println("Attempts left: "+(attempt-1));
       
       }   
        
           if (chestA==0 && chestB==0 && chestC==0)
           {
               System.out.println("\nCongratulations! All dragon eggs are safe!");
           }
           else
           {
               System.out.println("\nGame Over! Some dragon eggs remain hidden!");
           }
    
    }
}
