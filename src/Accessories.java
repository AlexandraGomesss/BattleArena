class Accessories {

    private int increaseAttackPower;
    private String newAttackType;
    private int boostDefense;

    //Under construction
    public Accessories(String name, int attackBoost, int defenseBoost) {
        this.increaseAttackPower = increaseAttackPower;
        this.newAttackType = newAttackType;
        this.boostDefense = boostDefense;
    }

    public int getIncreaseAttackPower() {
        return increaseAttackPower;
    }

    public String getNewAttackType() {
        return newAttackType;
    }

    public int getBoostDefense() {
        return boostDefense;
    }

    public void increaseAttackPower() {
      System.out.println("Power increased!");
  }
  public void newAttackType() {
      System.out.println("New attack type added!");

  }
  public void boostDefense() {
      System.out.println("Boost defense!");
  }
}
