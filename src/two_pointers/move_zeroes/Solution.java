package two_pointers.move_zeroes;

public class Solution {

    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }

    public static void moveZeroes(int[] nums) {
        int nonZeroInsertPosition = 0;
        for(int num: nums) {
            if(num!=0) {
                nums[nonZeroInsertPosition++] = num;
            }
        }
        while(nonZeroInsertPosition<nums.length) {
            nums[nonZeroInsertPosition]= 0;
        }
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}
