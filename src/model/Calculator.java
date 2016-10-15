package model;

public interface Calculator {
    void getSum();

    void getDifference();

    void getQuotient();

    void getProduct();

    void getSqrt(double a);

    /**
     * @param a an angle, in degrees
     */
    void getSin(double a);

    /**
     * prints last result of certain operation
     *
     * @param operation type of operation
     */
    void printResult(String operation);

    /**
     * finds the max value
     * in  of integers
     *
     * @param arrayOfInts
     * @throws IllegalArgumentException if array is empty
     */

    void getMax(int[] arrayOfInts) throws IllegalArgumentException;
}

