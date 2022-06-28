package players;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GoalkeeperTest {

    Goalkeeper gk;
    Goalkeeper gk1;
    Goalkeeper gk2;
    Goalkeeper gk3;
    Goalkeeper gk4;
    BigDecimal inferiorLimit;
    BigDecimal upperLimit;

    @BeforeEach
    void initGoalKeppers(){
        gk = new Goalkeeper("Matheus", LocalDate.parse("2001-02-22"), PlayersType.GOALKEEPER, 181, 95);
        gk1 = new Goalkeeper("Caio", LocalDate.parse("1999-02-08"), PlayersType.GOALKEEPER, 210, 95);
        gk2 = new Goalkeeper("Paula", LocalDate.parse("1986-02-05"), PlayersType.GOALKEEPER, 215, 95);
        gk3 = new Goalkeeper("Maria", LocalDate.parse("1987-07-08"), PlayersType.GOALKEEPER, 0, 95);
        inferiorLimit = new BigDecimal(-1);
        upperLimit = new BigDecimal(101);
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Inválidos
    @Test()
    @DisplayName("Get exception with null name")
    void testNameNull() {
        try {
            gk4 = new Goalkeeper(null, LocalDate.parse("2005-02-17"), PlayersType.GOALKEEPER, 20, 95);
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
            gk4 = new Goalkeeper("", LocalDate.parse("2005-02-17"), PlayersType.GOALKEEPER, 20, 95);
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
            gk4 = new Goalkeeper("Felipe", null, PlayersType.GOALKEEPER, 20, 95);
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
                () -> assertEquals(21, gk.getAge()),
                () -> assertEquals(23, gk1.getAge()),
                () -> assertEquals(36, gk2.getAge()),
                () -> assertEquals(34, gk3.getAge())
        );
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Válidos
    @Test
    @DisplayName("Get player's shirt number")
    void getShirtNumber() {
        assertEquals(1, gk.getShirtNumber());
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Válidos
    @Test
    @DisplayName("Get player's name")
    void getSoccerName() {
        assertEquals("Matheus", gk.getNamePlayer());
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Válidos
    @Test
    @DisplayName("Get player's height")
    void getHeight() {
        assertAll("skill value",
                () -> assertEquals(new BigDecimal(86), gk.getHeight()),
                () -> assertEquals(new BigDecimal(100), gk1.getHeight()),
                () -> assertEquals(new BigDecimal(100), gk2.getHeight()),
                () -> assertEquals(new BigDecimal(0), gk3.getHeight())
        );
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Inválidos
    @Test()
    @DisplayName("Get exception with invalid height")
    void testHeightInvalid1() {
        try {
            gk4 = new Goalkeeper("Gi", LocalDate.parse("2005-02-17"), PlayersType.GOALKEEPER, -15, 95);
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid height", e.getMessage());
        }
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Inválidos
    @Test()
    @DisplayName("Get exception with invalid height")
    void testHeightInvalid2() {
        try {
            gk4 = new Goalkeeper("Leo", LocalDate.parse("2002-02-17"), PlayersType.GOALKEEPER, 260, 95);
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid height", e.getMessage());
        }
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Válidos
    @Test
    @DisplayName("Get player's reflex")
    void getReflex() {
        assertEquals(95, gk.getReflex());
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Inválidos
    @Test()
    @DisplayName("Get exception with invalid reflex")
    void testReflexInvalid1() {
        try {
            gk4 = new Goalkeeper("Gi", LocalDate.parse("2005-02-17"), PlayersType.GOALKEEPER, 193, -1);
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid reflex", e.getMessage());
        }
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Inválidos
    @Test()
    @DisplayName("Get exception with invalid reflex")
    void testReflexInvalid2() {
        try {
            gk4 = new Goalkeeper("Gi", LocalDate.parse("2005-02-17"), PlayersType.GOALKEEPER, 193, 101);
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid reflex", e.getMessage());
        }
    }

    //Teste Funcional
    //Técnica Utilizada: Análise do Valor Limite
    @Test
    @DisplayName("Get player's skill")
    void getSkill() {
        assertAll("skill value",
                () -> assertEquals(1, gk.getSkill().compareTo(inferiorLimit)),
                () -> assertEquals(-1, gk.getSkill().compareTo(upperLimit)),
                () -> assertEquals(1, gk1.getSkill().compareTo(inferiorLimit)),
                () -> assertEquals(-1, gk1.getSkill().compareTo(upperLimit)),
                () -> assertEquals(1, gk2.getSkill().compareTo(inferiorLimit)),
                () -> assertEquals(-1, gk2.getSkill().compareTo(upperLimit)),
                () -> assertEquals(1, gk3.getSkill().compareTo(inferiorLimit)),
                () -> assertEquals(-1, gk3.getSkill().compareTo(upperLimit))
        );
    }
}