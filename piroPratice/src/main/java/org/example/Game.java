package org.example;

import java.io.IOException;
import java.util.Random;

public class Game {

    private final WebApiProvider webApiProvider;
    private final Random random;

    public Game(WebApiProvider webApiProvider) {
        this.webApiProvider = webApiProvider;
        this.random = new Random();
    }

    public void setRandomCurrency(Player player) {
        CurrencyEnum[] values = CurrencyEnum.values();

        int index = random.nextInt(values.length);

        player.setCurrency(values[index].toString());
    }

    public void setEstimatedAmount(Player player) {
        int integer = random.nextInt(50);
        double fraction = random.nextDouble();

        double randomDecimal = integer + fraction;

        randomDecimal = Math.round(randomDecimal * 100.0) / 100.0;

        player.setEstimatedAmount(randomDecimal);
    }

    public void start(Player playerA, Player playerB) throws IOException {
        ExRateData exRateData = webApiProvider.getExRateData();

        double playerAExRate = exRateData.getRates().get(playerA.getCurrency().toString());
        System.out.println("A가 가져온 환율 값은 " + playerAExRate + "입니다.");

        double playerBExRate = exRateData.getRates().get(playerB.getCurrency().toString());
        System.out.println("B가 가져온 환율 값은 " + playerBExRate + "입니다.");

        System.out.println();

        double differenceA = Math.abs(playerAExRate - playerA.getEstimatedAmount());
        double differenceB = Math.abs(playerBExRate - playerB.getEstimatedAmount());

        double compare = differenceA - differenceB;

        if (compare == 0) {
            System.out.println("무승부입니다, 값 : " + differenceA);
        } else if (compare > 0) {
            System.out.println("B가 이겼습니다.\nA : " + differenceA + ", B : " + differenceB);
        } else {
            System.out.println("A가 이겼습니다.\nA : " + differenceA + ", B : " + differenceB);
        }
    }
}