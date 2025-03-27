// The Class for all creatures ( heroes/player 1 and villains/player 2)

abstract class Creature implements CreatureActions {


     protected String name;
     protected int health;
     protected int attackPower;

     public Creature(String name, int health, int attackPower) {
         this.name = name;
         this.health = health;
         this.attackPower = attackPower;
     }

     //Method for the opponent to take damage from the attack
    @Override
     public void attack(Creature target) {
        System.out.println(name + " attacks " + target.name + " for " + attackPower + " damage!");
        target.takeDamage(attackPower);
    }


    //Method to calculate the damage taken. Resulting Health is equal to the current health - damage taken.
    //Verifies if the target energy is 0 or less (dead)
    @Override
    public void takeDamage(int damage) {
        System.out.println(name + " takes " + damage + " damage!");
        health -= damage;
        System.out.println(name + "'s current health: " + health);

        if (isDead()) {
            System.out.println(name + " is dead!");
        }
    }

    @Override
    public boolean isDead() {
     return health <= 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public abstract void takeTurn(Creature opponent);

    public abstract void castSpell(Creature target);
}
