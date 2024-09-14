package org.example;

public class Player {

    private String name;
    private CurrencyEnum currency;
    private double estimatedAmount;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public double getEstimatedAmount() {
        return estimatedAmount;
    }


    public void setCurrency(String currency) {
        this.currency = CurrencyEnum.valueOf(currency);
        System.out.println(this.name + "플레이어의 통화가 " + this.currency + "(" + this.currency.getCountry() + ")" + "로 설정되었습니다.");
    }

    public void setEstimatedAmount(double estimatedAmount) {
        this.estimatedAmount = estimatedAmount;
        System.out.println(this.name + "플레이어의 예측 값이 " + this.estimatedAmount + "로 설정되었습니다.");
    }


}