package datastructuresassignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Job {
    int id;
    int deadline;
    int profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {

    // Function to find the maximum profit sequence of jobs
    public static List<Job> jobSequencing(List<Job> jobs) {
        // Sort jobs in descending order of profit
        Collections.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                return j2.profit - j1.profit;
            }
        });

        // Find the maximum deadline to determine the size of the time slots array
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        // Create a time slots array to keep track of free time slots
        boolean[] timeSlots = new boolean[maxDeadline];
        List<Job> result = new ArrayList<>();

        // Iterate through the sorted jobs
        for (Job job : jobs) {
            // Find a free time slot for this job (starting from the last possible slot)
            for (int j = Math.min(maxDeadline, job.deadline) - 1; j >= 0; j--) {
                if (!timeSlots[j]) {
                    // Assign the job to this time slot
                    timeSlots[j] = true;
                    result.add(job);
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job(1, 4, 20));
        jobs.add(new Job(2, 1, 10));
        jobs.add(new Job(3, 1, 40));
        jobs.add(new Job(4, 1, 30));

        List<Job> jobSequence = jobSequencing(jobs);
        System.out.println("Selected jobs for maximum profit:");
        for (Job job : jobSequence) {
            System.out.println("Job ID: " + job.id + ", Deadline: " + job.deadline + ", Profit: " + job.profit);
        }
    }
}
