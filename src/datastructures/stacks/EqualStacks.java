package datastructures.stacks;

import java.util.Scanner;

public class EqualStacks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();

        int height1 = 0, height2 = 0, height3 = 0;

        int h1[] = new int[n1];
        for (int h1_i = 0; h1_i < n1; h1_i++) {
            h1[h1_i] = in.nextInt();
            height1 += h1[h1_i];
        }

        int h2[] = new int[n2];
        for (int h2_i = 0; h2_i < n2; h2_i++) {
            h2[h2_i] = in.nextInt();
            height2 += h2[h2_i];
        }

        int h3[] = new int[n3];
        for (int h3_i = 0; h3_i < n3; h3_i++) {
            h3[h3_i] = in.nextInt();
            height3 += h3[h3_i];
        }

        int i1 = 0, i2 = 0, i3 = 0;
        
        while (!(height1 == height2 && height2 == height3)) {

            if (height1 > height2 && height1 > height3) { // height1 highest
                height1 -= h1[i1++];
            } else if (height2 > height1 && height2 > height3) { // height2 highest
                height2 -= h2[i2++];
            } else if (height3 > height1 && height3 > height2) { // height3 highest
                height3 -= h3[i3++];
            } else if (height1 > height2 || height1 > height3) { // height1 higher but another equal exists 
                height1 -= h1[i1++];
            } else if (height2 > height1 || height2 > height3) { // height2 higher but another equal exists
                height2 -= h2[i2++];
            } else if (height3 > height1 || height3 > height2) { // height3 higher but another equal exists
                height3 -= h3[i3++];
            } 
        }

        System.out.println(height1);
        in.close();
    }

}
