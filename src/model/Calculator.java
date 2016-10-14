package model;

public interface Calculator {
    void getSum();

    void getSqrt(double a);

    /**
     * @param a an angle, in degrees
     */
    void getSin(double a);

    void printResult();

    /**
     * finds the max value
     * in  of integers
     *
     * @param arrayOfInts
     * @throws RuntimeException if array is empty
     */

    void getMax(int[] arrayOfInts) throws RuntimeException;
}

