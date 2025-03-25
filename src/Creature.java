

abstract class Creature implements CreatureActions {
// class for all creatures ( heroes and villains)

     protected String name;
     protected int health;
     protected int attackPower;

     public Creature(String name, int health, int attackPower) {
         this.name = name;
         this.health = health;
         this.attackPower = attackPower;
     }
    @Override
     public void attack(Creature target) {
        System.out.println(name + " attacks " + target.name + " for " + attackPower + " damage!");
        target.takeDamage(attackPower);
    }

     @Override
     public void castHealingSpell(Creature target) {
         System.out.println("Casted healing spell on:" + target.name + " for " + attackPower + " 5 damage!");
         target.takeDamage(attackPower + 5);
     }

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
