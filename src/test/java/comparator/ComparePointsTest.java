package comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import team.Team;

import static org.junit.jupiter.api.Assertions.*;

class ComparePointsTest {
    Team t1;
    Team  t2;
    ComparePoints comp;

    @BeforeEach
    void initTeams(){
        t1 = new Team("teamOne");
        t2 = new Team("teamTwo");
        comp = new ComparePoints();
    }

    @Test
    void teamOneHasMorePoints(){
        t1.setTotalPoints(4);
        t2.setTotalPoints(1);
        assertEquals(1, comp.compare(t1,t2));
    }
    @Test
    //esta quebrando, metodo retorn 0 ao inves de -1
    void teamTwoHasMorePoints(){
        t1.setTotalPoints(3);
        t2.setTotalPoints(8);
        assertEquals(-1, comp.compare(t1,t2));
    }
    @Test
    void tie(){
        t1.setTotalPoints(0);
        t2.setTotalPoints(0);
        assertEquals(0, comp.compare(t1,t2));
    }

    //Técnica Utilizada: Partição de Equivalência - Valores Inválidos
    @Test()
    @DisplayName("Get exception with negative points")
    void negativeShouldReturnIllegalArgumentException() {
        try {
            t2.setTotalPoints(0);
            t1.setTotalPoints(-1);
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Number must not be negative", e.getMessage());
        }
    }

}