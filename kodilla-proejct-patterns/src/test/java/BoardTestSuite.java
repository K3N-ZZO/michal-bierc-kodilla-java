import com.kodilla.patterns.prototype.Board;
import com.kodilla.patterns.prototype.Task;
import com.kodilla.patterns.prototype.TasksList;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BoardTestSuite {

    @Test
    public void testToString() {
        //given
        //creating the TaskList for todos
        TasksList listToDo = new TasksList("To Do Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("To Do task number: " + n)));
        //craeting the TaskList for tasks in progress
        TasksList listInProgress = new TasksList("In Progress");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listInProgress.getTasks().add(new Task("In Progress task number: " + n)));
        //creating the TaskList for done tasks
        TasksList listCompleted = new TasksList("Completed");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listCompleted.getTasks().add(new Task("Completed: " + n)));
        //creating board and assinging the lists
        Board board = new Board("Project number 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listCompleted);
        //creating the board and assigning the lists
        Board cloneBoard = null;
        try {
            cloneBoard = board.shallowCopy();
            cloneBoard.setName("Project number 2");
        } catch (CloneNotSupportedException e){
            System.out.println(e);
        }
        //making deepcopy
        Board deepClonedBoard = null;
        try{
            deepClonedBoard = board.deepCopy();
            deepClonedBoard.setName("Project number 3");
        } catch (CloneNotSupportedException e){
            System.out.println(e);
        }
        System.out.println(board);
        System.out.println(cloneBoard);
        System.out.println(deepClonedBoard);
        //When
        board.getLists().remove(listToDo);

        //Then
        assertEquals(2, board.getLists().size());
        assertEquals(2, cloneBoard.getLists().size());
        assertEquals(3, deepClonedBoard.getLists().size());
        assertEquals(cloneBoard.getLists(), board.getLists());
        assertNotEquals(deepClonedBoard.getLists(), board.getLists());

    }
}
