package datastructures.queue;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {

    private Stack<Integer> stack1, stack2;
    
    public QueueUsingTwoStacks() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    public void enqueue(Integer value) {
        stack1.push(value);
    }
    
    public Integer dequeue() {
        if (stack2.isEmpty())
            moveStack1ToStack2();
        if (!stack2.isEmpty())
            return stack2.pop();
        
        throw new NoSuchElementException();
    }
    
    private void moveStack1ToStack2() {
        while (!stack1.isEmpty()) 
            stack2.push(stack1.pop());
    }
    
    public Integer peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        } else if (!stack1.isEmpty()) {
            moveStack1ToStack2();
            return stack2.peek();
        }
        throw new NoSuchElementException();
    }
    
    
    
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int queries = in.nextInt();

        QueueUsingTwoStacks solution = new QueueUsingTwoStacks();
        for (int query=0;query<queries;query++) {
            int action = in.nextInt();
            int value = 0;
            
            switch(action) {
                case 1:
                    value = in.nextInt();
                    solution.enqueue(value);
                    break;
                case 2:
                    solution.dequeue();
                    break;
                case 3: 
                System.out.println(solution.peek());
                    break;
                default:
                    break;
                
            }
        }
        in.close();
    }
}
