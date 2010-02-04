package com.rcc.brew.util;

public class Calculator {
    public static double sgToPlato(double sg) {
        return -676.67 + (1286.4 * sg) - (800.47 * sg * sg) + (190.74 * sg * sg * sg);
    }

    public static double platoToSg(double p) {
        return 1 + (p/(258.6 - (0.8796 * p)));
    }

    public static double brixToSg(double b) {
        return 1.000019
                + (0.003865613 * (b))
                + (0.00001296425 * b * b)
                + (0.00000005701128 * b * b * b);
    }

    public static double sgToBrix(double sg) {
        return 261.3 * (1 - (1/sg));
    }

    public static double finalSgFromOriginalAndFinalBrix(double ob, double fb) {
        return 1.001843
                - 0.002318474*ob
                - 0.000007775*ob*ob
                - 0.000000034*ob*ob*ob
                + 0.00574*fb
                + 0.00003344*fb*fb
                + 0.000000086*fb*fb*fb;
    }

    public static double brixToIndexOfRefraction(double b) {
        return 1.33302 + 0.001427193*b + 0.000005791157*b*b;
    }
}
