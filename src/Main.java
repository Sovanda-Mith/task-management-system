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
                    taskManager.addTask(title, description, dueDate);
                    System.out.println("Task added successfully");
                    break;
                case 2:
                    // Edit a task
                    System.out.print("Enter the task number to edit: ");
                    int editIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (editIndex <= 0 || editIndex > taskManager.getTasks().size()) {
                        System.out.println("Invalid task number. Please try again.");
                        break;
                    }
                    System.out.print("Enter the task title: ");
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

                    taskManager.editTask(editIndex - 1, newTitle, newDescription, newDueDate);
                    System.out.println("Task edited successfully.");
                    break;
                case 3:
                    // View all tasks
                    taskManager.viewTasks();
                    break;
                case 4:
                    // Delete a task
                    System.out.println("Enter the task number to delete: ");
                    int deleteIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (deleteIndex <= 0 || deleteIndex > taskManager.getTasks().size()) {
                        System.out.println("Invalid task number. Please try again.");
                        break;
                    }

                    taskManager.deleteTask(deleteIndex - 1);
                    System.out.println("Task deleted successfully.");
                    break;
                case 5:
                    // Mark a task as completed
                    System.out.println("Enter the task number to mark as completed: ");
                    int completedIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (completedIndex <= 0 || completedIndex > taskManager.getTasks().size()) {
                        System.out.println("Invalid task number. Please try again.");
                        break;
                    }
                    taskManager.markTaskAsCompleted(completedIndex - 1);
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
