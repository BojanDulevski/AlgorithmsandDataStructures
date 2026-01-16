import java.util.*;

public class KolokviumNo1 {
    static class Job {
        String name;
        int totalTime = 0;
        int lastStart = -1;
        boolean finished = false;

        Job(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, Job> jobs = new HashMap<>();

        String currentJob = null;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String jobName = parts[0];
            String command = parts[1];
            int time = Integer.parseInt(parts[2]);

            jobs.putIfAbsent(jobName, new Job(jobName));
            Job job = jobs.get(jobName);

            switch (command) {

                case "start":

                    if (currentJob != null) {
                        Job running = jobs.get(currentJob);
                        running.totalTime += time - running.lastStart;
                    }

                    job.lastStart = time;
                    currentJob = jobName;
                    break;

                case "interrupt":

                    if (currentJob != null) {
                        Job running = jobs.get(currentJob);
                        running.totalTime += time - running.lastStart;
                    }

                    job.lastStart = time;
                    currentJob = jobName;
                    break;

                case "finish":

                    if (currentJob != null && currentJob.equals(jobName)) {
                        job.totalTime += time - job.lastStart;
                        job.finished = true;
                        currentJob = null;
                    }
                    break;
            }
        }


        List<Job> finished = new ArrayList<>(jobs.values());
        finished.removeIf(j -> !j.finished);

        finished.sort((a, b) -> {

            return a.name.compareTo(b.name);
        });

        for (Job j : finished) {
            System.out.println(j.name + " " + j.totalTime);
        }
    }
}
