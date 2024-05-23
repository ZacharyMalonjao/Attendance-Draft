/*
 ______     ______   ______   ______     __   __     _____     ______     __   __     ______     ______    
/\  __ \   /\__  _\ /\__  _\ /\  ___\   /\ "-.\ \   /\  __-.  /\  __ \   /\ "-.\ \   /\  ___\   /\  ___\   
\ \  __ \  \/_/\ \/ \/_/\ \/ \ \  __\   \ \ \-.  \  \ \ \/\ \ \ \  __ \  \ \ \-.  \  \ \ \____  \ \  __\   
 \ \_\ \_\    \ \_\    \ \_\  \ \_____\  \ \_\\"\_\  \ \____-  \ \_\ \_\  \ \_\\"\_\  \ \_____\  \ \_____\ 
  \/_/\/_/     \/_/     \/_/   \/_____/   \/_/ \/_/   \/____/   \/_/\/_/   \/_/ \/_/   \/_____/   \/_____/ 
  ---------------------------------------------------------------------------------------------------------                                                                                                         
*/
package hoursworked;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class HoursWorked {


    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
 
//Initialize some juicy variables
     LocalTime timeIn = null; 
     LocalTime timeOut = null;
 //Initialize an array to store timeIn and timeOut    
     long[] duration;
     
do{
//Get start time
    while(timeIn == null){
        System.out.println("Insert time in: (HH;MM)");
        String clockInTime = sc.nextLine();
        timeIn = checkFormat(clockInTime);
    }
      
 //Get end time  
    while(timeOut==null){
        System.out.println("Insert time out: (HH;MM)");
        String clockOutTime = sc.nextLine();
        timeOut = checkFormat(clockOutTime);
    }
        
 //Shove those into a method      
      duration = findDuration(timeIn, timeOut);
         
//Output the juicy stuff     
           System.out.println("Time worked:" );
           System.out.println("   Hours: "+ duration[0]);
           System.out.println("   Minutes: "+ duration[1]);   
           System.out.println("====================================================");
           
//Adress negative outputs sa mga pasaway diyan
          if(duration[0]<0 || duration[1] < 0){
              System.out.println("Your output seems to be negative. Please retry :^)");
              timeIn = null;
              timeOut = null;
          }
//The do while loop is to loop the process if the user inputs values that return negative results04:50

         }while(duration[0]<0 || duration[1] < 0); 
        
           
           
           
        
    }
  //Method time 
      //A.K.A. Yung Sakit Sa Mata Na Ayaw Mo Makita Sa Main Method (YS²MNAM²SM² for short, Trademark Zachtionary)
    
  //findDuration() method
     private static long[] findDuration(LocalTime timeIn, LocalTime timeOut){
      
           Duration duration = Duration.between(timeIn, timeOut);
           long hours = duration.toHours();
           long minutes = duration.toMinutes() % 60;
           return new long[]{hours, minutes};        
    }
     private static LocalTime checkFormat(String time){
     
         if(!time.matches("\\d{2}:\\d{2}")){
             System.out.println("Please use HH:MM format (i.e. 04:00 instead of 4:00)");
             System.out.println("====================================================");
             return null;
         }
         try{ return LocalTime.parse(time);}
         
         catch(DateTimeParseException e){
             System.out.println("Please use Military time Format (standard 24 hr format)");
             System.out.println("====================================================");
             return null;
         }
         
         
         
     }
}
