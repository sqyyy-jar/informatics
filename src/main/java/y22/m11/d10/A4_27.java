package y22.m11.d10;

import informatics.Exercise;

@Exercise("Aufgabe 4.27 - Sternzeit Rechner")
public class A4_27 {
    public static void run() {
        int year = 2011;
        int month = 11;
        int day = 11;
        int hour = 11;
        int minute = 11;
        System.out.println("Erdzeit 11.11.2011, 11:11 Uhr");
        System.out.println("   entspricht der Sternzeit " + toStarTime(year, month, day, hour, minute));
    }

    public static double toStarTime(int year, int month, int day, int hour, int minute) {
        double value = -(1111 * 365);
        value += year * 365;
        value += month * 30;
        value += day;

        value += (hour * 60) / 1440.;
        value += minute / 1440.;

        return Math.round(value * 1000) / 1000.;
    }
}
