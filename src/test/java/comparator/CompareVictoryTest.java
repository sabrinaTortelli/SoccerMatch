package comparator;

import comparator.CompareVictory;
import org.junit.jupiter.api.Test;
import team.Team;

import static org.junit.jupiter.api.Assertions.*;

class CompareVictoryTest {
    private CompareVictory comp = new CompareVictory();
    private Team t1 = new Team("teamOne");
    private Team t2 = new Team("teamTwo");

    @Test
    void teamOneHasMoreVictories(){
        t1.setTotalVictory(4);
        t2.setTotalVictory(1);
        assertEquals(1, comp.compare(t1,t2));
    }
    @Test
    void teamTwoHasMoreVictories(){
        t1.setTotalVictory(4);
        t2.setTotalVictory(8);
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