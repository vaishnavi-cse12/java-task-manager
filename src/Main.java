import java.util.Scanner;

/**
 * Main class containing the program entry point and menu system.
 * This class handles user interaction through a console menu.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        boolean running = true;

        System.out.println("=== TASK MANAGER APPLICATION ===\n");

        // Main program loop
        while (running) {
            displayMenu();
            System.out.print("Enter your choice (1-5): ");
            
            // Validate input to prevent InputMismatchException
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 1 and 5.\n");
                scanner.next(); // Clear invalid input
                continue;
            }
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    // Add Task
                    System.out.print("Enter task description: ");
                    String title = scanner.nextLine().trim();
                    
                    if (title.isEmpty()) {
                        System.out.println("Task description cannot be empty!\n");
                    } else {
                        taskManager.addTask(title);
                    }
                    break;

                case 2:
                    // View All Tasks
                    taskManager.viewAllTasks();
                    break;

                case 3:
                    // Mark Task as Completed
                    System.out.print("Enter task ID to mark as completed: ");
                    if (scanner.hasNextInt()) {
                        int completeId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        
                        boolean success = taskManager.markTaskAsCompleted(completeId);
                        if (success) {
                            System.out.println("Task marked as completed!");
                        } else {
                            System.out.println("Task not found! Please check the ID.");
                        }
                    } else {
                        System.out.println("Invalid ID! Please enter a number.");
                        scanner.next(); // Clear invalid input
                    }
                    break;

                case 4:
                    // Delete Task
                    System.out.print("Enter task ID to delete: ");
                    if (scanner.hasNextInt()) {
                        int deleteId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        
                        boolean success = taskManager.deleteTask(deleteId);
                        if (success) {
                            System.out.println("Task deleted successfully!");
                        } else {
                            System.out.println("Task not found! Please check the ID.");
                        }
                    } else {
                        System.out.println("Invalid ID! Please enter a number.");
                        scanner.next(); // Clear invalid input
                    }
                    break;

                case 5:
                    // Exit Program
                    System.out.println("Exiting Task Manager. Goodbye!");
                    running = false;
                    break;

                default:
                    // Invalid choice
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.\n");
                    break;
            }
        }
        
        scanner.close();
    }

    /**
     * Displays the main menu options to the user.
     */
    private static void displayMenu() {
        System.out.println("===== MAIN MENU =====");
        System.out.println("1. Add Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit Program");
        System.out.println("=====================");
    }
}