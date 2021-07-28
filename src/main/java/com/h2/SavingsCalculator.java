package com.h2;

import javax.swing.text.Utilities;
import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {
    private float [] credits;
    private float [] debits;

    public SavingsCalculator(float[] credits, float[] debits) {
        this.credits = credits;
        this.debits = debits;
    }

    public float calculate() {
        return sumOfCredits() - sumOfDebits();
    }

    private float sumOfCredits(){
        var sum = 0.0f;
        for(float credit : credits){
            sum += credit;
        }
        return sum;
    }
    private float sumOfDebits(){
        var sum = 0.0f;
        for(float debit : debits){
            sum += debit;
        }
        return sum;
    }

    private static int remainingDaysInMonth(LocalDate date){
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        int remainingDays = totalDaysInMonth - date.getDayOfMonth();

        return remainingDays;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("usage: savingsCalculator <credits separated by ','> <debits separated by ','>");
            System.exit(-1);
        }
        final String[] creditsAsString = args[0].split(",");
        final String[] debitsAsString = args[1].split(",");

        final float[] credits = new float[creditsAsString.length];
        final float[] debits = new float[debitsAsString.length];

        for (int i = 0; i < creditsAsString.length; i++) {
            credits[i] = Float.parseFloat(creditsAsString[i]);
        }

        for (int i = 0; i < debitsAsString.length; i++) {
            debits[i] = Float.parseFloat(debitsAsString[i]);
        }
        final SavingsCalculator calculator = new SavingsCalculator(credits, debits);

        System.out.println("Net Savings = " + calculator.calculate());
    }

}
