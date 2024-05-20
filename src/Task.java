import java.time.LocalDate;

public class Task {
    private  String title;
    private  String description;
    private LocalDate dueDate;
    private boolean completed;
    private int priorityLevel;

    // Constructor
    public Task(String title, String description, LocalDate dueDate, int priorityLevel) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false; // By default, tasks are not completed
        this.priorityLevel = priorityLevel;
    }

    // Getters and setters
    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}

    public void setDescription(String title) {this.description = description;}

    public LocalDate getDueDate() {return dueDate;}

    public void setDueDate(LocalDate dueDate) {this.dueDate = dueDate;}

    public boolean isCompleted() {return completed;}

    public  void setCompleted(boolean completed) {this.completed = completed;}

    public int getPriorityLevel() {return priorityLevel;}

    public void setPriorityLevel(int priorityLevel) {this.priorityLevel = priorityLevel;}


    // toString method to display task information
    @Override
    public String toString() {
        return title = " (" + (completed ? "completed" : "not completed") + ")" +
                "\nPriority Level: " + priorityLevel +
                "\nDescription: " + description +
                "\nDue date: " + dueDate;
    }

}
