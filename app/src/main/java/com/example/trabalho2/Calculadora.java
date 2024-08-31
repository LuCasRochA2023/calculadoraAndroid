package com.example.trabalho2;

public class Calculadora {
    Double N1, N2;
    public String soma(String n1, String n2){
        N1 = Double.parseDouble(n1);
        N2 = Double.parseDouble(n2);
        return String.valueOf(N1 + N2);
    }

    public String subtrai(String n1, String n2){
        N1 = Double.parseDouble(n1);
        N2 = Double.parseDouble(n2);
        return String.valueOf(N1 - N2);
    }

    public String multiplica(String n1, String n2){
        N1 = Double.parseDouble(n1);
        N2 = Double.parseDouble(n2);
        return String.valueOf(N1 * N2);
    }

    public String divide(String n1, String n2){
        N1 = Double.parseDouble(n1);
        N2 = Double.parseDouble(n2);
        if (n2.equals(0)){
            return null;
        }
        return String.valueOf(N1 / N2);
    }
}

