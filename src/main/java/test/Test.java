package test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Flaming
 * @date 2019/6/4 9:35
 */
public class Test {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while(true){
            for(int i = 0; i < queue.size(); i++){
                System.out.println(i);
                queue.add(1);
            }
        }
    }

}
