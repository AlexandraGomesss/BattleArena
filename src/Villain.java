import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Villain extends Creature{

    public Villain(String name, int health, int attackPower) {
        super(name,health, attackPower);
    }

    @Override
    public void castSpell(Creature target) {
        System.out.println(this.name + " casts a healing spell on themselves!");
        this.health += 10;
        System.out.println(this.name + " heals 10 HP! New health: " + this.health);
    }

}
