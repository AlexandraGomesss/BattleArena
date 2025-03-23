public interface CreatureActions {

    public void attack(Creature target);


    public void castSpell(Creature target);


    public void takeDamage(int damage);


    public boolean isDead();

}
