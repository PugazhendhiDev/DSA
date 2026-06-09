//LEETCODE 1089. Duplicate Zeros

class Solution {
    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] == 0) {
               for (int j = len - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }

                arr[i + 1] = 0;

                i++;
            }
        }
    }
}