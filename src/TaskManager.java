import java.util.ArrayList;

/**
 * TaskManager class handles all operations related to task management.
 * It uses an ArrayList to store Task objects and provides methods
 * to manipulate the task list.
 */
public class TaskManager {
    // ArrayList to store all tasks
    private ArrayList<Task> tasks;
    private int nextId; // To generate unique IDs for new tasks

    /**
     * Constructor to initialize the TaskManager.
     * Creates an empty task list and sets initial ID to 1.
     */
    public TaskManager() {
        tasks = new ArrayList<>();
        nextId = 1; // Start IDs from 1
    }

    /**
     * Adds a new task to the task list.
     * @param title Description of the task
     */
    public void addTask(String title) {
        // Create new task with unique ID and add to list
        Task newTask = new Task(nextId, title);
        tasks.add(newTask);
        nextId++; // Increment ID for next task
        System.out.println("Task added successfully!");
    }

    /**
     * Displays all tasks in the task list.
     * Shows all tasks with their ID, completion status, and title.
     */
    public void viewAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available. Add some tasks first!");
            return;
        }

        System.out.println("\n=== ALL TASKS ===");
        for (Task task : tasks) {
            System.out.println(task); // Uses toString() method of Task class
        }
        System.out.println("=================\n");
    }

    /**
     * Marks a task as completed based on its ID.
     * @param id The ID of the task to mark as completed
     * @return true if task was found and marked, false otherwise
     */
    public boolean markTaskAsCompleted(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            task.setCompleted(true);
            return true;
        }
        return false;
    }

    /**
     * Deletes a task from the list based on its ID.
     * @param id The ID of the task to delete
     * @return true if task was found and deleted, false otherwise
     */
    public boolean deleteTask(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            tasks.remove(task);
            return true;
        }
        return false;
    }

    /**
     * Helper method to find a task by its ID.
     * @param id The ID to search for
     * @return The Task object if found, null otherwise
     */
    private Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    /**
     * Gets the current number of tasks in the list.
     * @return Number of tasks
     */
    public int getTaskCount() {
        return tasks.size();
    }
}