package players;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DefenderTest {

    Defender def1;
    Defender def2;

    Defender def3;

    BigDecimal inferiorLimit;

    BigDecimal upperLimit;
    @BeforeEach
    void initDefenders(){
        def1 = new Defender("Matheus", LocalDate.parse("2005-02-22"), PlayersType.DEFENDER1, 91, 95);
        def2 = new Defender("José", LocalDate.parse("1995-12-23"), PlayersType.DEFENDER2, 97, 98);
        inferiorLimit = new BigDecimal(-1);
        upperLimit = new BigDecimal(101);
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Inválidos
    @Test()
    @DisplayName("Get exception with null name")
    void testNameNull() {
        try {
            def3 = new Defender(null, LocalDate.parse("1978-02-22"), PlayersType.DEFENDER1, 15, 95);
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Arguments must not be null", e.getMessage());
        }
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Inválidos
    @Test()
    @DisplayName("Get exception with empty name")
    void testEmptyName() {
        try {
            def3 = new Defender("", LocalDate.parse("1978-02-22"), PlayersType.DEFENDER1, 15, 95);
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Name must not be empty", e.getMessage());
        }
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Inválidos
    @Test()
    @DisplayName("Get exception with null date of birth")
    void testDateBirthNull() {
        try {
            def3 = new Defender("Pedro", null, PlayersType.DEFENDER1, 15, 95);
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Arguments must not be null", e.getMessage());
        }
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Válidos
    @Test
    @DisplayName("Get player's age")
    void getPlayerAge() {
        assertAll("skill value",
                () -> assertEquals(17, def1.getAge()),
                () -> assertEquals(26, def2.getAge())
        );
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Válidos
    @Test
    @DisplayName("Get player's shirt number")
    void getShirtNumber() {
        assertEquals(5, def1.getShirtNumber());
        assertEquals(6, def2.getShirtNumber());
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Válidos
    @Test
    @DisplayName("Get player's cover value")
    void getCover() {
        assertEquals(91, def1.getCover());
        assertEquals(97, def2.getCover());
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Inválidos
    @Test()
    @DisplayName("Get exception with invalid cover")
    void testCoverInvalid1() {
        try {
            def3 = new Defender("Dunga", LocalDate.parse("1978-02-22"), PlayersType.DEFENDER1, -1, 95);
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid arguments", e.getMessage());
        }
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Inválidos
    @Test()
    @DisplayName("Get exception with invalid cover")
    void testCoverInvalid2() {
        try {
            def3 = new Defender("Dunga", LocalDate.parse("1978-02-22"), PlayersType.DEFENDER1, 101, 95);
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid arguments", e.getMessage());
        }
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Válidos
    @Test
    @DisplayName("Get player's disarm value")
    void getDisarm() {
        assertEquals(95, def1.getDisarm());
        assertEquals(98, def2.getDisarm());
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Inválidos
    @Test()
    @DisplayName("Get exception with invalid disarm")
    void testDisarmInvalid1() {
        try {
            def3 = new Defender("Dunga", LocalDate.parse("1978-02-22"), PlayersType.DEFENDER1, 15, -1);
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid arguments", e.getMessage());
        }
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Inválidos
    @Test()
    @DisplayName("Get exception with invalid disarm")
    void testDisarmInvalid2() {
        try {
            def3 = new Defender("Dunga", LocalDate.parse("1978-02-22"), PlayersType.DEFENDER1, 15, 101);
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid arguments", e.getMessage());
        }
    }

    //Teste Funcional
    //Técnica Utilizada: Análise do Valor Limite
    @Test
    @DisplayName("Get player's skill value")
    void getSkillDef() {
        assertAll("skill value",
                () -> assertEquals(1, def1.getSkill().compareTo(inferiorLimit)),
                () -> assertEquals(-1, def1.getSkill().compareTo(upperLimit)),
                () -> assertEquals(1, def2.getSkill().compareTo(inferiorLimit)),
                () -> assertEquals(-1, def2.getSkill().compareTo(upperLimit))
        );
    }
}