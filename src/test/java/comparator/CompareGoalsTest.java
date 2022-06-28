package comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import team.Team;


import static org.junit.jupiter.api.Assertions.*;

class CompareGoalsTest {
    Team t1;
    Team  t2;
    CompareGoals comp;

    @BeforeEach
    void initTeams(){
        t1 = new Team("teamOne");
        t2 = new Team("teamTwo");
        comp = new CompareGoals();
    }

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

    //Técnica Utilizada: Partição de Equivalência - Valores Inválidos
    @Test()
    @DisplayName("Get exception with negative goals")
    void negativeShouldReturnIllegalArgumentException() {
        try {
            t2.setTotalGoalTeam(0);
            t1.setTotalGoalTeam(-1);
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Number must not be negative", e.getMessage());
        }
    }

}