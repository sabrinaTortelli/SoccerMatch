package comparator;

import comparator.ComparePoints;
import org.junit.jupiter.api.Test;
import team.Team;

import static org.junit.jupiter.api.Assertions.*;

class ComparePointsTest {
    private Team t1 = new Team("teamOne");
    private Team  t2 = new Team("teamTwo");
    private ComparePoints comp = new ComparePoints();

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

    //quebra porque o programa não joga a exception esperada
    @Test
    void negativeShouldReturnIllegalArgumentException(){
        t1.setTotalPoints(-1);
        t2.setTotalPoints(0);
        assertThrows(IllegalArgumentException.class,
                () -> comp.compare(t1,t2));
    }

}