package u4pp;

/**
* JAVADOC HERE
*/
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class RockPaperScissors {

    /* ANY CODE YOU NEED HERE */


    /**
     * JAVADOC HERE
     */
    public static void play(Scanner sc) {
        /* YOUR CODE HERE */
        System.out.println("Welcome to Rock Paper Scissors");
        boolean again = true;
        int wins = 0;
        int losses = 0;
        int ties = 0;

        while(again)
        {
            //results until now
    
            //get the user pick
            System.out.println("Would you like to pick (R)ock, (P)aper, (S)cissors, or (A)ny:");
            String userPick = sc.nextLine();
            userPick = userPick.toUpperCase();

            if (userPick.equals("A"))
            {
                userPick = randomPick();
            }
            else if (!(userPick.equals("R") || userPick.equals("P")|| userPick.equals("S")))
            {
                //not fone checking if random
                while(!(userPick.equals("R") || userPick.equals("P")|| userPick.equals("S")))
                {
                    System.out.println("Invalid input, please try again");
                    System.out.println("Would you like to pick (R)ock, (P)aper, (S)cissors, or (A)ny: ");
                    userPick = sc.nextLine();
                    userPick = userPick.toUpperCase();
                    
                    if (userPick.equals("A"))
                    {
                        userPick = randomPick();
                    }
                }
                
            }
            
            //generagte a computer pick
            String comPick = randomPick();
            
            //checkcking win or loss or tie
            int result  = results(userPick, comPick);

            //feedback
            if(result == 0)
            {
                ties++;
                System.out.println("You both picked " + convert(comPick) + ". Its a tie!");
            }
            else if(result == 1)
            {
                wins++;
                System.out.println("You picked " + convert(userPick) + ", and the Computer picked " + convert(comPick) +  ". You win!");

            }
            else{
                losses++;
                System.out.println("You picked " + convert(userPick) + ", and the Computer picked " + convert(comPick) +  ". You lose!");
            }

            //report wins losses ties
            System.out.println("You have " + wins + " wins and " + losses + " losses and " + ties + " ties");

            //ask if wand to play again
            System.out.print("Would you like to play again? (Y)es or (N)o: ");
            String userInput = sc.nextLine();
            userInput = userInput.toUpperCase();

            if(userInput.equals("N"))
            {
                again = false;
                

            }
            else if(userInput.equals("Y"))
            {
                again = true;
            }
            else
            {
                while(!(userInput.equals("Y")|| userInput.equals("N")))
                {
                    System.out.println("Invalid input, please try again");
                    System.out.println("Would you like to play again? (Y)es or (N)o: ");
                    userInput = sc.nextLine();
                    userInput = userInput.toUpperCase();
                    if(userInput.equals("N"))
                    {
                        again = false;
                

                    }
                    else if(userInput.equals("Y"))
                        {
                        again = true;
                        }
                }
            }
        }
    }

    /**
     * JAVADOC HERE
     */
    public static int results(String playerChoice, String computerChoice) {
        /* YOUR CODE HERE */
        //when players ties
        if(playerChoice.equals(computerChoice))
        {
            return 0;
        }
        //when the players wins
        else if((playerChoice.equals("R") && computerChoice.equals("S")) || (playerChoice.equals("S") && computerChoice.equals("P")) || (playerChoice.equals("P") && computerChoice.equals("R")))
        {
            return 1;
        }
        else
        {
            return -1;
        }


    }

    /* any helper methods you might need */

    //random pick RPS
    public static String randomPick(){
        String toReturn;
        int randomNum = (int) (Math.random() * 3 + 1);
        if(randomNum == 1)
        {
            toReturn = "R";
            return toReturn;
        }
        else if(randomNum == 2)
        {
            toReturn = "P";
            return toReturn;
        }
        else
        {
            toReturn = "S";
            return toReturn;
        }
        
    }
    //convert to word
    public static String convert(String toConvert)
    {
        String toReturn;
        if(toConvert.equals("R"))
        {
            toReturn = "Rock";
            return toReturn;
        }
        else if(toConvert.equals("P"))
        {
            toReturn = "Paper";
            return toReturn;
        }
        else
        {
            toReturn = "Scissors";
            return toReturn;
        }
    }

}