package edu.umb.cs681.hw21;

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

        //min() catrgory with reduce
        int min_noOfCatetory = ccy.stream().parallel().map((CurrencyEXRate ce) ->ce.getCatetory() )
                .reduce(1000000000, (result, catetory)->catetory>result ? result : catetory);

        System.out.println("the min type of color is $"+min_noOfCatetory);

        //max() value with reduce.
        Float max_value = ccy.stream().parallel().map((CurrencyEXRate ce) ->ce.getValue() )
                .reduce(0.0f, (result,value)->result > value ? result : value);

        System.out.println("Price of most expensive car is $"+max_value);

        //count() with reduce
        int y=0;
        int count = ccy.stream().parallel().map(x->y+1).reduce(0,(a,b)->a+b);
        System.out.println("Total number of ccy in list:"+count);
    }
}
