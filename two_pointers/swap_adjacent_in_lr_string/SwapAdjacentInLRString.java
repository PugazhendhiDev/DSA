//LEETCODE 777. Swap Adjacent in LR String

class Solution {
    public boolean canTransform(String start, String result) {

        int n = start.length();

        int i = 0;
        int j = 0;

        while (i < n || j < n) {

            while (i < n && start.charAt(i) == 'X') {
                i++;
            }

            while (j < n && result.charAt(j) == 'X') {
                j++;
            }

            if (i == n || j == n) {
                return i == n && j == n;
            }

            char c1 = start.charAt(i);
            char c2 = result.charAt(j);

            if (c1 != c2) {
                return false;
            }

            if (c1 == 'L' && i < j) {
                return false;
            }

            if (c1 == 'R' && i > j) {
                return false;
            }

            i++;
            j++;
        }

        return true;
    }
}