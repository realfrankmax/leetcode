package BinarySearch;

import java.util.Arrays;

/**
 * @leetcode: Maximum Profit in Job Scheduling
 */
public class JobScheduling {
    public static void main(String[] args) {}

    class Job {
        public int start;
        public int end;
        public int profit;
        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        Job[] jobs = new Job[len];
        for (int i = 0; i < len; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        // Sort by end time, so that we could check jobs backwards to make sure there is no overlapping
        Arrays.sort(jobs, (j1, j2) -> j1.end - j2.end);
        int[] max = new int[len];
        for (int i = 0; i < len; i++) {
            // For each job, the max profit could be
            // 1. Do the job + do some previous jobs (could be none)
            // 2. Don't do the job + do some previous jobs
            //    ==> max[i-1]
            max[i] = jobs[i].profit;
            for (int j = i-1; j >= 0; j--) {
                if (jobs[j].end <= jobs[i].start) {
                    max[i] = max[j] + jobs[i].profit;
                    break;
                } 
            }
            // Compare with skip the current job
            if (i != 0) {
                max[i] = Math.max(max[i], max[i-1]);
            }
        }
        return max[len-1];
    }
}