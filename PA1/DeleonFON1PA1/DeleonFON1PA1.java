/***********************************************************************************************
  * Author: Frankie Deleon 
  * Course Section: IS-2063-ON2 
  * Date: 03/21/2023 
  *********************************************************************************************/
import java.util.Calendar; //import calendar
import java.util.Scanner; // import scanner

public class DeleonFON1PA1 // Begin class DeleonFON1PA1
{ //Begin class scope
  /* Method Purpose:  Users are prompted for the projected sales revenue, the number of sales reps,
   * the number of quarters a rep has worked, the quarter(s) in which revenue was earned, and the sales revenue
   * for each month within a quarter. If the sales rep is earning 50% or above their target, than an encouraging
   * message is given; otherwise, a warning that sales are lagging behind. If sales revenue for the company is 
   * greater than or equal to 100% of projected annual sales, then employees qualify for a 2-5% year-end bonus;
   * otherwise, the sales are not on track to meet projections, and no year- end bonus can be expected
   */
  public static void main(String[] args) //Main method header
  { // begin method scope
    //Declare variables to be used.
    String salesRep = ""; //declare empty salesRep string.
    String monthNo = ""; //declare empty monthNo string.
    String quarter = ""; //declare empty quarter string.

    double salesRevenue; //declare salesRevenue double. 
    double annualSales = 0.0; //declare annualSales double. 
    double projectedSales; //declare projectedSales double. 
    double percOfTargetCo; //declare percOfTargetCo double. 
    double percOfTargetRep; //declare percOfTargetRep double. 

    int qtrChoice = 0; //declare qtrChoice int to zero.
    int monthCounter = 0; //declare monthCounter int to zero.
    int qtrCounter = 0; //declare qtrCounter int to zero.
    int noOfQtrs = 0; //declare noOfQtrs int to zero.
    int noOfMonths = 3; //declare noOfMonths int to three.
    int noSalesReps = 0; //declare noSalesReps int to zero.
    int salesRepCtr = 0; //declare salesRepCtr int to zero.
    Scanner input = new Scanner(System.in); //declare input variable for scanner inputs.
    Calendar dateTime = Calendar.getInstance(); //declare dateTime variable to get calendar instance.

    
    System.out.printf("%nWhat is the projected annual sales for Tandem?"); //print prompt 1.
    projectedSales = input.nextDouble(); //gather input for projectedSales double variable from prompt 1.

    
    System.out.printf("%nHow many sales reps work for Tandem?"); //print prompt 2.
    noSalesReps = input.nextInt(); //gather input for noSalesReps int variable from prompt 2. 
    input.nextLine(); // buffer clear to move to nextLine.

    //prompt 1 & 2 coded before the do-while loop which controls the sales rep.


    do //Begin do-while loop
    { // begin scope
       qtrCounter = 1; // assign qtrCounter to 1
       double quarterlySales = 0.0; //zero out quarterlySales
       salesRepCtr++; //post increment salesRepCtr

       //print prompt 3.
       System.out.printf("%nEnter the name of %s sales rep: ", salesRepCtr == 1 ? "a" : "the next");
       salesRep = input.nextLine(); //gather String input for salesRep.

       //print prompt 4.
       System.out.printf("%nEnter the number of quarters worked (no less than 1 or greater than 4): ");
       noOfQtrs = input.nextInt(); //gather input for noOfQtrs int. 
       
       //nest while loop to control the number of quarters.
       while(qtrCounter <= noOfQtrs) //begin while loop for qtrCounter less than or equal to noOfQtrs
         { //being scope
         monthCounter = 1; //initialize monthCounter to 1.
         //prompt 5
         System.out.printf("1. First Quarter%n"); //print first quarter option.
         System.out.printf("2. Second Quarter%n"); //print second quarter option.
         System.out.printf("3. Third Quarter%n"); //print third quarter option.
         System.out.printf("4. Fourth Quarter"); //print fourth quarter option.   
         //print prompt 5.
         System.out.printf("%n%nChoose the %squarter in which sales were earned: ", qtrCounter > 1 ? "next " : "");
         qtrChoice = input.nextInt(); //gather input for qtrChoice int.
         
         //content for quarter variable
         quarter = (qtrChoice == 1) ? "First Quarter" : (qtrChoice == 2) ? "Second Quarter" : (qtrChoice == 3) ? "Third Quarter" : "Fourth Quarter";


         //second nested while loop to control the number of months within a quarter.
         while (monthCounter <= noOfMonths)//while monthCounter is less than or equal to noOfMonths.
         {//begin scope
           //if-else statement to assign 1st, 2nd, snd 3rd to monthNo based on monthCounter.
           if(monthCounter == 1)
           {
             monthNo ="1st";
           } else if (monthCounter == 2)
           {
             monthNo = "2nd";
           } else
           {
             monthNo = "3rd";
           }
           
           //print prompt 6.
           System.out.printf("%nEnter the sales revenue for the %s month of the %s: ", monthNo, quarter); 
           salesRevenue = input.nextDouble(); // gather input for salesRevenue double. 
            
           //use combined assignment operator to add salesRevenue to quarterlySales
           quarterlySales += salesRevenue;

           //pre-increment monthCounter
           ++monthCounter;
         }//end while (monthCounter <= noOfMonths)
         annualSales += quarterlySales; //use combined assignment operator to add quarterlySales to annualSales
         ++qtrCounter;
       }//end while (qtrCounter <= noOfQtrs)
       input.nextLine();
       //print the output for sales rep.
       System.out.printf("%n%nTANDEM ENTERPRISES%n");
       System.out.printf("SALES REVENUE FOR %d QUARTER(S) OF %s", noOfQtrs, dateTime.get(Calendar.YEAR));
       System.out.printf("%nSALES REP:  %s%n", salesRep);
       System.out.printf("%nTotal Year-To-Date:            $%,.2f%n",quarterlySales);

       //calculate the percOfTargetRep, which determines the sales rep is on target for their projected sales.
       percOfTargetRep = quarterlySales / (projectedSales/noSalesReps) * 100;
       
       //test if percOfTargerRep is greater than or equal to 50 if noOfQtrs is less than 4.
       if(noOfQtrs <4){
         if(percOfTargetRep >= 50){
           //print 2
           System.out.printf("%nKeep up the GOOD work, %s. There is a " + "possible year-end bonus!%n", salesRep.substring(0, salesRep.indexOf(' ')));
         }else
           //print 3
           System.out.printf("%nSo far sales are lagging begind projections.%n");
       }
    }while (salesRepCtr < noSalesReps);//end do-while
    
      percOfTargetCo = (annualSales/projectedSales)* 100;
      //print 4
      System.out.printf("%nCORPORATE SALES PERFORMANCE%n");
      if (percOfTargetCo >= 100){
        //print 5
        System.out.printf("%nIt's been a GOOD year so far. There could be a year-end bonus of about 2-5%% if we can keep on top of our sales goals. Thank you all and please continue your excellent effort!%n");
      }else {
        //print 6
        System.out.printf("%nSales are lagging projections. A year-end bonus may not be possible.%n");
      }
     System.exit(0); // exit
    } // end of main
} //end of class

/* Output 1:
 * What is the projected annual sales for Tandem?500000
 * 
 * How many sales reps work for Tandem?2
 *
 * Enter the name of a sales rep: Julian Caesar
 *
 * Enter the number of quarters worked (no less than 1 or greater than 4): 1
 * 1. First Quarter
 * 2. Second Quarter
 * 3. Third Quarter
 * 4. Fourth Quarter
 *
 * Choose the quarter in which sales were earned: 2
 *
 * Enter the sales revenue for the 1st month of the Second Quarter: 100000
 *
 * Enter the sales revenue for the 2nd month of the Second Quarter: 50000
 *
 * Enter the sales revenue for the 3rd month of the Second Quarter: 100000
 *
 *
 * TANDEM ENTERPRISES
 * SALES REVENUE FOR 1 QUARTER(S) OF 2023
 * SALES REP:  Julian Caesar
 *
 * Total Year-To-Date:            $250,000.00
 *
 * Keep up the GOOD work, Julian. There is a possible year-end bonus!
 *
 * Enter the name of the next sales rep: Monique La Femme
 *
 * Enter the number of quarters worked (no less than 1 or greater than 4): 2
 * 1. First Quarter
 * 2. Second Quarter
 * 3. Third Quarter
 * 4. Fourth Quarter
 *
 * Choose the quarter in which sales were earned: 1
 *
 * Enter the sales revenue for the 1st month of the First Quarter: 5000
 *
 * Enter the sales revenue for the 2nd month of the First Quarter: 6000
 *
 * Enter the sales revenue for the 3rd month of the First Quarter: 5000
 * 1. First Quarter
 * 2. Second Quarter
 * 3. Third Quarter
 * 4. Fourth Quarter
 *
 * Choose the next quarter in which sales were earned: 2
 *
 * Enter the sales revenue for the 1st month of the Second Quarter: 5000
 *
 * Enter the sales revenue for the 2nd month of the Second Quarter: 6000
 *
 * Enter the sales revenue for the 3rd month of the Second Quarter: 5000
 *
 *
 * TANDEM ENTERPRISES
 * SALES REVENUE FOR 2 QUARTER(S) OF 2023
 * SALES REP:  Monique La Femme
 *
 * Total Year-To-Date:            $32,000.00
 *
 * So far sales are lagging begind projections.
 *
 * CORPORATE SALES PERFORMANCE
 *
 * Sales are lagging projections. A year-end bonus may not be possible.
 * Output 2:
 * What is the projected annual sales for Tandem?500000
 * 
 * How many sales reps work for Tandem?2
 *
 * Enter the name of a sales rep: Julian Caesar
 *
 * Enter the number of quarters worked (no less than 1 or greater than 4): 1
 * 1. First Quarter
 * 2. Second Quarter
 * 3. Third Quarter
 * 4. Fourth Quarter
 *
 * Choose the quarter in which sales were earned: 2
 *
 * Enter the sales revenue for the 1st month of the Second Quarter: 100000
 *
 * Enter the sales revenue for the 2nd month of the Second Quarter: 50000
 *
 * Enter the sales revenue for the 3rd month of the Second Quarter: 100000
 *
 *
 * TANDEM ENTERPRISES
 * SALES REVENUE FOR 1 QUARTER(S) OF 2023
 * SALES REP:  Julian Caesar
 *
 * Total Year-To-Date:            $250,000.00
 *
 * Keep up the GOOD work, Julian. There is a possible year-end bonus!
 *
 * Enter the name of the next sales rep: Monique La Femme
 *
 * Enter the number of quarters worked (no less than 1 or greater than 4): 2
 * 1. First Quarter
 * 2. Second Quarter
 * 3. Third Quarter
 * 4. Fourth Quarter
 *
 * Choose the quarter in which sales were earned: 1
 *
 * Enter the sales revenue for the 1st month of the First Quarter: 5000
 *
 * Enter the sales revenue for the 2nd month of the First Quarter: 6000
 *
 * Enter the sales revenue for the 3rd month of the First Quarter: 5000
 * 1. First Quarter
 * 2. Second Quarter
 * 3. Third Quarter
 * 4. Fourth Quarter
 *
 * Choose the next quarter in which sales were earned: 2
 *
 * Enter the sales revenue for the 1st month of the Second Quarter: 5000
 *
 * Enter the sales revenue for the 2nd month of the Second Quarter: 6000
 *
 * Enter the sales revenue for the 3rd month of the Second Quarter: 5000
 *
 *
 * TANDEM ENTERPRISES
 * SALES REVENUE FOR 2 QUARTER(S) OF 2023
 * SALES REP:  Monique La Femme
 *
 * Total Year-To-Date:            $32,000.00
 *
 * So far sales are lagging begind projections.
 *
 * CORPORATE SALES PERFORMANCE
 *
 * Sales are lagging projections. A year-end bonus may not be possible.
 * Compiler is using classPath = '[C:\Users\Frankie\Desktop\IS-2063\New folder, C:\Users\Frankie\Desktop\IS-2063\PA1\DeleonFON1PA1, C:\Users\Frankie\Desktop\drjava-beta-20190813-220051.jar]';  bootClassPath = 'null'
 *
 * What is the projected annual sales for Tandem?500000
 *
 * How many sales reps work for Tandem?2
 *
 * Enter the name of a sales rep: Julian Caesar
 *
 * Enter the number of quarters worked (no less than 1 or greater than 4): 1
 * 1. First Quarter
 * 2. Second Quarter
 * 3. Third Quarter
 * 4. Fourth Quarter
 *
 * Choose the quarter in which sales were earned: 2
 *
 * Enter the sales revenue for the 1st month of the Second Quarter: 100000
 *
 * Enter the sales revenue for the 2nd month of the Second Quarter: 50000
 *
 * Enter the sales revenue for the 3rd month of the Second Quarter: 100000
 *
 *
 * TANDEM ENTERPRISES
 * SALES REVENUE FOR 1 QUARTER(S) OF 2023
 * SALES REP:  Julian Caesar
 *
 * Total Year-To-Date:            $250,000.00
 *
 * Keep up the GOOD work, Julian. There is a possible year-end bonus!
 *
 * Enter the name of the next sales rep: Monique La Femme
 *
 * Enter the number of quarters worked (no less than 1 or greater than 4): 2
 * 1. First Quarter
 * 2. Second Quarter
 * 3. Third Quarter
 * 4. Fourth Quarter
 *
 * Choose the quarter in which sales were earned: 1
 *
 * Enter the sales revenue for the 1st month of the First Quarter: 25000
 *
 * Enter the sales revenue for the 2nd month of the First Quarter: 75000
 *
 * Enter the sales revenue for the 3rd month of the First Quarter: 25000
 * 1. First Quarter
 * 2. Second Quarter
 * 3. Third Quarter
 * 4. Fourth Quarter
 *
 * Choose the next quarter in which sales were earned: 2
 *
 * Enter the sales revenue for the 1st month of the Second Quarter: 10000
 *
 * Enter the sales revenue for the 2nd month of the Second Quarter: 25000
 *
 * Enter the sales revenue for the 3rd month of the Second Quarter: 30000
 *
 *
 * TANDEM ENTERPRISES
 * SALES REVENUE FOR 2 QUARTER(S) OF 2023
 * SALES REP:  Monique La Femme
 *
 * Total Year-To-Date:            $190,000.00
 *
 * Keep up the GOOD work, Monique. There is a possible year-end bonus!
 *
 * CORPORATE SALES PERFORMANCE
 *
 * It's been a GOOD year so far. There could be a year-end bonus of about 2-5% if we can keep on top of our sales goals. Thank you all and please continue your excellent effort!
 */