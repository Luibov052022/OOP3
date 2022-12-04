package chars;

import java.util.List;

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
      return (this.damage[0] + this.damage[1]) / 2.0f;
    }
    if (enemy.protect - this.attack < 0) {
      return this.damage[1];
    }
    return this.damage[0];
  }

  public void getHit(float damage) {
    health -= damage;
    if (health <= 0) {
      health = 0;
      state = "Dead";
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
      speed
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
