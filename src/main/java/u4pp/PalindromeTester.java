package u4pp;
/**
* YOUR COMMENTS HERE
*/
import java.util.Scanner;

public class PalindromeTester {
    /**
     * YOUR JAVADOC HERE
     */
    public static void execute(Scanner sc) {
        /* YOUR CODE HERE */
        boolean again = true;

        //welcome

        System.out.println("Welcome to Palindrome Tester");
        while(again)
        {
            
            //ask user input
            System.out.print("Enter a phrase: ");
            String userPhrase = sc.nextLine();


            
            //report whether user input is Palindrome
            if(isPalindrome(userPhrase)){
                System.out.println(userPhrase + " is a palindrome");

            }
            else
            {
                System.out.println(userPhrase + " is not a palindrome");
            }

            //ask whether play again
        
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
                    System.out.print("Would you like to play again? (Y)es or (N)o: ");
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
     * YOUR JAVADOC HERE
     */

     //to test if palindrome
    public static boolean isPalindrome(String phrase) {
        /* YOUR CODE HERE */
        boolean check = true; 
        phrase = clear(phrase);
        phrase = phrase.toUpperCase();

        if(phrase.length() % 2 == 0)
        {
            for(int i = 0; i < phrase.length() / 2; i++)
            {
                if(!(phrase.substring(i, i+1)).equals(phrase.substring(phrase.length()- i -1, phrase.length()- i)))
                {
                    check = false;
                }
            }
        }
        else if(phrase.length() % 2 != 0)
        {
            for(int i = 0; i < phrase.length() - 1 / 2; i++)
            {
                if(!(phrase.substring(i, i+1)).equals(phrase.substring(phrase.length()- i -1, phrase.length()- i)))
                {
                    check = false;
                }
            }
        }
        System.out.print(check);
        return check;
    }

    /* Any helper methods you might need */

    //to clear all non letters
    public static String clear(String toClear)
    {
        String toReturn= "";
        for(int i = 0; i < toClear.length(); i++)
        {
            if(Character.isLetter(toClear.charAt(i)))
            {
                toReturn += toClear.charAt(i);

            }
        }
        return toReturn;

    }
}