package com.nhuamani.bankAppApi.utils;

public class GenerateAccountNumber {

    public static int randomNumber() {
        return (int) (Math.random() * 9);
    }

    public static String accountNumber() {
        StringBuilder accountNumber = new StringBuilder();

        for (int x = 0; x < 13; x++) {
            accountNumber.append(String.valueOf((x == 0 && randomNumber() == 0) ? randomNumber() + 2 : randomNumber()));
        }

        return accountNumber.toString();
    }

}
