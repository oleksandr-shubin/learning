package model;

public interface Calculator {
    void getSum();

    void getSqrt(double a);

    /**
     * @param a an angle, in degrees
     */
    void getSin(double a);

    void printResult();
}

