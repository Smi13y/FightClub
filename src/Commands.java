

public class Commands {
    private static int rollValue, attackDamage, blockDamage, totalDamage, rest;
    private static boolean isMagic;

    /*
    * A method to calculate damage dealt to defending character
     */
    public static int calculateDamage(Character player1, Character player2){
        if(isAttackMagic(player1)){
            totalDamage = attackMagic(player1) - defendMagic(player2);
        } else{
            totalDamage = attack(player1) - defend(player2);
        }

        if(totalDamage < 1){
            totalDamage = 0;
        }

        return totalDamage;
    }
    /*
    * Deal damage dealt from attacking player to defending player
     */
    public static void dealDamage(Character player1, Character player2){
        player2.setTempHitPoints(player2.getTempHitPoints() - calculateDamage(player1, player2));
        System.out.println(player1.getName() + " dealt " + totalDamage + " to " + player2.getName()+ " ");
        System.out.print(player2.getName() + " has "+ player2.getTempHitPoints() + " HP left.\n");
    }

    /*
    * Method to check if a player HP <= 0. If so, then they are knocked out
     */
    public static boolean checkKO(Character player) {
        return player.getTempHitPoints() <= 0;
    }

    /*
    * Method to determine attack damage
     */
    public static int attack(Character player){
        attackDamage = 0;
        for(int i = 1; i <= player.getAtk(); i++){
            rollValue = roll(6);
            if(rollValue >4 && rollValue < 7)
                attackDamage++;
        }

        return attackDamage;
    }

    /*
    * Method to determine damage blocked
     */
    public static int defend(Character player){
        blockDamage = 0;
        for(int i = 1; i <= player.getAtk(); i++){
            rollValue = roll(6);
            if(rollValue >4 && rollValue < 7)
                blockDamage++;
        }

        return blockDamage;
    }

    /*
    * Method to determine magic attack damage
     */
    public static int attackMagic(Character player){
        attackDamage = 0;
        for(int i = 1; i <= player.getmAtk(); i++){
            rollValue = roll(6);
            if(rollValue > 4 && rollValue < 7)
                attackDamage++;
        }

        return attackDamage;
    }

    /*
    * Method to determine blocked magic damage
     */
    public static int defendMagic(Character player){
        blockDamage = 0;
        for(int i = 1; i <= player.getmDef(); i++){
            rollValue = roll(6);
            if(rollValue >4 && rollValue < 7)
                blockDamage++;
        }

        return blockDamage;
    }

    /*
    * Method to roll a die of any size
     */
    public static int roll(int index){
        rollValue = (int) (Math.random()*index)+1;
        return rollValue;
    }

    /*
    * Method to determine if a character will be attacking with
    * a normal attack or a magic attack based on the character's
    * tendency.
     */
    public static boolean isAttackMagic(Character player){
        rollValue = roll(6);
        switch(player.getTendency()){
            case "Balance":
                isMagic = rollValue > 3;
            case "Magic":
                isMagic = rollValue > 2;
            case "Brawl":
                isMagic = rollValue > 4;
        }
        return isMagic;
    }

    public static void rest(Character player){
        rest = roll(15);
        player.setTempHitPoints(player.getTempHitPoints() + rest);
        System.out.println(player.getName()+ " rested and gained " + rest + "HP");
    }
}
