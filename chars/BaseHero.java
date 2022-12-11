package chars;

import java.util.List;
import java.util.Random;

public abstract class BaseHero implements HeroInterface {

  protected String state;
  protected int attack;
  protected int protect;
  protected float health;
  protected float maxHealth = health;
  protected int speed;
  protected int[] damage;
  protected List<BaseHero> gang;
  protected List<BaseHero> enemies;
  protected Vector2 position;
  protected int count;

  public BaseHero(
    String state,
    int attack,
    int protect,
    float health,
    int speed,
    int[] damage
  ) {
    this.attack = attack;
    this.damage = damage;
    this.health = health;
    this.state = state;
    this.protect = protect;
    this.speed = speed;
   // count = new Random().nextInt(1, 21);
  }

  public Vector2 getPosition() {
    return position;
  }

  public String getState() {
    return state;
  }

  public void setState(String action) {
    this.state = action;
  }

  public float calcDamage(BaseHero enemy) {
    if (enemy.protect - this.attack == 0) {
      return ((this.damage[0] + this.damage[1]) / 2.0f) * count;
    }
    if (enemy.protect - this.attack < 0) {
      return this.damage[1] * count;
    }
    return this.damage[0] * count;
  }

  public void getHit(float damage) {
    health -= damage;
    double tmpHealth = (count - 1) * maxHealth + health;
    tmpHealth -= damage;
    if (tmpHealth <= 0) {
      health = 0;
      count = 0;
      state = "Dead";
    } else {
      count = (int) (tmpHealth / maxHealth);
      health = maxHealth;
      if (tmpHealth % maxHealth > 0) {
        count++;
        health = (float) (tmpHealth % maxHealth);
      }
    }
  }

  public int getSpeed() {
    return speed;
  }

  @Override
  public String getInfo() {
    return (
      "Attack: " +
      attack +
      " Protеct: " +
      protect +
      " Damage: " +
      (damage[0] + damage[1]) /
      2 +
      " Health: " +
      health +
      " Speed: " +
      speed +
      " Count: " +
      count
    );
  }

  @Override
  public void step() {
    // TODO Auto-generated method stub

  }

  public double getHealth() {
    return this.health;
  }

  public double getMHealth() {
    return this.maxHealth;
  }
}
