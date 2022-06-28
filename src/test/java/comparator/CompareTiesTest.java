package comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import team.Team;

import static org.junit.jupiter.api.Assertions.*;

class CompareTiesTest {
    private CompareTies comp;
    private Team t1;
    private Team t2;

    @BeforeEach
    void initTeams(){
        t1 = new Team("teamOne");
        t2 = new Team("teamTwo");
        comp = new CompareTies();
    }

    //Teste Funcional
    @Test
    void teamOneHasMoreTies(){
        t1.setTotalTie(4);
        t2.setTotalTie(1);
        assertEquals(1, comp.compare(t1,t2));
    }

    //Teste Funcional
    @Test
    void teamTwoHasMoreTies(){
        t1.setTotalTie(4);
        t2.setTotalTie(8);
        assertEquals(-1, comp.compare(t1,t2));
    }

    //Teste Funcional
    @Test
    void tie(){
        t1.setTotalTie(0);
        t2.setTotalTie(0);
        assertEquals(0, comp.compare(t1,t2));
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Inválidos
    @Test()
    @DisplayName("Get exception with negative number")
    void negativeShouldReturnIllegalArgumentException() {
        try {
            t1.setTotalTie(0);
            t2.setTotalTie(-1);
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Number must not be negative", e.getMessage());
        }
    }
}