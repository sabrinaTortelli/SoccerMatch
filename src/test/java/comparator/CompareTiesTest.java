package comparator;

import org.junit.jupiter.api.Test;
import team.Team;

import static org.junit.jupiter.api.Assertions.*;

class CompareTiesTest {
    private CompareTies comp = new CompareTies();
    private Team t1 = new Team("teamOne");
    private Team t2 = new Team("teamTwo");

    @Test
    void teamOneHasMoreTies(){
        t1.setTotalTie(4);
        t2.setTotalTie(1);
        assertEquals(1, comp.compare(t1,t2));
    }
    @Test
    void teamTwoHasMoreTies(){
        t1.setTotalTie(4);
        t2.setTotalTie(8);
        assertEquals(-1, comp.compare(t1,t2));
    }
    @Test
    void tie(){
        t1.setTotalTie(0);
        t2.setTotalTie(0);
        assertEquals(0, comp.compare(t1,t2));
    }

    //quebra porque o programa não joga a exception esperada
    @Test
    void negativeShouldReturnIllegalArgumentException(){
        t1.setTotalGoalTeam(-1);
        t2.setTotalGoalTeam(0);
        assertThrows(IllegalArgumentException.class,
                () -> comp.compare(t1,t2));
    }
}