package facade.facade1.basic;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

class Weapon {
    private int baseDamage;
    private Random random;

    public Weapon(int baseDamage) {
        this.baseDamage = baseDamage;
        this.random = new Random();
    }

    public int attackDamage() {
        return baseDamage + random.nextInt(baseDamage / 2);
    }

    public int getBaseDamage() {
        return baseDamage;
    }
}

class Armor {
    private int defense;

    public Armor(int defense) {
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }
}

class Player {
    private int life;
    private Armor armor;
    private Weapon weapon;

    public Player(int life, Armor armor, Weapon weapon) {
        this.life = life;
        this.armor = armor;
        this.weapon = weapon;
    }

    public int getLife() {
        return life;
    }

    public void takeDamage(int damage) {
        int damageTaken = Math.max(damage - armor.getDefense(), 0);
        life -= damageTaken;
        System.out.println("Player takes " + damageTaken + " damage, life is now " + life);
    }

    public int attack() {
        int damage = weapon.attackDamage();
        System.out.println("Player attacks with damage " + damage);
        return damage;
    }

    public boolean isAlive() {
        return life > 0;
    }
}

class Enemy {
    private int life;
    private int magicDamage;
    private Random random;

    public Enemy(int life, int magicDamage) {
        this.life = life;
        this.magicDamage = magicDamage;
        this.random = new Random();
    }

    public int getLife() {
        return life;
    }

    public void takeDamage(int damage) {
        life -= damage;
        System.out.println("Enemy takes " + damage + " damage, life is now " + life);
    }

    public int attack() {
        int damage = magicDamage + random.nextInt(magicDamage / 2); // Daño mágico aleatorio
        System.out.println("Enemy attacks with magic damage " + damage);
        return damage;
    }

    public boolean isAlive() {
        return life > 0;
    }
}

class BattleStatistics {
    private int totalPlayerDamage;
    private int totalEnemyDamage;

    public BattleStatistics() {
        this.totalPlayerDamage = 0;
        this.totalEnemyDamage = 0;
    }

    public void recordPlayerDamage(int damage) {
        totalPlayerDamage += damage;
    }

    public void recordEnemyDamage(int damage) {
        totalEnemyDamage += damage;
    }

    public void printStatistics() {
        System.out.println("Total Player Damage Dealt: " + totalPlayerDamage);
        System.out.println("Total Enemy Damage Dealt: " + totalEnemyDamage);
    }
}

class BattleLog {
    private List<String> log;

    public BattleLog() {
        log = new ArrayList<>();
    }

    public void addEntry(String entry) {
        log.add(entry);
    }

    public void printLog() {
        System.out.println("Battle Log:");
        for (String entry : log) {
            System.out.println(entry);
        }
    }
}

//I want to simplify the interface in order to create fights