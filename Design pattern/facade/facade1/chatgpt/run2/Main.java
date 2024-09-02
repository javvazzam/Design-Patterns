package facade.facade1.chatgpt.run2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Weapon {
    private int baseDamage;
    private Random random;

    public Weapon(int baseDamage) {
        this.baseDamage = baseDamage;
        this.random = new Random();
    }

    public int attackDamage() {
        // Daño aleatorio basado en el daño base
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
        int damage = magicDamage + random.nextInt(magicDamage / 2);
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

class Battle {
    private Player player;
    private Enemy enemy;
    private BattleStatistics stats;
    private BattleLog log;

    public Battle(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        this.stats = new BattleStatistics();
        this.log = new BattleLog();
    }

    public void start() {
        System.out.println("The battle begins!");

        while (player.isAlive() && enemy.isAlive()) {
            // Player attacks first
            int playerDamage = player.attack();
            enemy.takeDamage(playerDamage);
            stats.recordPlayerDamage(playerDamage);
            log.addEntry("Player dealt " + playerDamage + " damage. Enemy life: " + enemy.getLife());

            // Check if the enemy is still alive
            if (!enemy.isAlive()) {
                log.addEntry("Enemy is defeated!");
                break;
            }

            // Enemy attacks back
            int enemyDamage = enemy.attack();
            player.takeDamage(enemyDamage);
            stats.recordEnemyDamage(enemyDamage);
            log.addEntry("Enemy dealt " + enemyDamage + " damage. Player life: " + player.getLife());

            // Check if the player is still alive
            if (!player.isAlive()) {
                log.addEntry("Player is defeated!");
                break;
            }
        }

        System.out.println("The battle is over.");
        log.addEntry("The battle is over.");
        stats.printStatistics();
        log.printLog();
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a weapon and armor for the player
        Weapon sword = new Weapon(20);
        Armor shield = new Armor(5);

        // Create a player and enemy
        Player player = new Player(100, shield, sword);
        Enemy enemy = new Enemy(80, 15);

        // Set up and start the battle
        Battle battle = new Battle(player, enemy);
        battle.start();
    }
}


