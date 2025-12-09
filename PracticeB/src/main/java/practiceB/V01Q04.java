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
declare ...
day  mobnth year daysOfMonth winner
prompt user for ic , scanner 

day= chaerAt(4)+charAt(5)
month = charAt(2)+charAt(3)

if charAt(0)==0 || charAt(0)<=2 && charAt(1)<=5
    year = "20"+charAt(0)+charAT(1)

if (charAt(0)>=2 && charAt(1)<=9)
    year = "19"+charAt(0)+charAt(1)

if (charAt last%2=0))
    gender female
else
    gender male

if month 01,03,05,07,08,10,12
long month

if month()
        daysOfmonth=31
else if (02)
    dysof Month =28 lshort
else 
    daysof Month=30 short

for all character 
    sum+=charAt();

if (gender = male)
    if sum%5==0 && short month 
        winner=yes
else
    if (sum%7==0&& long mointh)
    
print birthdate=day/month/year



*/
import java.util.Scanner;
public class V01Q04 
{
    public static void main(String[] args)
    {
        String ic;
        String day="";
        String month="";
        String year="";
        String gender;
        String typeOfMonth="";
        int sum=0;
        
        
        String h="235";
        System.out.print(h.charAt(2)%2);
        System.out.print("Enter IC number(YYMMDD-##-####): ");
        Scanner keyboard = new Scanner(System.in);
        ic= keyboard.nextLine();
        
        day+=ic.charAt(4);
        day+=ic.charAt(5);
        
        
        month+=ic.charAt(2);
        month+=ic.charAt(3);
        
        //MUST HAVE QUOTE
        if (ic.charAt(0)=='0'|| (ic.charAt(0)<='2' && ic.charAt(1)<='5'))
        {
            year = "20";
            year+=ic.charAt(0);
            year+=ic.charAt(1);
        }
        
        if (ic.charAt(0)>='2' && ic.charAt(1)<='9')
        {
            year = "19";
            year+= ic.charAt(0);
            year+= ic.charAt(1);
        }
   
        System.out.print("\nBirth Date:"+day+"/"+month+"/"+year+"");
        if (ic.charAt(13)%2==0)
        {
            gender="female";
        }
        else
            gender="male";
        
        System.out.print("\nGender: "+gender);

        //MUST USE EQUALS FOR STRING
        if (month.equals("01")|| month.equals("03")||month.equals("05")||month.equals("07")||month.equals("08")||month.equals("10")||month.equals("12"))
            typeOfMonth="long month";

        if  (month.equals("02")|| month.equals("04")||month.equals("06")||month.equals("09")||month.equals("11"))
            typeOfMonth="short month";
        
        for (int i=0;i<ic.length();i++)
        {
            if(ic.charAt(i)=='-')
                continue;
            else
            {
                //this will print out ascii for 0 ,whoich is 48 +sum(0),logic error
              /*
               sum= sum + ic.charAt(i);
            System.out.println(""+sum+"+ "+ic.charAt(i)+"= "+ic.charAt(i));
                */
                
                
                // CONVERSION OF CHAR TO INT , MINUS QUOTE 0
                /*
                When you subtract the character '0' (which has an ASCII value of 48) 
                from any digit character '0' through '9', 
                you get the corresponding integer 0 through 9.
                */
                sum+=(ic.charAt(i)-'0');
                
            }
        }
            
        System.out.print("\nSum of digits: "+sum);
        
       
        if (gender.equals("male"))
        {
            if (sum%5==0 && typeOfMonth.equals("short month")) 
                System.out.print("\nLucky Winner: Yes");
            else
                System.out.print("\nLucky Winner: No ");
        }
        else
        {
            if (sum%7==0 && typeOfMonth.equals("long month"))
                System.out.print("\nLucky Winner: Yes ");
            else
                System.out.print("\nLucky Winner: No");
            
        }
        
            
          
    }
}
