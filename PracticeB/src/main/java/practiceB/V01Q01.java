package practiceB;
/**
 *
 * @author Wong Yan Wen
 */
/*
prompt user fir test case
for each case , repeat 
    prompt
    65  Days overdue 
    c   Book type code (R/G/M/C/T)  
    s   Borrower category (S for Student, T for Staff) 
    4   Number of previous late returns 

    calculate 
        Base Fine: (10 days * 2.00) + (55 days * 5.00) = 20.00 + 275.00 = RM 295.00 
          > 60 days penalty: + RM 25.00 
         Habitual offender (4 >= 3): + RM 10.00 
          Total: 295 + 25 + 10 = RM 330.00
     print
*/
import java.util.Scanner;
public class V01Q01 
{

    public static void main(String[] args) 
    {
        int testCase;
        int daysOverdue;
        char bookTypeCode;
        char borrowerCategory;
        int  prevLate;
        double TotalFine;
        
        System.out.print("Please enter the number of test cases: ");
        Scanner keyboard =new Scanner (System.in);
        testCase=keyboard.nextInt();
      
        
        for (int i=1;i<=testCase;i++)
        {
            TotalFine=0;
            System.out.print("\nPlease enter days overdue: ");
            daysOverdue = keyboard.nextInt();
            
           
            System.out.println("\nNOTE BOOK TYPE CODE: \nR-reference book\nG-general book\nM-magazine\nC-multimedia\nT-Thesis");
            System.out.print("\nPlease enter book type code: ");
            bookTypeCode= keyboard.next().charAt(0);
            
            System.out.print("\nPlease enter borrower category. (T-Staff , S- Student):");
            borrowerCategory=keyboard.next().charAt(0);
            
            System.out.print("\nPlease enter number of previous late returns: ");
            prevLate = keyboard.nextInt();
            
            switch (bookTypeCode)
            {
                case 'R':
                    if (daysOverdue>0)
                        TotalFine+=100.00;
                break;
                
                case 'G':
                    if (daysOverdue<=7)
                        TotalFine+=(0.50*daysOverdue);
                    //MUST PUT && IF NOT DAYSOVERDUE =2 WILL GO HERE EG: LINE 65 AND LINE 68 
                    if(daysOverdue>=8 && daysOverdue<=30)
                        TotalFine+=(0.50*7)+(1.00*(daysOverdue-7));
                    // MUST ELSE IF , IF NOT DAYSOVERDUE =2 WILL GO HERE
                    else if (daysOverdue>30)
                        TotalFine+=(0.50*7)+(1.00*23)+(2.00*(daysOverdue-30));
                break;
                
                case 'M':
                    if (daysOverdue>0)
                        TotalFine+=(0.20*daysOverdue);
                break;
                
                case 'C':
                    if (daysOverdue<=10)
                        TotalFine+=(2.00*daysOverdue);
                    else
                        TotalFine+=(2.00*10)+(5*(daysOverdue-10));
                break;
                
                case 'T':
                    if(daysOverdue>0)
                    {
                        TotalFine+=(10.00*daysOverdue);
                        
                        if(daysOverdue>15)
                           TotalFine+=200.00; 
                    }
                break ;
                
                default :System.out.println("Invalid code.");break;
          
            }
            
            
            if (daysOverdue>60)
                TotalFine+=25.00;
            
            
            if (prevLate>=3)
                TotalFine+=10.00;
            else if (prevLate==0 && daysOverdue<=3 )
            {   
                if (borrowerCategory=='T')
                    TotalFine*=0.80;
                else
                    TotalFine*=0.50;
            }
             System.out.println(""+daysOverdue+" "+bookTypeCode+" "+borrowerCategory+" "+prevLate+"");
             System.out.println("--- Case "+i+" ---");
             System.out.printf("Total Fine: RM %.2f  ",TotalFine);
        
        
        }
        
        
    }
}
