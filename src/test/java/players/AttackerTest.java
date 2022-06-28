package players;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AttackerTest {

    Attacker at1;
    Attacker at2;
    Attacker at3;
    BigDecimal inferiorLimit;
    BigDecimal upperLimit;

    @BeforeEach
    void initAttackers(){
        at1 = new Attacker("Matheus", LocalDate.parse("2001-02-22"), PlayersType.ATTACKER1, 90, 95);
        at2 = new Attacker("José", LocalDate.parse("2000-12-23"), PlayersType.ATTACKER2, 93, 88);
        inferiorLimit = new BigDecimal(-1);
        upperLimit = new BigDecimal(101);
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Inválidos
    @Test()
    @DisplayName("Get exception with null name")
    void testNameNull() {
        try {
            at3 = new Attacker(null, LocalDate.parse("2000-12-23"), PlayersType.ATTACKER2, 93, 60);
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
            at3 = new Attacker("", LocalDate.parse("2000-12-23"), PlayersType.ATTACKER2, 93, 60);
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
            at3 = new Attacker("José", null, PlayersType.ATTACKER2, 93, -1);
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Arguments must not be null", e.getMessage());
        }
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Válidos
    @Test
    @DisplayName("Get player's shirt number")
    void getShirtNumber() {
        assertEquals(9, at1.getShirtNumber());
        assertEquals(10, at2.getShirtNumber());
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Válidos
    @Test
    @DisplayName("Get player's age")
    void getPlayerAge() {
        assertEquals(21, at1.getAge());
        assertEquals(21, at2.getAge());
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Válidos
    @Test
    @DisplayName("Get player's technique value")
    void getTechnique() {
        assertEquals(95, at1.getTechnique());
        assertEquals(88, at2.getTechnique());
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Inválidos
    @Test()
    @DisplayName("Get exception with invalid Technique")
    void testTechniqueInvalid1() {
        try {
            at3 = new Attacker("João", LocalDate.parse("2000-12-23"), PlayersType.ATTACKER2, 93, -1);
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid arguments", e.getMessage());
        }
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Inválidos
    @Test()
    @DisplayName("Get exception with invalid Technique")
    void testTechniqueInvalid2() {
        try {
            at3 = new Attacker("João", LocalDate.parse("2000-12-23"), PlayersType.ATTACKER2, 93, 101);
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid arguments", e.getMessage());
        }
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Válidos
    @Test
    @DisplayName("Get player's speed")
    void getVelocity() {
        assertEquals(90, at1.getVelocity());
        assertEquals(93, at2.getVelocity());
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Inválidos
    @Test()
    @DisplayName("Get exception with invalid velocity")
    void testVelocityInvalid1() {
        try {
            at3 = new Attacker("João", LocalDate.parse("2000-12-23"), PlayersType.ATTACKER2, -1, 50);
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid arguments", e.getMessage());
        }
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Inválidos
    @Test()
    @DisplayName("Get exception with invalid velocity")
    void testVelocityInvalid2() {
        try {
            at3 = new Attacker("João", LocalDate.parse("2000-12-23"), PlayersType.ATTACKER2, 101, 50);
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid arguments", e.getMessage());
        }
    }

    //Teste Funcional
    //Técnica Utilizada: Análise do Valor Limite
    @Test
    @DisplayName("Get player's skill value")
    void getSkillAt() {
        assertAll("skill value",
                () -> assertEquals(1, at1.getSkill().compareTo(inferiorLimit)),
                () -> assertEquals(-1, at1.getSkill().compareTo(upperLimit)),
                () -> assertEquals(1, at2.getSkill().compareTo(inferiorLimit)),
                () -> assertEquals(-1, at2.getSkill().compareTo(upperLimit))
        );
    }
}