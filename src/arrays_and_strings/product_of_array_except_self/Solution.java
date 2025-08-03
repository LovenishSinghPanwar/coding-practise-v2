package arrays_and_strings.product_of_array_except_self;

public class Solution {

    public static void main(String[] args) {
        int[] result = productOfArrayExceptSelf(new int[]{1,2,3,4});
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] productOfArrayExceptSelf(int[] input) {
        int inputArraySize = input.length;
        if(inputArraySize==1) {
            return new int[]{1};
        }
        int[] result = new int[input.length];

        int leftProduct = 1;
        for(int i =0; i<inputArraySize;i++) {
            result[i] = leftProduct;
            leftProduct = leftProduct * input[i];
        }

        int rightProduct = 1;
        for(int i = inputArraySize -1 ; i>=0;i--) {
            result[i] = result[i] * rightProduct;
            rightProduct = rightProduct * input[i];
        }

        return result;
    }
}
