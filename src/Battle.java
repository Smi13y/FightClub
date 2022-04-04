public class Battle {
    private boolean fightOver;
    private static int roundTimer, minutes, seconds, roundMax;
    private String timerOutput;
    private static final int ROUND = 1;


    public static void fight(Character player1, Character player2, int roundMax){
        player1.setTempHitPoints(player1.getHitPoints());
        player2.setTempHitPoints(player2.getHitPoints());
        int r = ROUND;
        while(!isFightOver(player1, player2)){
            roundTimer = 0;
            System.out.println("================");
            System.out.println("Round " + r + " FIGHT!");
            System.out.println("================");
            while(roundTimer < roundMax && !isFightOver(player1, player2)){
                roundTimer = roundTimer + Commands.roll(10);
                round(player1, player2);
                timerPrint(roundTimer, roundMax);
            }
            System.out.println("================");
            System.out.println("Round " + r + " OVER!");
            System.out.println("================");
            r++;
        }
            declareWinner(player1, player2);
    }
    public static void round(Character player1, Character player2){
        Commands.dealDamage(player1, player2);
        Commands.dealDamage(player2, player1);

    }

    public static void timerPrint(int roundTimer, int roundMax){
        minutes = roundTimer / 60;
        seconds = roundTimer % 60;

        if(roundTimer >= roundMax){
            System.out.println("====="+minutes+":"+ "00"+"=====");
        }else if(seconds < 10){
            System.out.println("====="+minutes+":"+ "0" + seconds + "=====");
        } else{
            System.out.println("====="+minutes+":"+seconds + "=====");
        }
    }

    public static boolean isFightOver(Character player1, Character player2){
        if(Commands.checkKO(player1) || Commands.checkKO(player2) || isDraw(player1, player2)){
            return true;
        }
        return false;
    }
    /*
    * This method determines whether or not the fight is over by KnockOut
    * This method might be useless
     */
    public static void declareWinner(Character player1, Character player2){
        if(Commands.checkKO(player1) && !Commands.checkKO(player2)){
            System.out.println(player2.getName() + " wins by KO!");
        }else if(!Commands.checkKO(player1) && Commands.checkKO(player2)){
            System.out.println(player1.getName() + " wins by KO!");
        }else if(isDraw(player1, player2)){
            System.out.println("It's a draw!");
        }
    }
    public static boolean isDraw(Character player1, Character player2){

        if(Commands.checkKO(player1) && Commands.checkKO(player2)){
            return true;
        } else{
            return false;
        }

    }

}
