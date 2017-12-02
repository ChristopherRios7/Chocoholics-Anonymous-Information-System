/**
 * Created by christopherrios on 12/2/17.
 */

import java.util.Scanner;

/**
 * Parent class for all the prompt controllers.
 *
 */
public abstract class Prompter {

    private String promptPath = "\n";

    /**
     * Prompts the user with a message and returns the response from the message
     * @param promptString	the string to prompt the user to respond to
     * @return				the response from the message
     */
    public static String prompt(String promptString) {
        try {
            System.out.println(promptString);
            String response = ChocAnApplication.input.next();
            Thread.sleep(5);
            return response;
        } catch (Exception e){ }
        return null;
    }

    public static String prompt(String promptString, int length) {
        String output = "";
        while (output == ""){
            output = prompt(promptString);
            if (output.length() > length){
                System.out.println("The max number of characters is "+length);
                output = "";
            }
        }
        return output;

    }

    public static String prompt(String promptString, int minLength, int maxLength) {
        String output = "";
        while (output == ""){
            output = prompt(promptString);
            if ((output.length() != minLength) && (minLength == maxLength)){
                System.out.println("Must be "+minLength+" characters long");
                output = "";
            }
            else if (output.length() > maxLength){
                System.out.println("The max number of characters is "+maxLength);
                output = "";
            }
            else if (output.length() < minLength){
                System.out.println("The min number of characters is "+minLength);
                output = "";
            }
        }
        return output;

    }

    /**
     * Goes further down a level into the next path and prints the path
     * @param path	the name of the next level
     */
    public void goForward(String path){
        promptPath += "> "+path;
        System.out.println(promptPath);
    }

    /**
     * Goes back one level to the previous path
     */
    public void goBack(){
        promptPath = promptPath.substring(0, promptPath.lastIndexOf(">"));
        System.out.println(promptPath);
    }


    /**
     * Runs the logic for the prompter
     */
    public abstract void run();
}