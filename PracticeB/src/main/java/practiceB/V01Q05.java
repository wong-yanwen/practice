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
String.length >>>>>start count from 1,imncludes space
CharAt() >>>> start count from 0,includes space

binary= bit + binary;
String= int + string >>>>>>outputs string ,int wont change to ascii 
TO RPINT REVERSE CAN USE
FOR (INT i=COUNT-1;I>0;I--)
invertedSum+=(inverted.charAt(k)-'0')>>>>addtion, actual value
invertedSum+=inverted.charAt(k)>>>>>>>>>>addition , ASCII VALUE
-------------------------------------------
prompt user 
scan
print encided message 

FOR every word in the string
    convert to ascii decimal value
    do repeated division to get bit
    concat bit to string
    form binary 
    make sure binaryu 8 bit

    for every character in binary
        invert values

    for every character in inverted
        convert to decimal

    print ans

*/
import java.util.Scanner;
public class V01Q05 
{
    public static void main(String[] args)
    {
        String message;
        int code;
        int bit;
        String binary;
        String inverted ;
        int invertedSum;

        System.out.print("Enter Original message: ");
        Scanner keyboard = new Scanner (System.in);
        message = keyboard.nextLine();
        System.out.println("\nEncoded Message: ");
        
        //FOR EVRY CHARACTER IN THER MESSAGE
        for (int p=0;p<message.length();p++)
        {
            //reinitialized everything to avoid errors in next loop
            code=0;
            binary ="";
            inverted="";
            invertedSum=0;
            
            
            //code is int , "+" here means SUM of ASCII VALUE
            code+=(message.charAt(p));
        
            //System.out.println(code);
            do 
            {
                bit =code%2;
                code=code/2;
                //binary is string , so "+" means concacetation here
                binary= bit + binary;
            }while(code!=0);
            
            //make sure 8 BIT
            if (binary.length()<8)
            {
                
                while(binary.length()<8)
                {
                   binary="0"+binary;
                   
                }
                
                /*dDOESNT WORK and very confusing
                for (int i=1;i<=(8-binary.length());i++)
                {
                    binary="0"+binary;
                    System.out.println(binary);
                }*/
            }
            // FOR EVERY CHARACTER IN THE BINARY STRING
            for (int j =0 ;j<binary.length();j++)
            {
                //invert bit 
                if (binary.charAt(j)=='0')
                    inverted +="1";
                else
                    inverted+="0";
                            
            } 
            //FOR EVERY CHARACTER IN INVERTED
            for (int k=0;k<inverted.length();k++)
            {
                //convert char to number by minusing '0'
                invertedSum+=((inverted.charAt(k)-'0')*Math.pow(2,(7-k)));   
            }
            
            System.out.print(invertedSum +" ");
        }
    }
}
