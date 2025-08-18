package arraysandstrings.stringcompression;

public class Solution {

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
    }

    private static int compress(char[] chars) {
        int arraySize = chars.length;
        if(arraySize == 1) {
            return 1;
        }

        int readPosition = 0;
        int writePosition=0;

        while (readPosition < arraySize) {
            char currentChar = chars[readPosition];
            int count=0;

            while ((readPosition<arraySize) && currentChar == chars[readPosition]) {
                readPosition++;
                count++;
            }

            chars[writePosition++] = currentChar;

            if(count>1) {
                for(char c: Integer.toString(count).toCharArray()) {
                    chars[writePosition++] = c;
                }
            }
        }
        return writePosition;
    }

//    private static int compress(char[] chars) {
//        int arraySize = chars.length;
//        if(arraySize==1) {
//            return 1;
//        }
//        char character = chars[0];
//        char[] result = new char[chars.length];
//        int resultIndex =0;
//        result[resultIndex] = (character);
//        resultIndex++;
//        int firstIndex = 0;
//        int lastIndex = 0;
//        boolean isLastIndex = false;
//        for (int i = 1; i<arraySize;i++) {
//            if(i==arraySize-1) {
//                isLastIndex = true;
//            }
//            if(chars[i] == character && (i!=arraySize-1)) {
//                continue;
//            } else {
//                lastIndex = isLastIndex ? i: i-1;
//                int numberOfOccurrence = lastIndex - firstIndex + 1;
//                firstIndex = i;
//                if(!(numberOfOccurrence==1)) {
//                    while (numberOfOccurrence>10) {
//                        result[resultIndex] = (Character.forDigit(numberOfOccurrence%10,10));
//                        resultIndex++;
//                        numberOfOccurrence = numberOfOccurrence / 10;
//                    }
//                }
//                result[resultIndex] = (Character.forDigit(numberOfOccurrence, 10));
//                resultIndex++;
//                if(!isLastIndex) {
//                    character = chars[i];
//                    result[resultIndex] = (character);
//                    resultIndex++;
//                }
//            }
//        }
//        System.out.println(result);
//        chars = result;
//        return result.length;
//    }
}
