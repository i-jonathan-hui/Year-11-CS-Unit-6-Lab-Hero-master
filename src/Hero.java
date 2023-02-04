import java.lang.Math;
public class Hero {
    private String name;
    private int hitPoints = 100;
    public Hero(String name) {
        this.name = name;
    }
    public String getName() { return name; }
    public int getHitPoints() { return hitPoints; }
    public String toString() { return "Hero{name='" + name + "', hitPoints=" + hitPoints + "}"; }
    public void attack(Hero opponent) {
        double randomNum = Math.random();
        if (randomNum < 0.5) opponent.hitPoints-=10;
        else if (randomNum >= 0.5) hitPoints-=10;
    }

    public void senzuBean() { hitPoints = 100; }

    public void fightUntilTheDeathHelper(Hero opponent) {
        while (hitPoints > 0 && opponent.hitPoints > 0) {
            attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent) {
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        System.out.println("HELLO: " + hitPoints);
        return name + ": " + hitPoints + " " + opponent.getName() + opponent.hitPoints;
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        int fightsWon = 0, fightsLoss = 0;
        for (int i=0; i<n; i++) {
            senzuBean();
            opponent.senzuBean();
            fightUntilTheDeath(opponent);
            if (hitPoints < opponent.getHitPoints()) fightsLoss++;
            else {
                fightsWon++;
            }
        }
        int[] returnArr = {fightsWon, fightsLoss};
        return returnArr;
    }
    public String nFightsToTheDeath(Hero opponent, int n) {
       int[] result = nFightsToTheDeathHelper(opponent, n);
       String returnValue = "";
       returnValue += name + ": " + result[0] + " wins\n";
       returnValue += opponent.name + ": " + result[1] + " wins\n";
       if (result[0] == result[1]) returnValue += "OMG! It was actually a draw!";
       else if (result[0] > result[1]) returnValue += name + " wins!";
       else { returnValue += opponent.name + " wins!"; }
       return returnValue;
    }

    public void dramaticFightToTheDeath(Hero opponent) {
        senzuBean();
        opponent.senzuBean();
        while (hitPoints > 0 || opponent.hitPoints > 0) {
            attack(opponent);
            System.out.println(name + ": " + hitPoints + "\t" + opponent.getName() + opponent.hitPoints);
        }
        if (hitPoints > opponent.getHitPoints()) System.out.println(name + " wins!");
        else { System.out.println(opponent.name + " wins!"); }
    }
}
