import java.util.*;

public class NimRunnerV2{

    public static runGame(int numPieces){

    boolean myTurn = true;
        while (numPieces > 0){

        }
    }



    public static int minimax(int numPieces, boolean myTurn){

        if (state == 0){
            if (myTurn){
                return 1; 
            }
            else{
                return -1; 
            }
        }
        else{
            ArrayList <Integer> listOfScores = new ArrayList <> ();

            for (int i = 1; i <=3; i++){

                if ((numPieces - i) < 0){
                    continue;
                }

                 listOfScores.add(minimax(numPieces - i, !myTurn));
            }

            if(myTurn){
                return Collections.max(listOfScores);
            }
            else { 
                return Collections.min(listOfScores);
            }
        }

    }



    public static int bestMove(int numPieces, boolean myTurn){
        for(int i = 1; i <= 3; i++){ 
            if ((numPieces - i) < 0){
                continue;
            }

            if (myTurn){
                if (minimax(numPieces - i, !myTurn) == 1){ 
                    return i; 
                }
            }
            else {
                if (minimax(state - i, myTurn) == 1){
                    return i;
                }
            }
        }
        return 1;
    }
}