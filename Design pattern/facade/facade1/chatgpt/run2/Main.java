package facade.facade1.chatgpt.run2;

import java.util.Random;

interface Combatant {
    int getLife();
    void takeDamage(int damage);
    int attack();
    boolean isAlive();
}

class Player implements Combatant {
    private int life;
    private int armor;
    private int weaponDamage;
    private Random random;

    public Player(int life, int armor, int weaponDamage) {
        this.life = life;
        this.armor = armor;
        this.weaponDamage = weaponDamage;
        this.random = new Random();
    }

    @Override
    public int getLife() {
        return life;
    }

    @Override
    public void takeDamage(int damage) {
        int damageTaken = damage - armor;
        if (damageTaken > 0) {
            life -= damageTaken;
        }
        System.out.println("Player takes " + damageTaken + " damage, life is now " + life);
    }

    @Override
    public int attack() {
        int damage = weaponDamage + random.nextInt(weaponDamage / 2);
        System.out.println("Player attacks with damage " + damage);
        return damage;
    }

    @Override
    public boolean isAlive() {
        return life > 0;
    }
}

class Enemy implements Combatant {
    private int life;
    private int magicDamage;
    private Random random;

    public Enemy(int life, int magicDamage) {
        this.life = life;
        this.magicDamage = magicDamage;
        this.random = new Random();
    }

    @Override
    public int getLife() {
        return life;
    }

    @Override
    public void takeDamage(int damage) {
        life -= damage;
        System.out.println("Enemy takes " + damage + " damage, life is now " + life);
    }

    @Override
    public int attack() {
        int damage = magicDamage + random.nextInt(magicDamage / 2);
        System.out.println("Enemy attacks with magic damage " + damage);
        return damage;
    }

    @Override
    public boolean isAlive() {
        return life > 0;
    }
}


class Fight {
    public void startFight(Combatant combatant1, Combatant combatant2) {
        System.out.println("The fight begins!");

        while (combatant1.isAlive() && combatant2.isAlive()) {
            // Combatant 1 attacks first
            combatant2.takeDamage(combatant1.attack());

            if (combatant2.isAlive()) {
                // Combatant 2 counterattacks
                combatant1.takeDamage(combatant2.attack());
            }
        }

        if (combatant1.isAlive()) {
            System.out.println("Combatant 1 wins!");
        } else {
            System.out.println("Combatant 2 wins!");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Player player = new Player(100, 10, 20);
        Enemy enemy = new Enemy(80, 15);

        Fight fight = new Fight();
        fight.startFight(player, enemy);
    }
}

