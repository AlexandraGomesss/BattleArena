import org.academiadecodigo.simplegraphics.pictures.Picture;

class Hero extends Creature {
    public Hero(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void castSpell(Creature target) {
        System.out.println(this.name + " casts a healing spell on themselves!");
        this.health += 10;
        System.out.println(this.name + " heals 10 HP! New health: " + this.health);
    }
}