package datastructures.stacks;

import java.util.Scanner;
import java.util.Stack;

public class Waiter {
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            stack.push(in.nextInt());
        }

        Stack<Integer> divisible = new Stack<Integer>();
        Stack<Integer> indivisible = new Stack<Integer>();

        int primeNumber = 2;
        while (q-- > 0) {
            
            indivisible.clear();
            
            while (!stack.isEmpty()) {
                int value = stack.pop();
                if (isDivisibleByPrimeNumber(primeNumber, value)) 
                    divisible.push(value);
                else 
                    indivisible.push(value);
            }
            
            printStack(divisible);
            
            stack = (Stack<Integer>)indivisible.clone();

            primeNumber = calculateNextPrimeNumber(primeNumber);
        }
        
        printStack(stack);

        in.close();
    }

    private static int calculateNextPrimeNumber(int primeNumber) {
        boolean isPrime = false;
        
        while (!isPrime) {
            primeNumber++;
            isPrime = true;
            for (int i = 2;i < primeNumber; i++) {
                if (primeNumber % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        return primeNumber;
    }

    private static void printStack(Stack<Integer> s) {
        if (s == null)
            return;

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    private static boolean isDivisibleByPrimeNumber(int minPrime, int number) {
        if (minPrime <= 0)
            return false;
        return number % minPrime == 0;
    }

}
