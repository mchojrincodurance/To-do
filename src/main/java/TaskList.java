public interface TaskList {
    void addTask(String description);

    void completeTask(TaskId id);

    void showTasks();
}
