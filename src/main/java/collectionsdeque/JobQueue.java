package collectionsdeque;

import java.util.*;

public class JobQueue {

    public Queue<Job> addJob(Job... jobs) {
        PriorityQueue<Job> jobQuene = new PriorityQueue<>();
        for (Job job : jobs) {
            jobQuene.add(job);
        }
        return jobQuene;
    }

    public Deque<Job> addJobByUrgency(Job... jobs) {
        Deque<Job> jobQueue = new ArrayDeque<>();
        for (Job j : jobs) {
            if (j.isUrgent()) {
                jobQueue.addFirst(j);
            } else {
                jobQueue.addLast(j);
            }
        }
        return jobQueue;
    }

    public Job dispatchUrgentJob(Deque<Job> jobs) throws NoJobException {
        if (jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }
        jobs.getFirst().setUrgent(true);
        return jobs.getFirst();
    }

    public Job dispatchNotUrgentJob(Deque<Job> jobs) throws NoJobException {
        if (jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.getLast();
    }
}
