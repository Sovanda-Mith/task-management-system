import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu
            System.out.println("Task Management System");
            System.out.println("1. Add a task");
            System.out.println("2. Edit a task");
            System.out.println("3. View all tasks");
            System.out.println("4. Delete a task");
            System.out.println("5. Mark a task as completed");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            // Get user input
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 0:
                    System.out.println("Exiting...");
                    return;
                case 1:
                    // Add a task
                    System.out.print("Enter the task title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter the task description: ");
                    String description = scanner.nextLine();

                    LocalDate dueDate = null;
                    while (dueDate == null) {
                        System.out.print("Enter the task due date (YYYY-MM-DD): ");
                        String dueDateString = scanner.nextLine();

                        try {
                            dueDate = LocalDate.parse(dueDateString);
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please try again.");
                        }
                    }

                    System.out.println("Enter task priority level: ");
                    System.out.println("1. Important");
                    System.out.println("2. Normal");
                    System.out.println("3. Less Important");
                    int priorityLevel = scanner.nextInt();
                    scanner.nextLine();


                    taskManager.addTask(title, description, dueDate, priorityLevel);
                    System.out.println("Task added successfully");
                    break;
                case 2:
                    // Edit a task
                    System.out.print("Enter the task title to edit: ");
                    String titleToEdit = scanner.nextLine();

                    System.out.print("Enter new task title: ");
                    String newTitle = scanner.nextLine();

                    System.out.print("Enter the task description: ");
                    String newDescription = scanner.nextLine();

                    LocalDate newDueDate = null;
                    while (newDueDate == null) {
                        System.out.print("Enter the task due date (YYYY-MM-DD): ");
                        String newDueDateString = scanner.nextLine();

                        try {
                            newDueDate = LocalDate.parse(newDueDateString);
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please try again.");
                        }
                    }

                    System.out.println("Enter task priority level: ");
                    System.out.println("1. Important");
                    System.out.println("2. Normal");
                    System.out.println("3. Less Important");
                    int newPriorityLevel = scanner.nextInt();
                    scanner.nextLine();

                    taskManager.editTask(titleToEdit, newTitle, newDescription, newDueDate, newPriorityLevel);
                    System.out.println("Task edited successfully.");
                    break;
                case 3:
                    // View all tasks
                    taskManager.viewTasks();
                    break;
                case 4:
                    // Delete a task
                    System.out.println("Enter the task title to delete: ");
                    String titleToDelete = scanner.nextLine();

                    taskManager.deleteTask(titleToDelete);
                    System.out.println("Task deleted successfully.");
                    break;
                case 5:
                    // Mark a task as completed
                    System.out.println("Enter the task title to mark as completed: ");
                    String titleToComplete = scanner.nextLine();

                    taskManager.markTaskAsCompleted(titleToComplete);
                    System.out.println("Task marked as completed successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        }



    }
}
