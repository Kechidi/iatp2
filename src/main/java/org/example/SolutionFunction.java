package org.example;

import java.util.concurrent.ThreadLocalRandom;

import static org.example.Recuit.recuit;

public class SolutionFunction implements Solution {
    private double x;

    SolutionFunction(double x) {
        this.x = x;
    }

    @Override
    public Solution voisin() {
        return new SolutionFunction(x + ThreadLocalRandom.current().nextGaussian());
    }

    @Override
    public double qualite() {
        var x2 = x * x;
        var x4 = x2 * x2;
        return Math.sin(10.0 * (0.3 * x) * Math.sin(1.3 * x * x + 0.00001 * x * x * x * x + 0.2 * x + 80.0));
    }

    @Override
    public boolean conditionArret() {
        return qualite() < -9.99;
    }
    public String toString() {
        return "Solution: x = " + x + ", qualite = " + qualite();
    }
    public static void main(String[] args) {
           System.out.println(Recuit.recuit(new SolutionFunction((0))));
            //SolutionFunction solution = new SolutionFunction(0.0); // Création d'une instance de SolutionFunction

           


        }

    }

