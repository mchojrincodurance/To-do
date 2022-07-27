package feature;

import com.codurance.todo.Console;
import com.codurance.todo.TaskListImplementation;
import com.codurance.todo.TaskRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


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

    @ParameterizedTest
    @CsvSource(
            {
                    "Buy milk,Feed the dog,Boil eggs",
                    "Buy milk,Boil eggs,Feed the dog",
            }
    )
    public void print_all_tasks(String firstTask, String secondTask, String thirdTask) {
        taskList = new TaskListImplementation(new TaskRepository(), console );

        // Scenario setup
        taskList.addTask(firstTask);
        taskList.addTask(secondTask);
        taskList.addTask(thirdTask);
        taskList.completeTask(secondTask);

        // Trigger
        taskList.showTasks();

        // Side effect I want to test
        verify(console).printLine("Task            | Completed");
        verify(console).printLine(firstTask + "|");
        verify(console).printLine(secondTask + "|x");
        verify(console).printLine(thirdTask + "|");
    }
}
