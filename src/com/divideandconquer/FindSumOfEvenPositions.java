package com.divideandconquer;

public class FindSumOfEvenPositions {
    public static void main(String[] args) {
       // int[] intArray = new int[]{ 1,7,3,4,7,6,2,9 };
       // int[] intArray = new int[]{ 1,2,1,2,1 };
       // int[] intArray = new int[]{  7, 8 ,4, 5, 7, 6, 8, 9, 7, 3};
        int[] intArray = new int[]{ 3,1,2,1};

      //  printSubArrays(intArray);
        System.out.println("max = "+ findMaxSum(intArray));
    }

    /**
     * Finds the Max sum of elements on even positions. total time complexity would be n2.
     * @param numbers
     * @return
     */
    public static int findMaxSum(int[] numbers) {
        int totalNums = numbers.length;
        int max = 0;
        int initialSum = 0 ;
        //max sum of even positions, Time complexity : n
        for (int j = 0; j <totalNums ; j = j+2) {
            initialSum = initialSum +numbers[j];
        }
        max = initialSum;
        // Finding sub array and sum n2
        for (int subArySz = 2; subArySz <=totalNums ; subArySz = subArySz+2) {
            for (int j = 0; j < totalNums-subArySz+1 ; j++) {
                int lpv = 1;
                int i=j;
                int sum = initialSum;
                while (i < totalNums && lpv <= subArySz) {
                    sum = i%2 ==0 ? sum - numbers[i] : sum + numbers[i];
                    i++;
                    lpv++;
                }
                if( sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
