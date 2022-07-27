package feature;

import com.codurance.todo.TaskListImplementation;
import com.codurance.todo.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import com.codurance.todo.Console;


//Given I have an empty task list
//        And I add a new task "Buy milk"
//        When I print my task list
//        Then I see:
//
//        Task            | Completed
//        Buy milk        |
//
//        ====
//
//        Given I have a task list containing a task "Buy milk"
//        And another task "Feed the dog"
//        And another task "Boil eggs"
//        And I check the task "Feed the dog"
//        When I print my task list
//        Then I see:
//
//        Task            | Completed
//        Buy milk        |
//        Feed the dog    |   x
//        Boil eggs       |
//
//        ====
//

@ExtendWith(MockitoExtension.class)
public class PrintTaskList {

    @Mock
    Console console;
    private TaskListImplementation taskList;

    @Test
    public void print_all_tasks() {
        taskList = new TaskListImplementation(new TaskRepository(), console );

        // Scenario setup
        taskList.addTask("Buy milk");
        taskList.addTask("Feed the dog");
        taskList.addTask("Boil eggs");
        taskList.completeTask("Feed the dog");

        // Trigger
        taskList.showTasks();

        // Side effect I want to test
        verify(console).printLine("Task            | Completed");
        verify(console).printLine("Buy milk        |");
        verify(console).printLine("Feed the dog    |   x");
        verify(console).printLine("Boil eggs       |");
    }
}
