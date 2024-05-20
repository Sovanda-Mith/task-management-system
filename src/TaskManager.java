import java.time.LocalDate;
import java.util.Iterator;
import java.util.PriorityQueue;

public class TaskManager {
    private PriorityQueue<Task> tasks;

    // Constructor
    public TaskManager() { tasks = new PriorityQueue<>();}

    // Add a task
    public void addTask(String title, String description, LocalDate dueDate, int priorityLevel) {
        Task task = new Task(title, description, dueDate, priorityLevel);
        tasks.add(task);
    }

    // Edit a task
    public void editTask(String title, String newTitle, String description, LocalDate dueDate, int priorityLevel) {
        Task taskToEdit = null;
        Iterator<Task> it = tasks.iterator();

        while (it.hasNext()) {
            Task task = it.next();
            if (task.getTitle().equals(title)) {
                taskToEdit = task;
                break;
            }
        }

        if (taskToEdit != null) {
            taskToEdit.setTitle(newTitle);
            taskToEdit.setDescription(description);
            taskToEdit.setDueDate(dueDate);
            taskToEdit.setPriorityLevel(priorityLevel);
        } else {
            System.out.println("Task not found.");
        }
    }

    public PriorityQueue<Task> getTasks() {
        return tasks;
    }

    // View all tasks
    public void viewTasks() {
        Iterator<Task> it = tasks.iterator();
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        while (it.hasNext()) {
            Task task = it.next();
            System.out.println(task);
            System.out.println();
        }

    }

    // Delete a task
    public void deleteTask(String title) {
        Iterator<Task> it = tasks.iterator();

        while (it.hasNext()) {
            Task task = it.next();
            if (task.getTitle().equals(title)) {
                it.remove();
                break;
            }
        }
    }

    // Mark a task as completed
    public void markTaskAsCompleted(String title) {

        Iterator<Task> it = tasks.iterator();

        while (it.hasNext()) {
            Task task = it.next();
            if (task.getTitle().equals(title)) {
                task.setCompleted(true);
                break;
            }
        }

    }

}
