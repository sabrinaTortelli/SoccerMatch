package comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import team.Team;

import static org.junit.jupiter.api.Assertions.*;

class CompareVictoryTest {
    private CompareVictory comp;
    private Team t1;
    private Team t2;

    @BeforeEach
    void initTeams(){
        t1 = new Team("teamOne");
        t2 = new Team("teamTwo");
        comp = new CompareVictory();
    }

    /**
     * Teste Funcional
     * Técnica Utilizada: Partição de Equivalência - Valores Válidos
     */
    @Test
    void teamOneHasMoreVictories(){
        t1.setTotalVictory(4);
        t2.setTotalVictory(1);
        assertEquals(1, comp.compare(t1,t2));
    }

    /**
     * Teste Funcional
     * Técnica Utilizada: Partição de Equivalência - Valores Válidos
     */
    @Test
    void teamTwoHasMoreVictories(){
        t1.setTotalVictory(4);
        t2.setTotalVictory(8);
        assertEquals(-1, comp.compare(t1,t2));
    }

    /**
     * Teste Funcional
     * Técnica Utilizada: Partição de Equivalência - Valores Válidos
     */
    @Test
    void victory(){
        t1.setTotalVictory(0);
        t2.setTotalVictory(0);
        assertEquals(0, comp.compare(t1,t2));
    }

    /**
     * Teste Funcional
     * Técnica Utilizada: Partição de Equivalência - Valores Inválidos
     */
    @Test()
    @DisplayName("Get exception with negative number")
    void negativeShouldReturnIllegalArgumentException() {
        try {
            t2.setTotalVictory(-1);
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Number must not be negative", e.getMessage());
        }
    }

}