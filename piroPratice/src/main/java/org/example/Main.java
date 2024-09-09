package org.example;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        Player a = new Player("A");
        Player b = new Player("B");

        Game game = new Game(new WebApiProvider());

        game.setRandomCurrency(a);
        game.setRandomCurrency(b);

        System.out.println();

        game.setEstimatedAmount(a);
        game.setEstimatedAmount(b);

        System.out.println();

        game.start(a, b);
    }
}
