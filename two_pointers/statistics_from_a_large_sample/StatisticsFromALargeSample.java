//LEETCODE 1093. Statistics from a Large Sample

class Solution {
    public double[] sampleStats(int[] count) {
        double min = -1, max = 0, mean, median, mode = 0;

        long total = 0;
        long sum = 0;
        int maxFreq = 0;

        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                if (min == -1) min = i;
                max = i;

                total += count[i];
                sum += (long) i * count[i];

                if (count[i] > maxFreq) {
                    maxFreq = count[i];
                    mode = i;
                }
            }
        }

        mean = (double) sum / total;

        long m1 = (total + 1) / 2;
        long m2 = (total + 2) / 2;

        long curr = 0;
        int median1 = 0, median2 = 0;

        for (int i = 0; i < 256; i++) {
            curr += count[i];

            if (curr >= m1 && median1 == 0) {
                median1 = i;
            }

            if (curr >= m2) {
                median2 = i;
                break;
            }
        }

        median = (median1 + median2) / 2.0;

        return new double[] {min, max, mean, median, mode};
    }
}