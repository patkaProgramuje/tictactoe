package model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Mock
    Settings settings;

    @InjectMocks
    Game game;

    @Test
    public void initMethodReturnGameObject() {
        List<User> users = getUsersList();
        Board board = getBoard();
        when(settings.getUsers()).thenReturn(users);
        when(settings.getBoard()).thenReturn(board);
        Game g = game.init(settings);
        assertEquals(g.getBoard().getSize(), 4);
        assertEquals(g.getUsers().get(0).getNick(), "patka");
        assertEquals(g.getUsers().get(1).getNick(), "marcin");
    }

    private Board getBoard() {
        return Board.createBoard(4);
    }

    private List<User> getUsersList() {
        List<User> users = new ArrayList<>();
        User user1 = new User("patka");
        user1.setSign(Sign.RING);
        User user2 = new User("marcin");
        user1.setSign(Sign.CROSS);
        users.add(user1);
        users.add(user2);
        return users;
    }
}