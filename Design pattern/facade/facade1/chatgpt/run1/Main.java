package facade.facade1.chatgpt.run1;

import java.util.Random;

interface Fighter {
    int attack();
    void takeDamage(int damage);
    boolean isAlive();
    int getLife();
}


class Player implements Fighter {
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
        int damage = weaponDamage + random.nextInt(weaponDamage / 2); // Random damage
        System.out.println("Player attacks with damage " + damage);
        return damage;
    }

    @Override
    public boolean isAlive() {
        return life > 0;
    }
}

class Enemy implements Fighter {
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
        int damage = magicDamage + random.nextInt(magicDamage / 2); // Random damage
        System.out.println("Enemy attacks with magic damage " + damage);
        return damage;
    }

    @Override
    public boolean isAlive() {
        return life > 0;
    }
}


class Fight {
    public void startFight(Fighter fighter1, Fighter fighter2) {
        System.out.println("The fight begins!");

        while (fighter1.isAlive() && fighter2.isAlive()) {
            // Fighter 1 attacks first
            fighter2.takeDamage(fighter1.attack());

            if (fighter2.isAlive()) {
                // Fighter 2 counterattacks
                fighter1.takeDamage(fighter2.attack());
            }
        }

        if (fighter1.isAlive()) {
            System.out.println("Fighter 1 wins!");
        } else {
            System.out.println("Fighter 2 wins!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Player player = new Player(100, 10, 20);
        Enemy enemy = new Enemy(80, 15);

        Fight fight = new Fight();
        fight.startFight(player, enemy);  // Player vs Enemy
    }
}

