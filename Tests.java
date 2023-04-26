import java.io.*;
import java.util.*;

public class Tests{
    public static void main (String[] args){
        System.out.println("Testing my NimRunner class.");
  
        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
        ArrayList<Integer> test2 = new ArrayList<>(Arrays.asList(3, 5, 7));
        ArrayList<Integer> test3 = new ArrayList<>(Arrays.asList(2, 2, 2));
 
        
        System.out.println(RegNimRunner.minimax(test, true));//loses
        System.out.println(RegNimRunner.bestMove(test, true));

        NimRunnerV2.runGame(5);


        System.out.println(RegNimRunner.minimax(test2, true));//wins
        System.out.println(RegNimRunner.bestMove(test2, true));

        System.out.println(RegNimRunner.minimax(test3, true));//wins
        System.out.println(RegNimRunner.bestMove(test3, true));

        RegNimRunner.runGame();
        


    }


}