/*Matthew Coculuzzi, Camille Gener, Tobin Tojo
//  The main purpose of this project is an interface for users to research the total number, median and average of the age group per sex or both genders based on a few cities’ wards. The user can fast search it using a search bar, breakdown the information, or open the website to the original data sheet
//  Matthew - Did most the of main method, completed Total population, completed Webpage mode and assisted in creating algorithim
//  Camille - Did file reading and assingning values ot 2D array, completed female method, worked on fast mode and assisted in creating algorithim
//  Tobin - Led in the creaing the algorithim, worked on main method, worked on fast mode and completed male method
*/

package CPT;

import java.io.*;
import java.util.Scanner;
import java.io.IOException;

public class DemographicsAnalyzer {

    static Scanner input = new Scanner (System.in);

    /**
     * A method to take the correct element from passed array and display data about the female population accordingly
     * pre: passed array is not empty
     * @param array row from specified demographics row determined by selected city ward
     * post: displays specified data to the console
     */

    public static void femalePopulation(int[] array) //Camille's method
    {
        //Prompting the user
        System.out.println("\nWhat category would you like to look at? \n 1. Total Female population \n 2. "
                + "Age by division \n 3. Average age of females \n 4. Median Age of females");
        int userAnswer = input.nextInt();
        System.out.println();

        if (userAnswer == 1)    //total female population
        {
            System.out.println(array[25] + " people");
        }
        else if (userAnswer == 2)   //age division
        {
            System.out.println("Which age division would you like to look at? \n 1. 0 to 4 \n 2. 5 to 9 \n "
                    + "3. 10 to 14 \n 4. 15 to 19 \n 5. 20 to 24 \n 6. 25 to 29 \n 7. 30 to 34 \n 8. 35 to 39 \n "
                    + "9. 40 to 44 \n 10. 45 to 49 \n 11. 50 to 54 \n 12. 55 to 59 \n 13. 60 to 64 \n 14. 65 to 69 \n "
                    + "15. 70 to 74 \n 16. 75 to 79 \n 17. 80 to 84 \n 18. 85 to 89 \n 19. 90 to 94 \n 20. 95 to 99 \n "
                    + "21. 100 and over");

            userAnswer = input.nextInt();
            System.out.print(array[25 + userAnswer -1] + " people");
        }
        else if(userAnswer == 3)    //average female age
        {
            System.out.println(array[51] + " is the average female age");
        }
        else if (userAnswer == 4)   //median female age
        {
            System.out.println(array[52] + " is the median female age");
        }
        else //Covering invalid options
        {
            System.out.println("Invalid input.");
        }
        System.out.println();
    }
    /**
     * A method to take the correct element from passed array and display data about the male population accordingly
     * pre: passed array is not empty
     * @param array row from specified demographics row determined by selected city ward
     * post: displays specified data to the console
     */
    public static void malePopulation (int[] array) { //Tobin's method
        //Prompting the user
        System.out.println("\nWhat category would you like to look at? \n 1. Total male population \n 2. Age by division "
                + "\n 3. Average age \n 4. Median Age\n");
        int userAnswer = input.nextInt();
        System.out.println();
        if (userAnswer == 1) {
            System.out.println(array[1] + " people"); //Outputs the population of males in the ward if the user chooses option 1
        }
        else if (userAnswer == 2) {
            System.out.println("Which age division would you like to look at? \n 1. 0 to 4 \n 2. 5 to 9 \n "
                    + "3. 10 to 14 \n 4. 15 to 19 \n 5. 20 to 24 \n 6. 25 to 29 \n 7. 30 to 34 \n 8. 35 to 39 \n "
                    + "9. 40 to 44 \n 10. 45 to 49 \n 11. 50 to 54 \n 12. 55 to 59 \n 13. 60 to 64 \n 14. 65 to 69 \n "
                    + "15. 70 to 74 \n 16. 75 to 79 \n 17. 80 to 84 \n 18. 85 to 89 \n 19. 90 to 94 \n 20. 95 to 99 \n "
                    + "21. 100 and over");

            userAnswer = input.nextInt();
            System.out.println(array[2 + userAnswer - 1] + " people"); //If option 2 is picked from the first prompt in the method, the system outputs the population of the male age group picked by the user
        }
        else if (userAnswer == 3) {
            System.out.println(array[49] + " is the average male age"); // Outputs the average male age if the user chooses option 3
        }
        else if (userAnswer == 4) {
            System.out.println(array[50] + " is the median male age"); // Outputs the median male age if the user chooses option 4
        }
        else //Covering invalid options
        {
            System.out.println("Invalid input.");
        }
        System.out.println();
    }

    /**
     * A method to take the correct element from passed array and display data about the total population accordingly
     * pre: passed array is not empty
     * @param array row from specified demographics row determined by selected city ward
     * post: displays specified data to the console
     */
    public static void totalPopulation(int[] array) //Matthew's method
    {
        //Prompting the user
        System.out.println("\nWhat category would you like to look at? \n 1. Total age groups of the population \n "
                + "2. Average age \n 3. Median Age");

        int userAnswer = input.nextInt();

        if(userAnswer == 1) //Total age groups of the population
        {
            System.out.println(array[0] + " people");
        }
        else if(userAnswer ==2) //Average age
        {
            System.out.println(array[47] + " is the average age");
        }
        else if(userAnswer ==3) //Median Age
        {
            System.out.println(array[48] + " is the median age");
        }
        else //Covering invalid options
        {
            System.out.println("Invalid input.");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        File inFile = new File ("Demographics.txt");
        FileReader in;
        BufferedReader readFile;
        String [][] demographics = new String [26][55];    //array for the whole file

        try
        {
            //open file for reading
            in = new FileReader(inFile);
            readFile = new BufferedReader(in);

            int character;
            int numCount = 0;  //number of digits in a number
            int rowCount = 0;  //number of rows in file
            int colCount = 2;  //number of columns
            String tempLine = "";  //stores number in string before storing in array

            while ((character = readFile.read()) != -1)       //reads file character by character
            {
                //if the reader approaches a new line
                if (character == 10)
                {
                    //stores last element in a line
                    if (!(tempLine.isBlank()))
                    {
                        demographics[rowCount][colCount] = tempLine;
                    }

                    colCount = 2;
                    rowCount++;
                    numCount = 0;

                    //resetting to empty string
                    tempLine = "";
                }

                //if the reader approaches a number
                else if (character >= 48 && character <=57)
                {
                    //storing the characters in the temporary string (tempLine)
                    tempLine += String.valueOf((char)character);
                    numCount++;
                }

                //if the reader approaches a comma
                else if (character == 44)
                {
                    //a ward number gets ignored
                    if ((numCount == 2 || numCount == 1) && colCount == 2 )
                    {
                        tempLine = "";
                        numCount = 0;
                    }

                    //reading a population number
                    else if (numCount > 0 && numCount != 1 && colCount >= 2 && !(tempLine.isBlank())
                            || tempLine.equals("0") && colCount >= 2)
                    {
                        demographics[rowCount][colCount] = tempLine;   //store element to demographics
                        numCount = 0;  //resets for new number
                        colCount++;
                    }
                    tempLine = "";
                }
            }

            //reading then storing the very last number in the file
            if (!(tempLine.isBlank()))
            {
                demographics[rowCount][colCount] = tempLine;
            }

            //close input file
            in.close();
            readFile.close();

        }
        catch (IOException e)
        {
            System.out.println("Problem writing to file.");
            System.err.println("IOException: " + e.getMessage());
        }

        boolean run = false;
        //Creating the do while loop
        do {
            System.out.println("\nWelcome to the Region of Peel Demographics Analyzer!");
            System.out.println("This program will provide you with the following information on a city ward: "
                    + "\nTotal population \n" +
                    "Total population median age\n" +
                    "Total population average age\n" +
                    "Total male population \n" +
                    "Male population by age group\n" +
                    "Male population average age\n" +
                    "Male population median age \n" +
                    "Total female population \n" +
                    "Female population by age group\n" +
                    "Female population average age\n" +
                    "Female population median age\n");
            System.out.println();

            System.out.println("This analyzer provides information on Brampton, Caledon, and Mississauga.\n"
                    + "Would you like to use fast search mode or breakdown mode? \n 'f' for fast mode, 'b' for breakdown mode"
                    + " 'w' for opening Region of Peel's AgeSex Statistics Webpage");
            String userInput = input.next();

            if (userInput.equalsIgnoreCase("f")) //Tobin's idea to implement the fast search
            {
                System.out.println("Enter the city followed by ward number followed by statistic. \nSeparate each word by comma."
                        + "\nFor instance, 'Brampton,1,TotalPopulation");
                System.out.println("\nFor writing statistics, these are the options and you must type them accordingly: "
                        + "\ntotalpopulation \n" +
                        "populationmedianage\n" +
                        "populationaverageage\n" +
                        "totalmalepopulation \n" +
                        "maleaverageage\n" +
                        "malemedianage \n" +
                        "totalfemalepopulation \n" +
                        "femaleaverageage\n" +
                        "femalemedianage\n");
                userInput = input.next();
                String[] search = userInput.split(",");
                String fastCity = search[0];    //the city is the first element in the fast search
                int fastWard = Integer.parseInt(search[1]); //the ward number is the second element in the fast search
                String fastStatistic = search[2];   //the specified statistic is the third element in the fast search
                int StatisticIndex = 0;     //the column corressponding to the specified statistic

                //assigning the column number to the specifed data
                if (fastStatistic.equalsIgnoreCase("TotalPopulation")) {
                    StatisticIndex = 2;
                }
                else if (fastStatistic.equalsIgnoreCase("TotalMalePopulation")) {
                    StatisticIndex = 3;
                }
                else if (fastStatistic.equalsIgnoreCase("TotalFemalePopulation")) {
                    StatisticIndex = 26;
                }
                else if (fastStatistic.equalsIgnoreCase("PopulationAverageAge")) {
                    StatisticIndex = 49;
                }
                else if (fastStatistic.equalsIgnoreCase("PopulationMedianAge")) {
                    StatisticIndex = 50;
                }
                else if (fastStatistic.equalsIgnoreCase("MaleAverageAge")) {
                    StatisticIndex = 51;
                }
                else if (fastStatistic.equalsIgnoreCase("MaleMedianAge")) {
                    StatisticIndex = 52;
                }
                else if (fastStatistic.equalsIgnoreCase("FemaleAverageAge")) {
                    StatisticIndex = 53;
                }
                else if (fastStatistic.equalsIgnoreCase("FemaleMedianAge")) {
                    StatisticIndex = 54;
                }

                //caledon's data is under brampton's data in the file
                if (fastCity.equalsIgnoreCase("Caledon"))
                {
                    fastWard = fastWard + 10;
                }
                //mississauga's data is under brampton and caledon's data in the file
                else if (fastCity.equalsIgnoreCase("Mississauga"))
                {
                    fastWard = fastWard + 15;
                }

                //if it is a statistic pertaining to age
                if (StatisticIndex >= 49 && StatisticIndex <= 54)
                {
                    System.out.println(Integer.parseInt(demographics[fastWard - 1][StatisticIndex]) + " years");
                }
                //if it is a statistic pertaining to a number of people
                else {
                    System.out.println(Integer.parseInt(demographics[fastWard - 1][StatisticIndex]) + " people");
                }

                input.nextLine();

                //prompting the user to run the program again
                System.out.print("\nDo you want to run the analyzer again?" + "\nType in \"y\" or \"yes\" to continue \n");
                String newUserCity = input.nextLine();

                if (newUserCity.equalsIgnoreCase("y") || newUserCity.equalsIgnoreCase("yes")) {
                    run = true;
                } else {
                    run = false;
                    System.out.println("Program shutdown. Thank you for using the Region of Peel's Demographics Statistics Analyzer!");
                }
            }
            else if (userInput.equalsIgnoreCase("b")) {
                System.out.println("Enter Brampton or B, Caledon or C, or Mississauga or M");
                System.out.println("Your Choice is: ");
                String userCity = input.next();
                System.out.println();

                int brampton = 10;  //caledon's data is under brampton's data in the file
                int caledon = 15;   //mississauga's data is under caledon's data in the file

                //If user chooses Brampton for the city then this code will run
                if (userCity.equalsIgnoreCase("Brampton") || userCity.equalsIgnoreCase("B")) {
                    System.out.println("What ward would you like to look at?");
                    System.out.println("You can choose from 1-10");
                    int userInt = input.nextInt();
                    if (userInt >= 1 && userInt <= 10) {
                        int[] arrayWard = new int[55];
                        for (int i = 2; i < arrayWard.length; i++) {

                            //populates one array with data chosen by user
                            arrayWard[i - 2] = Integer.parseInt(demographics[userInt - 1][i]);
                        }
                        System.out.println();
                        System.out.println("Would you like to view the total, male, or female population?");
                        System.out.println("Input 1 for total, 2 for males and 3 for females: ");
                        userInt = input.nextInt();

                        if (userInt == 1) {
                            totalPopulation(arrayWard); //runs the totalPopulation method
                        }
                        else if (userInt == 2)
                        {
                            malePopulation(arrayWard); //runs the malePopulation method
                        }
                        else if (userInt == 3)
                        {
                            femalePopulation(arrayWard); //runs the femalePopulation method
                        }

                        else //Covering invalid options
                        {
                            System.out.println("Invalid choice.");
                            continue;
                        }

                    }

                    else //Covering invalid options
                    {
                        System.out.println("Invalid choice.");
                        continue;
                    }
                }
                //If user chooses Caledon for the city then this code will run
                else if (userCity.equalsIgnoreCase("Caledon") || userCity.equalsIgnoreCase("C")) {
                    System.out.println("What ward would you like to look at?");
                    System.out.println("You can choose from 1-5");

                    int userInt = input.nextInt();
                    if (userInt > 0 && userInt <= 5) {
                        int[] arrayWard = new int[55];
                        for (int i = 2; i < arrayWard.length; i++) {
                            //populates one array with data chosen by user
                            arrayWard[i - 2] = Integer.parseInt(demographics[brampton + userInt - 1][i]);
                        }
                        System.out.println();
                        System.out.println("Would you like to view the total, male, or female population?");
                        System.out.println("Input 1 for total, 2 for males and 3 for females: ");
                        userInt = input.nextInt();

                        if (userInt == 1) {
                            totalPopulation(arrayWard); //runs the totalPopulation method
                        } else if (userInt == 2) {
                            malePopulation(arrayWard); //runs the malePopulation method
                        } else if (userInt == 3) {
                            femalePopulation(arrayWard); //runs the femalePopulation method
                        }
                        else //Covering invalid options
                        {
                            System.out.println("Invalid choice.");
                            continue;
                        }
                    }

                    else //Covering invalid options
                    {
                        System.out.println("Invalid choice.");
                        continue;
                    }

                    //If user chooses Mississauga for the city then this code will run
                } else if (userCity.equalsIgnoreCase("Mississauga") || userCity.equalsIgnoreCase("M")) {
                    System.out.println("What ward would you like to look at?");
                    System.out.println("You can choose from 1-11");
                    int userInt = input.nextInt();
                    if (userInt > 0 && userInt <= 11) {
                        int[] arrayWard = new int[55];
                        for (int i = 2; i < arrayWard.length; i++) {
                            //populates one array with data chosen by user
                            arrayWard[i - 2] = Integer.parseInt(demographics[caledon + userInt - 1][i]);
                        }
                        System.out.println();
                        System.out.println("Would you like to view the total, male, or female population?");
                        System.out.println("Input 1 for total, 2 for males and 3 for females: ");
                        userInt = input.nextInt();

                        if (userInt == 1) {
                            totalPopulation(arrayWard); //runs the totalPopulation method
                        } else if (userInt == 2) {
                            malePopulation(arrayWard); //runs the malePopulation method
                        } else if (userInt == 3) {
                            femalePopulation(arrayWard); //runs the femalePopulation method
                        }
                        else //Covering invalid options
                        {
                            System.out.println("Invalid choice.");
                            continue;
                        }
                    }
                    else //Covering invalid options
                    {
                        System.out.println("Invalid choice.");
                        continue;
                    }
                }


                input.nextLine();

                //Asking user if they want to run the analyzer again
                System.out.print("\nDo you want to run the analyzer again?" + "\nType in \"y\" or \"yes\" to continue \n");
                String newUserCity = input.nextLine();

                if (newUserCity.equalsIgnoreCase("y") || newUserCity.equalsIgnoreCase("yes")) {
                    run = true; //runs the analyzer again
                } else {
                    run = false; //shut down the program
                    System.out.println("Program shutdown. Thank you for using the Region of Peel's Demographics Statistics Analyzer!");
                }

            }

            else if (userInput.equalsIgnoreCase("w")) //Matthews idea to implement a code that will go directly to the website
            {
                final String targetUrl = "https://data.peelregion.ca/datasets/census2016-wards20182022-agesex/data";
                System.out.println("Opening the website...");
                System.out.println();
                java.awt.Desktop.getDesktop().browse(java.net.URI.create(targetUrl)); //This was used from stackoverflow.com by Trevor Tippins
            }
        } while (run == true);
    }
}
