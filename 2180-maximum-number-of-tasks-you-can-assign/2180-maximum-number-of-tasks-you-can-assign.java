import java.util.*;

class Solution {
    static final int N = 256;
    static final int MASK = 255;
    static final int BSHIFT = 8;
    int[] queue = new int[50000];
    int front = 0, back = 0;
    void radixSort(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int max = Arrays.stream(nums).max().getAsInt();
        int rounds = Math.max(1, (31 - Integer.numberOfLeadingZeros(max) + BSHIFT) / BSHIFT);
        int[] freq = new int[N];
        int[] in = nums;
        int[] out = output;
        boolean swapped = false;
        for (int round = 0; round < rounds; round++) {
            int shift = round * BSHIFT;
            Arrays.fill(freq, 0);
            for (int num : in) freq[(num >> shift) & MASK]++;
            for (int i = 1; i < N; i++) freq[i] += freq[i - 1];
            for (int i = n - 1; i >= 0; i--) {
                int val = in[i];
                int x = (val >> shift) & MASK;
                out[--freq[x]] = val;
            }
            int[] temp = in;
            in = out;
            out = temp;
            swapped = !swapped;
        }
        if (swapped)
            System.arraycopy(in, 0, nums, 0, n);
    }
    int numTasks, numWorkers, pillBoost;
    boolean isFeasible(int[] tasks, int[] workers, int k, int pills) {
        int taskPtr = 0;
        front = back = 0;
        for (int i = numWorkers - k; i < numWorkers; i++) {
            int workerStrength = workers[i];
            while (taskPtr < k && tasks[taskPtr] <= workerStrength + pillBoost) {
                queue[back++] = tasks[taskPtr++];
            }
            if (front == back) return false;
            if (queue[front] <= workerStrength) {
                front++;
            } else {
                if (pills == 0) return false;
                pills--;
                back--; 
            }
        }
        return true;
    }

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        numTasks = tasks.length;
        numWorkers = workers.length;
        pillBoost = strength;
        radixSort(tasks);
        radixSort(workers);
        int low = 0, high = Math.min(numTasks, numWorkers);
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (isFeasible(tasks, workers, mid, pills)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}