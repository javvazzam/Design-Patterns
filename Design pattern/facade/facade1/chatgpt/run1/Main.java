package facade.facade1.chatgpt.run1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Weapon class
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

// Armor class
class Armor {
    private int defense;

    public Armor(int defense) {
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }
}

// Player class
class Player implements Character {
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

// Enemy class
class Enemy implements Character {
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
        int damage = magicDamage + random.nextInt(magicDamage / 2);
        System.out.println("Enemy attacks with magic damage " + damage);
        return damage;
    }

    public boolean isAlive() {
        return life > 0;
    }
}

// BattleStatistics class
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

// BattleLog class
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

// Battle class
class Battle {
    private Player player;
    private Enemy enemy;
    private BattleStatistics statistics;
    private BattleLog log;

    public Battle(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        this.statistics = new BattleStatistics();
        this.log = new BattleLog();
    }

    public void start() {
        while (player.isAlive() && enemy.isAlive()) {
            // Player attacks enemy
            performAttack(player, enemy);
            
            // Check if enemy is defeated
            if (!enemy.isAlive()) {
                log.addEntry("Enemy defeated!");
                break;
            }
            
            // Enemy attacks player
            performAttack(enemy, player);
            
            // Check if player is defeated
            if (!player.isAlive()) {
                log.addEntry("Player defeated!");
                break;
            }
        }

        // Print final statistics and log
        statistics.printStatistics();
        log.printLog();
    }

    private void performAttack(Character attacker, Character defender) {
        int damage = attacker.attack();
        defender.takeDamage(damage);
        if (attacker instanceof Player) {
            statistics.recordPlayerDamage(damage);
            log.addEntry("Player dealt " + damage + " damage to Enemy");
        } else {
            statistics.recordEnemyDamage(damage);
            log.addEntry("Enemy dealt " + damage + " damage to Player");
        }
    }
}

// Character interface
interface Character {
    int attack();
    void takeDamage(int damage);
    boolean isAlive();
}

// Main class to run the battle
public class Main {
    public static void main(String[] args) {
        // Create a player with life, armor, and weapon
        Weapon playerWeapon = new Weapon(20);
        Armor playerArmor = new Armor(5);
        Player player = new Player(100, playerArmor, playerWeapon);

        // Create an enemy with life and magic damage
        Enemy enemy = new Enemy(50, 15);

        // Create and start a battle
        Battle battle = new Battle(player, enemy);
        battle.start();
    }
}
