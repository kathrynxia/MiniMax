import java.io.*;
import java.util.*;

public class Tests{
    public static void main (String[] args){
        System.out.println("Testing my NimRunner class.");
        //System.out.println(NimRunner.minimax(6, true));//lost
        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(0,0,0, 1));

        SimpleNimRunner.runGame(6);//lost
        // System.out.println(NimRunner.minimax(4, false));//lost


       // NimRunner.runGame(5);//lost
        //System.out.println(NimRunner.bestMove(5, false));//lost


        //  System.out.println(NimRunner.bestMove(3, true));
        //  NimRunner.display(4, true);
        //System.out.println(NimRunner.minimax(1, true));


    }


}