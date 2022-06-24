package comparator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import team.Team;

import static org.junit.jupiter.api.Assertions.*;

class CompareGoalsTest {
    private Team t1 = new Team("teamOne");
    private Team  t2 = new Team("teamTwo");
    private CompareGoals comp = new CompareGoals();

    @Test
    void teamOneHasMoreGoals(){
        t1.setTotalGoalTeam(4);
        t2.setTotalGoalTeam(1);
        assertEquals(1, comp.compare(t1,t2));
    }
    @Test
    void teamTwoHasMoreGoals(){
        t1.setTotalGoalTeam(4);
        t2.setTotalGoalTeam(8);
        assertEquals(-1, comp.compare(t1,t2));
    }
    @Test
    void tie(){
        t1.setTotalGoalTeam(0);
        t2.setTotalGoalTeam(0);
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