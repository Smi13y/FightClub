public class Character {
    private String name, tendency;
    private int atk, def, mAtk, mDef, hitPoints, tempHitPoints;

    public Character(String name, String tendency, int atk, int def, int mAtk, int mDef, int hitPoints) {
        this.name = name;
        this.tendency = tendency;
        this.atk = atk;
        this.def = def;
        this.mAtk = mAtk;
        this.mDef = mDef;
        this.hitPoints = hitPoints;
        this.tempHitPoints = hitPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTendency() {
        return tendency;
    }

    public void setTendency(String tendency) {
        this.tendency = tendency;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getmAtk() {
        return mAtk;
    }

    public void setmAtk(int mAtk) {
        this.mAtk = mAtk;
    }

    public int getmDef() {
        return mDef;
    }

    public void setmDef(int mDef) {
        this.mDef = mDef;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getTempHitPoints() {
        return tempHitPoints;
    }

    public void setTempHitPoints(int tempHitPoints) {
        this.tempHitPoints = tempHitPoints;
    }
}
