
import java.util.Random;

public class Villain extends Creature{

    private Random random = new Random();

    public Villain(String name, int health, int attackPower) {
        super(name,health, attackPower);
    }

    @Override
    public void takeTurn(Creature opponent) {
        // Randomly decide whether to attack or heal (50% chance each)
        if (random.nextBoolean()) {
            attack(opponent);
        } else {
            castSpell(this);
        }
    }

    @Override
    public void castSpell(Creature target) {
        System.out.println(this.name + " casts a healing spell on himself!");
        this.health += 10;
        System.out.println(this.name + " heals 10 HP! New health: " + this.health);
    }
}
