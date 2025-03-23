

abstract class Creature implements CreatureActions {
// class for all creatures ( heroes and villains)

    private String name;
     private int health;
     private int attackPower;

     public Creature(String name, int health, int attackPower) {
         this.name = name;
         this.health = health;
         this.attackPower = attackPower;
     }
    @Override
     public void attack(Creature target){
        System.out.println("Attacked:" + target.name);
    }

     @Override
     public void castSpell(Creature target) {
         System.out.println("Casted spell on:" + target.name);
     }

     @Override
     public void takeDamage(int damage) {
         System.out.println("Taking damage:" + damage);
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
 }
