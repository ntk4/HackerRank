package interviewquestions;

import java.util.Stack;

public class TowersOfHanoi {

    private static class Tower {
        private Stack<Integer> disks;
        @SuppressWarnings("unused")
        private int index;

        public Tower(int i) {
            disks = new Stack<Integer>();
            index = i;
        }

        public void add(int d) {
            if (!disks.isEmpty() && disks.peek() < d) {
                System.out.println("Error");
                return;
            }
            disks.push(d);
        }

        private void moveTopTo(Tower otherTower) {
            if (!disks.isEmpty()) {
                int top = disks.pop();
                otherTower.add(top);
            }
        }

        public void moveDisks(int nDisks, Tower destination, Tower buffer) {
            if (nDisks > 0 && disks.size() >= nDisks) {
                moveDisks(nDisks - 1, buffer, destination);
                moveTopTo(destination);
                // System.out.println(destination.disks);
                buffer.moveDisks(nDisks - 1, destination, this);
            }
        }
    }

    public static void main(String[] args) {
        Tower[] towers = new Tower[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }

        for (int i = 2; i >= 0; i--) {
            towers[0].add(i);
        }

        System.out.println(towers[0].disks);
        towers[0].moveDisks(3, towers[2], towers[1]);

        System.out.println(towers[2].disks);
    }

}
