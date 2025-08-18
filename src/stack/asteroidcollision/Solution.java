package stack.asteroidcollision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{8,-8})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10,2,-5})));
    }

    private static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> resultStack = new Stack<>();
        resultStack.push(asteroids[0]);
        int length = asteroids.length;
        for(int i = 1; i<length; i++) {
            if(resultStack.isEmpty()) {
                resultStack.push(asteroids[i]);
                continue;
            }
            Integer lastAsteroid =resultStack.lastElement();
            Integer currentAsteroid = asteroids[i];
            boolean addToResult = true;
            while((lastAsteroid >0 && currentAsteroid < 0)) {
                if(Math.abs(lastAsteroid) == Math.abs(currentAsteroid)) {
                    resultStack.pop();
                    addToResult=false;
                    break;
                } else if (Math.abs(lastAsteroid) > Math.abs(currentAsteroid)) {
                    addToResult=false;
                    break;
                } else {
                    resultStack.pop();
                    if(resultStack.isEmpty()) {
                        break;
                    }
                    lastAsteroid = resultStack.lastElement();
                }
            }
            if(addToResult){
                resultStack.push(asteroids[i]);
            }
        }
        return resultStack.stream().mapToInt(Integer::intValue).toArray();
    }
}
