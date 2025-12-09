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
You have just landed a part-time job at the “Kopi-Satu” café, which is the most popular 
hangout spot on campus. The lunchtime crowd is hectic, and Kak Sue, the owner, wants to 
move from her old handwritten receipts to a smart digital billing system that automatically 
calculates taxes, applies discounts, and rewards loyal customers. 
The new system not only needs to handle various items with flexible prices but must also 
apply conditional taxes, tiered discounts, and cashback bonuses depending on the total 
purchase amount, day of the week, and time of purchase. 
Your program should therefore perform the following operations with proper input validation 
and branching logic: 

Requirements: 
1. The cashier enters prices for multiple items, one at a time. Entering 0 ends the order. 
o If a negative price is entered, display an error and ask for a valid amount 
again. 
o Ensure at least one valid item is entered before proceeding. 

2. Calculate Service Tax (SST) based on subtotal: 
o Subtotal ≤ RM 30 → 6% 
o RM 30 < Subtotal ≤ RM 100 → 8% 
o Subtotal > RM 100 → 10% 

3. Apply Discounts: 
o Student Saver Discount (Weekdays only): 
If total before discount > RM 25, apply 10% discount. 
o Happy Hour Discount (Mon–Fri, 15:00 to 16:59): 
Additional 5% discount 
o Weekend Combo Discount (Sat–Sun): 
If subtotal ≥ RM 50, apply 5% discount. 
o If an invalid day or hour (0-23) is entered, display an error and re-prompt. 

4. Apply Membership Loyalty Cashback: 
o If the customer enters Y for membership, they earn a 2% cashback on the 
final payable amount. 

5. Display a detailed receipt showing: 
o Subtotal 
o Service Tax 
o Each discount type applied 
o Final payable amount and cashback (if applicable)


*/
import java.util.Scanner;
public class V01Q02 
{
    public static void main(String[] args)
    {
        double itemPrice;
        double subtotal=0;
        double tax;
        double taxPrice;
        double totalBeforeDiscount=0;
        
        double SSD=10;
        double SSDprice;
        double HHD=5;
        double HHDprice;
        double WCD=5;
        double WCDprice;
        
        double totalPayable=0;
        double loyalty=2;
        double loyaltyPrice;
        double finalAmount=0;
        String dayOfWeek;
        
        int hour;
        char member;
        
        Scanner keyboard= new Scanner (System.in);
        do{
            System.out.print("Enter item price(0 to finish): ");
        
            itemPrice=keyboard.nextDouble();
        
            if(itemPrice<0)
                System.out.println("Invalid amount. Price cannot be negative. Please re-enter.");
            else
                subtotal+=itemPrice;
            
        }while(itemPrice!=0);
    
        do{ 
            System.out.print("Enter day of week: ");
            //nextLine no responds
            dayOfWeek = keyboard.next();
            dayOfWeek=dayOfWeek.toLowerCase();
            //must use && NOT ||
            //❤️🤷‍♀️☆*: .｡. o(≧▽≦)o .｡.:*☆if you put semicolon at the end of if it will pruint invalid regradless correct of not
            if(!(dayOfWeek.equals("monday"))&& !(dayOfWeek.equals("tuesday"))&& !(dayOfWeek.equals("wednesday"))&& !(dayOfWeek.equals("thursday"))&& !(dayOfWeek.equals("friday"))&& !(dayOfWeek.equals("saturday"))&& !(dayOfWeek.equals("sunday")))
            {   
                System.out.println("Invalid day.Please enter again.");
            }

        }while(!(dayOfWeek.equals("monday"))&& !(dayOfWeek.equals("tuesday"))&& !(dayOfWeek.equals("wednesday"))&& !(dayOfWeek.equals("thursday"))&& !(dayOfWeek.equals("friday"))&& !(dayOfWeek.equals("saturday"))&& !(dayOfWeek.equals("sunday")));

        do{
            System.out.print("Enter hour (24-hour format): ");
            hour = keyboard.nextInt();
           
            if(hour<0||hour>23)
                System.out.println("Invalid hour. Please enter integers from 0-23.");
        }while(hour<0||hour>23);
        
        System.out.print("Is customer a member(Y/N): ");
        member=keyboard.next().charAt(0);
    
        if (subtotal<=30)
            tax=6;
        else if (subtotal>30 && subtotal<=100)
            tax=8;
        //subtotal>100
        else   
            tax=10;
        
        taxPrice=subtotal*tax/100;
        totalBeforeDiscount=subtotal+taxPrice;
        totalPayable=totalBeforeDiscount;
        
        System.out.println("\n------Kopi-Satu Receipt-----");
        System.out.printf("\nSubtotal:\t\tRM %.2f",subtotal);
        //%% means print % in printf
        System.out.printf("\nService Tax( %.0f %%):\tRM%.2f ",tax,taxPrice);
        System.out.printf("\nTotal before discount:\tRM %.2f ",totalBeforeDiscount);
        
        switch (dayOfWeek)
        {        
            case "saturday","sunday":
                if (subtotal>=50)
                {
                    WCDprice=totalBeforeDiscount*WCD/100;
                    System.out.printf("\nWeekend Combo Discount (%.0f%%):RM %.2f ",WCD,WCDprice);
                    totalPayable=totalBeforeDiscount-WCDprice;
                }
            break;
            
            case "monday","tuesday","wednesday","thursday","friday":
                if(totalBeforeDiscount>25)
                {
                   
                   SSDprice=totalBeforeDiscount*SSD/100;
                   System.out.printf("\nStudent Discount (%.0f%%):\tRM %.2f",SSD,SSDprice);
                   totalPayable=totalPayable-SSDprice;
                }
                
                if (hour>=15 && hour<=16.59)
                {
                    HHDprice=totalBeforeDiscount*HHD/100;
                    System.out.printf("\nHappy Hour Discount(%.0f %%):RM %.2f ",HHD,HHDprice);
                    totalPayable=totalPayable-HHDprice;
                }
                
                
            break;
            //not include also can
            //default:break;
    
        }
        
        System.out.printf("\nTotal Payable:\t\tRM %.2f",totalPayable);
        if (member=='Y')
        {
            loyaltyPrice=totalPayable*loyalty/100;
            finalAmount=totalPayable-loyaltyPrice;
            System.out.printf("\nLoyalty Cashback(2%%):\tRM%.2f",loyaltyPrice);
        }
        else if (member=='N')
              finalAmount=totalPayable;

        System.out.printf("\nFinal Amount to Collect:\tRM %.2f",finalAmount);
    }
            
            
}
