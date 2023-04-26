import java.io.*;
import java.util.*;

public class Tests {

  public static void main(String[] args) {
    System.out.println("Testing my NimRunner class.");

    ArrayList<Integer> test = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
    ArrayList<Integer> test2 = new ArrayList<>(Arrays.asList(3, 5, 7));
    ArrayList<Integer> test3 = new ArrayList<>(Arrays.asList(2, 2, 2));
    ArrayList<Integer> test4 = new ArrayList<>(Arrays.asList(0, 0, 0));
    ArrayList<Integer> test5 = new ArrayList<>(Arrays.asList(0, 0, 1));

    //test
    System.out.println(RegNimRunner.minimax(test, true)); //loses
    System.out.println(RegNimRunner.minimax(test, false)); //wins
    System.out.println(RegNimRunner.bestMove(test, true));
    System.out.println(RegNimRunner.bestMove(test, false));

    NimRunnerV2.runGame(5);

    //test 2
    System.out.println(RegNimRunner.minimax(test2, true)); //wins
    System.out.println(RegNimRunner.minimax(test2, false)); //loses
    System.out.println(RegNimRunner.bestMove(test2, true));
    System.out.println(RegNimRunner.bestMove(test2, false));

    //test 3
    System.out.println(RegNimRunner.minimax(test3, true)); //wins
    System.out.println(RegNimRunner.minimax(test3, false)); //loses
    System.out.println(RegNimRunner.bestMove(test3, true));
    System.out.println(RegNimRunner.bestMove(test3, false));

    RegNimRunner.runGame();

    //test 4
    System.out.println(RegNimRunner.minimax(test4, true)); //wins
    System.out.println(RegNimRunner.minimax(test4, false)); //loses

    //test 5
    System.out.println(RegNimRunner.minimax(test5, true)); //loses
    System.out.println(RegNimRunner.minimax(test5, false)); //wins
    System.out.println(RegNimRunner.bestMove(test5, true));
    System.out.println(RegNimRunner.bestMove(test5, false));


  }
}