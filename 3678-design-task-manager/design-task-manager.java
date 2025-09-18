import java.util.*;

class TaskManager {

    static class Task {
        int userId;
        int taskId;
        int priority;
        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    private final Map<Integer, Task> taskMap;
    private final PriorityQueue<Task> pq;

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (b.priority != a.priority) return Integer.compare(b.priority, a.priority);
            return Integer.compare(b.taskId, a.taskId);
        });
        for (List<Integer> t : tasks) add(t.get(0), t.get(1), t.get(2));
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        pq.offer(task);
    }

    public void edit(int taskId, int newPriority) {
        Task old = taskMap.get(taskId);
        if (old != null) {
            Task updated = new Task(old.userId, old.taskId, newPriority);
            taskMap.put(taskId, updated);
            pq.offer(updated);
        }
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            Task top = pq.poll();
            Task cur = taskMap.get(top.taskId);
            if (cur != null && cur == top) {
                taskMap.remove(top.taskId);
                return top.userId;
            }
        }
        return -1;
    }
}
