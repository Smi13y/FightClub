

public class Battle {
    int rollValue, attackDamage, blockDamage, totalDamage;
    boolean isMagic;

    /*
    * A method to calculate damage dealt to defending character
     */
    public int calculateDamage(Character player1, Character player2){
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
    public void dealDamage(Character player1, Character player2){
        player2.setTempHitPoints(player2.getTempHitPoints() - calculateDamage(player1, player2));
    }

    /*
    * Method to determine attack damage
     */
    public int attack(Character player){
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
    public int defend(Character player){
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
    public int attackMagic(Character player){
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
    public int defendMagic(Character player){
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
    public int roll(int index){
        rollValue = (int) (Math.random()*index)+1;
        return rollValue;
    }

    /*
    * Method to determine if a character will be attacking with
    * a normal attack or a magic attack based on the character's
    * tendency.
     */
    public boolean isAttackMagic(Character player){
        rollValue = roll(6);
        switch(player.getTendency()){
            case "Balance":
                if(rollValue > 3){
                    isMagic = true;
                } else{
                    isMagic = false;
                }
            case "Magic":
                if(rollValue > 2){
                    isMagic = true;
                } else{
                    isMagic = false;
                }
            case "Brawl":
                if(rollValue > 4){
                    isMagic = true;
                } else {
                    isMagic = false;
                }
        }

        return isMagic;
    }
}
