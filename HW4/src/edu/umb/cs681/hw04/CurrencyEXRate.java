package edu.umb.cs681.hw04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CurrencyEXRate {
    private String country, currency;
    private int year, catetory;
    private float value;
    public CurrencyEXRate(String country, String currency, int catetory, int year, float value) {
        this.country = country;
        this.currency = currency;
        this.year = year;
        this.catetory = catetory;
        this.value = value;
    }
    public String getCountry() {
        return country;
    }
    public String getCurrency() {
        return currency;
    }
    public int getCatetory() {
        return catetory;
    }
    public int getYear() {
        return year;
    }
    public float getValue() {
        return value;
    }
    public static void main(String args[]) {
        List<CurrencyEXRate> ccy = new ArrayList<>();
        ccy.add(new CurrencyEXRate("China", "rmb", 10, 1949, 1f));
        ccy.add(new CurrencyEXRate("USA", "dollar", 15, 1775, 6.48f));
        ccy.add(new CurrencyEXRate("Japan", "yen", 20, 1871, 0.061f));
        ccy.add(new CurrencyEXRate("Britain", "pound", 11, 1694, 9.02f));
        long numberOfCurrency = ccy.stream().count();
        System.out.println("---Number of currency in tte list: " + numberOfCurrency);
        CurrencyEXRate highestValueCurrency = ccy.stream().parallel().max(Comparator.comparing(CurrencyEXRate::getValue)).get();
        System.out.println(highestValueCurrency.getCountry() + " has the highest rate in the list");
        CurrencyEXRate lowestValueCurrency = ccy.stream().min(Comparator.comparing(CurrencyEXRate::getValue)).get();
        System.out.println(lowestValueCurrency.getCountry() + " has the lowest rate in the list");
        List<CurrencyEXRate> sortedByYear = ccy.stream().sorted(Comparator.comparing(CurrencyEXRate::getYear, Comparator.reverseOrder()))
                .collect(Collectors.toList());
        System.out.println("List sorted by year in descending: ");
        sortedByYear.forEach((CurrencyEXRate cy) -> System.out.println(cy.getCountry() + ": " + cy.getYear()));
    }
}
