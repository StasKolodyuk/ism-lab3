package by.bsu.kolodyuk;


import org.apache.commons.math3.random.AbstractRandomGenerator;

public class LinearCongruentialGenerator extends AbstractRandomGenerator {

    private long a;
    private long c;
    private long m;

    private long current;

    public LinearCongruentialGenerator(int a, int x0, int c, int m) {
        this.a = a;
        this.current = x0;
        this.c = c;
        this.m = m;
    }

    @Override
    public void setSeed(long seed) {
        this.current = seed;
    }

    @Override
    public double nextDouble() {
        current = (a * current + c) % m;
        return current;
    }
}
