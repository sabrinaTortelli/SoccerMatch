package TestsJUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import players.Attacker;
import players.PlayersType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AttackerTest {

    Attacker at1 = new Attacker("Matheus", LocalDate.parse("2001-02-22"), PlayersType.ATTACKER1, 90, 95);
    Attacker at2 = new Attacker("José", LocalDate.parse("2000-12-23"), PlayersType.ATTACKER2, 93, 88);

    @Test
    @DisplayName("Get player's shirt number - Attacker 1")
    void getShirtNumberAt1() {
        assertEquals(9, at1.getShirtNumber());
    }

    @Test
    @DisplayName("Get player's shirt number - Attacker 2")
    void getShirtNumberAt2() {
        assertEquals(10, at2.getShirtNumber());
    }

    @Test
    @DisplayName("Get player's technique value - Attacker 1")
    void getTechniqueAt1() {
        assertEquals(95, at1.getTechnique());
    }

    @Test
    @DisplayName("Get player's technique value - Attacker 2")
    void getTechniqueAt2() {
        assertEquals(88, at2.getTechnique());
    }

    @Test
    @DisplayName("Get player's speed - Attacker 1")
    void getVelocityAt1() {
        assertEquals(90, at1.getVelocity());
    }

    @Test
    @DisplayName("Get player's speed - Attacker 2")
    void getVelocityAt2() {
        assertEquals(93, at2.getVelocity());
    }

    @Test
    @DisplayName("Get player's skill value - Attacker 1")
    void getSkillAt1() {
        BigDecimal technique = BigDecimal.valueOf(at1.getTechnique());
        BigDecimal speed = BigDecimal.valueOf(at1.getVelocity());
        BigDecimal at1Skill = (technique.multiply(BigDecimal.valueOf(0.6))).add(speed.multiply(BigDecimal.valueOf(0.4)))
                .setScale(1, RoundingMode.HALF_EVEN);
        assertEquals(at1.getSkill(), at1Skill);
    }

    @Test
    @DisplayName("Get player's skill value - Attacker 1")
    void getSkillAt2() {
        BigDecimal technique = BigDecimal.valueOf(at2.getTechnique());
        BigDecimal speed = BigDecimal.valueOf(at2.getVelocity());
        BigDecimal at2Skill = (technique.multiply(BigDecimal.valueOf(0.6))).add(speed.multiply(BigDecimal.valueOf(0.4)))
                .setScale(1, RoundingMode.HALF_EVEN);
        assertEquals(at2.getSkill(), at2Skill);
    }
}