class Solution {

    // Pair class to store:
    // duration = kitna time lagega course complete karne me
    // deadline = last day jiske andar course finish hona chahiye
    class Pair{
        int duration;
        int deadline;

        Pair(int duration, int deadline){
            this.duration = duration;
            this.deadline = deadline;
        }
    }

    public int scheduleCourse(int[][] courses) {

        int n = courses.length;

        // Min heap based on deadline
        // Purpose: courses ko earliest deadline ke order me process karna
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.deadline != b.deadline){
                return a.deadline - b.deadline; // smaller deadline first
            }
            else{
                return a.duration - b.duration; // optional tie-break
            }
        });

        // Step 1: sab courses heap me daal diye
        for(int i = 0; i < n; i++){
            pq.add(new Pair(courses[i][0], courses[i][1]));
        }

        // Max heap to store durations of selected courses
        // Purpose: agar total time exceed ho jaye toh longest course remove kar sake
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int time = 0; // total time spent so far

        // Step 2: process courses in increasing order of deadline
        while(!pq.isEmpty()){

            Pair p = pq.poll(); // next earliest deadline course

            int dur = p.duration;
            int lastDay = p.deadline;

            // Try to take this course
            time += dur;
            maxHeap.add(dur);

            // If total time exceeds deadline:
            // remove the course with maximum duration (greedy choice)
            if(time > lastDay){
                time -= maxHeap.poll();
            }
        }

        // number of courses successfully taken
        return maxHeap.size();
    }
}
