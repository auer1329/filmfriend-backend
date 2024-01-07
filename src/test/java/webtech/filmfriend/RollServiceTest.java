package webtech.filmfriend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class RollServiceTest {

    @Autowired
    RollService service;

    @MockBean
    RollRepo repo;

    @Test
    void getAllRolls() {
        var roll1 = new Roll(10L, null);
        roll1.setNotes("roll1");
        var roll2 = new Roll(20L, null);
        roll2.setNotes("roll2");
        doReturn(List.of(roll1, roll2)).when(repo).findAll();

        Iterable<Roll> actual = service.getAllRolls();
        assertEquals(actual.iterator().next().getNotes(), "roll1");
    }
}