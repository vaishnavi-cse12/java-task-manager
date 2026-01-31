/**
 * Task class representing a single task in the task manager.
 * This class follows encapsulation principles with private fields
 * and public getters/setters.
 */
public class Task {
    // Private fields for encapsulation
    private int id;
    private String title;
    private boolean completed;

    /**
     * Constructor to create a new Task object.
     * @param id Unique identifier for the task
     * @param title Description of the task
     */
    public Task(int id, String title) {
        this.id = id;
        this.title = title;
        this.completed = false; // Default value - task is not completed
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    // Setter methods
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Override toString() method to provide a formatted string representation
     * of the Task object for display purposes.
     * @return Formatted string with task details
     */
    @Override
    public String toString() {
        String status = completed ? "[✓]" : "[ ]";
        return "ID: " + id + " " + status + " " + title;
    }
}