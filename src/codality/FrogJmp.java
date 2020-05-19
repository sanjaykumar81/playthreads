package codality;

public class FrogJmp {
    public static void main(String [] args){

        FrogJmp jump = new FrogJmp();
        System.out.println(jump.solution(10,70,25));

    }

    public int solution(int X, int Y, int D) {

        int distanceToCover = Y-X;

        int potentialJmp = distanceToCover/D;

        int remainingDistance = distanceToCover%D;

        int finalJumps = potentialJmp;
        if (remainingDistance!=0){
            finalJumps = potentialJmp +1;
        }

        return finalJumps;
    }
}
