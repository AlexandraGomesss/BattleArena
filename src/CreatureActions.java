public interface CreatureActions {

    //Actions that all creatures have

    public void attack(Creature target);

    public void castSpell(Creature target);

    public void takeDamage(int damage);


    public boolean isDead();

}
