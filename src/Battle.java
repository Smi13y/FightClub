

public class Battle {
    int rollValue, attackDamage, blockDamage, totalDamage;
    boolean isMagic;

    public void fight(Character player1, Character player2){
        if(isAttackMagic(player1)){
            totalDamage = attackMagic(player1) - defendMagic(player2);
        } else{
            totalDamage = attack(player1) - defend(player2);
        }

        if(totalDamage > 0){
            player2.setTempHitPoints(player2.getTempHitPoints() - totalDamage);
        }

    }
    public int attack(Character player){
        attackDamage = 0;
        for(int i = 1; i <= player.getAtk(); i++){
            rollValue = roll(6);
            if(rollValue >4 && rollValue < 7)
                attackDamage++;
        }

        return attackDamage;
    }

    public int defend(Character player){
        blockDamage = 0;
        for(int i = 1; i <= player.getAtk(); i++){
            rollValue = roll(6);
            if(rollValue >4 && rollValue < 7)
                blockDamage++;
        }

        return blockDamage;
    }

    public int attackMagic(Character player){
        attackDamage = 0;
        for(int i = 1; i <= player.getmAtk(); i++){
            rollValue = roll(6);
            if(rollValue > 4 && rollValue < 7)
                attackDamage++;
        }

        return attackDamage;
    }

    public int defendMagic(Character player){
        blockDamage = 0;
        for(int i = 1; i <= player.getmDef(); i++){
            rollValue = roll(6);
            if(rollValue >4 && rollValue < 7)
                blockDamage++;
        }

        return blockDamage;
    }

    public int roll(int index){
        rollValue = (int) (Math.random()*index)+1;
        return rollValue;
    }

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
                } else{
                    isMagic = false;
                }
            default:
                isMagic = false;
        }

        return isMagic;
    }
}
