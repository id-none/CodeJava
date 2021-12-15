package wb;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 王波
 */
public class Process {
    public int pid;
    public int priority;
    PriorityQueue<Process> queue = new PriorityQueue<>(new Comparator<Process>() {
        @Override
        public int compare(Process o1, Process o2) {
            return o1.priority - o2.priority;
        }
    });
}
