package facade.facade1.basic;

import java.util.Random;

class Player {
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

    public int getLife() {
        return life;
    }

    public void takeDamage(int damage) {
        int damageTaken = damage - armor;
        if (damageTaken > 0) {
            life -= damageTaken;
        }
        System.out.println("Player takes " + damageTaken + " damage, life is now " + life);
    }

    public int attack() {
        int damage = weaponDamage + random.nextInt(weaponDamage / 2); // Daño aleatorio
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
        int damage = magicDamage + random.nextInt(magicDamage / 2); // Daño aleatorio
        System.out.println("Enemy attacks with magic damage " + damage);
        return damage;
    }

    public boolean isAlive() {
        return life > 0;
    }
}

class Fight {
    public void startFight(Player player, Enemy enemy) {
        System.out.println("The fight begins!");

        while (player.isAlive() && enemy.isAlive()) {
            // Player attacks first
            enemy.takeDamage(player.attack());

            if (enemy.isAlive()) {
                // Enemy counterattacks
                player.takeDamage(enemy.attack());
            }
        }

        if (player.isAlive()) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Enemy wins!");
        }
    }
}

//I wanto to create a random fights using a common interface to create and start them
//I want to create random fights, simplifying the interaction in the code where the fights start and the components that take care of the details of the fights
//I want to create randomfights refactoring the coded by just using one common interface