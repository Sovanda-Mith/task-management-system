import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    // Constructor
    public TaskManager() { tasks = new ArrayList<>();}

    // Add a task
    public void addTask(String title, String description, LocalDate dueDate) {
        Task task = new Task(title, description, dueDate);
        tasks.add(task);
    }

    // Edit a task
    public void editTask(int index, String title, String description, LocalDate dueDate) {
        Task task = tasks.get(index);
        task.setTitle(title);
        task.setDescription(description);
        task.setDueDate(dueDate);
    }

    public List<Task> getTasks() {return  tasks;}

    // View all tasks
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("Task #" + (i + 1));
            System.out.println(tasks.get(i));
            System.out.println(); // empty line for formatting
        }
    }

    // Delete a task
    public void deleteTask(int index) {tasks.remove(index);}

    // Mark a task as completed
    public void markTaskAsCompleted(int index) {
        Task task = tasks.get(index);
        task.setCompleted(true);
    }

}
