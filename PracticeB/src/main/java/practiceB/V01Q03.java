/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practiceB;

/**
 *
 * @author Wong Yan Wen
 */
/*
Username Validation Rules: 

1. Must start with a letter (A–Z or a–z). 
2. Must be 5–15 characters long. 
3. Can contain letters, digits, or underscores only. 
4. Must not contain uppercase letters (all lowercase only). 
5. If invalid, display “Invalid username” and skip password validation for that case. 

Password Strength Rules (7 conditions): 

1. Minimum 8 characters 
2. At least one uppercase letter 
3. At least one lowercase letter 
4. At least one digit 
5. At least one special character (!, @, #, $, %, ^, &, *) 
6. Must not contain any spaces 
7. Must not contain the username as a substring (case-insensitive)

Enter username: alice 
Enter password: aLicE2024!
Password strentgh Strong
*/
import java.util.Scanner;
public class V01Q03 
{
    public static void main(String[] args)
    {
        String username;
        String password;
        int passwordRule=0;
        boolean valid = false;
        String strength;
        
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter username: ");
        username= keyboard.next();
        
        if (username.charAt(0)>='a'&& username.charAt(0)<='z')
        {
            if (username.length()>=5&& username.length()<=15)
            {
                for (int i =0 ; i<username.length();i++)
                {
                    if (username.charAt(i)=='-'|| (username.charAt(i)>='0' && username.charAt(i)<='9')|| (username.charAt(0)>='a'&& username.charAt(0)<='z'))
                    {
                        valid=true;
                    }
                    else
                    {
                        
                        System.out.println("Invalid username.");
                        break;
                    }
                }
            }
            else
            {
                
                System.out.println("Invalid username.");
            }
        
        }
        else
        {
            
            System.out.println("Invalid username.");
        }
           
        if(valid ==true)
        {
            System.out.print("\nEnter password: ");
            Scanner keyboardP = new Scanner (System.in);
            //next() cannot read empty space , next line can , must make sure scanner is blank before input string
            password= keyboardP.nextLine();
                        
            if (password.length()>=8)
            {
                passwordRule++;
                
                for (int j=0 ;j<password.length();j++)
                {
                    if(password.charAt(j)>='A'&& password.charAt(j)<='Z')
                    {
                       passwordRule++;
                       break;
                    }
                }
                
                for (int k=0;k<password.length();k++)
                {
                    if (password.charAt(k)>='a'&& password.charAt(k)<='z')
                    {
                        passwordRule++;
                        break;
                    }
                }
            
                
                for (int m=0;m<password.length();m++)
                {
                    if(password.charAt(m)>='0' && password.charAt(m)<='9')
                    {
                        passwordRule++;
                        break;
                    }
                
                }
                for(int n = 0;n<password.length();n++)
                {
                    if(password.charAt(n)=='!'||password.charAt(n)=='@'||password.charAt(n)=='#'||password.charAt(n)=='$'||password.charAt(n)=='%'||password.charAt(n)=='^'||password.charAt(n)=='&'||password.charAt(n)=='*')
                    {
                        passwordRule++;
                        break;
                    }
                    
                }
                
                       
                for(int p=0;p<password.length();p++)
                {
                    if( Character.isWhitespace(password.charAt(p)))
                    {
                      System.out.println("Invalid password.");  
                      break;//BREAK FOR LOOP
                    }
                    else if (p==(password.length()-1))
                    {
                        passwordRule++;
                    }   
                }

                /* ANOTHER WAY
                    //for string
                if (password.contains(" "))
                {
                    System.out.println("Invalid password.");
                    
                }
                else if (!(password.contains(" ")))
                    passwordRule++;
                     System.out.println("no space"+passwordRule);
                
                */
                
                
                if (!((password.toLowerCase()).contains(username)))
                {
                    passwordRule++;
                    
                }
  
            }
        
            
            
            if (passwordRule<=3)
                strength="Weak";
            else if (passwordRule >3 && passwordRule<=5)
                strength="Moderate";
            else if (passwordRule==6)
                strength="Strong";
            else
                strength="Very Strong";
                
            System.out.println("Password Strength: "+strength);
        }
    
    
    }
}
