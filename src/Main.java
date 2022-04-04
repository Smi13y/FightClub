public class Main {
    public static void main(String[] args){
        Character ryu = new Character("Ryu", "Balance", 3, 3, 3, 3, 50);
        Character ken = new Character("Ken", "Balance", 3, 3, 3, 3, 50);

        Battle.fight(ryu,ken, 180);
    }
}
