package interviewquestions;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher extends Thread {

    public static class Chopstick {

        private Lock lock;

        public Chopstick() {
            lock = new ReentrantLock();
        }

        public boolean pickUp() {
            return lock.tryLock();
        }

        public void putDown() {
            lock.unlock();
        }
    }

    private int bites = 10;
    private Chopstick left, right;

    public Philosopher(Chopstick left, Chopstick right) {
        this.left = left;
        this.right = right;
    }

    public void eat() {
        if (pickUp()) {
            chew();
            putDown();
            System.out.println("ate");
        }
    }

    private boolean pickUp() {
        if (!left.pickUp())
            return false;

        if (!right.pickUp()) {
            left.putDown();
            return false;
        }
        return true;

    }

    private void chew() {
    }

    private void putDown() {
        left.putDown();
        right.putDown();

    }

    public void run() {
        for (int i = 0; i < bites; i++) {
            eat();
        }
    }

    public static void main(String[] args) {
        Philosopher.Chopstick c1 = new Chopstick(), c2 = new Chopstick(), c3 = new Chopstick(), c4 = new Chopstick();
        Philosopher p1 = new Philosopher(c1, c2);
        Philosopher p2 = new Philosopher(c2, c3);
        Philosopher p3 = new Philosopher(c3, c4);

        p1.run();
        p2.run();
        p3.run();
    }
}
