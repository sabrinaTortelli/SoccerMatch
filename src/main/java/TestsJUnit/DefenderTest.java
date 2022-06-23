package TestsJUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import players.Defender;
import players.PlayersType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DefenderTest {

    Defender def1 = new Defender("Matheus", LocalDate.parse("2001-02-22"), PlayersType.DEFENDER1, 91, 95);
    Defender def2 = new Defender("José", LocalDate.parse("2000-12-23"), PlayersType.DEFENDER2, 97, 98);

    @Test
    @DisplayName("Get player's shirt number - Defender 1")
    void getShirtNumberAt1() {
        assertEquals(5, def1.getShirtNumber());
    }

    @Test
    @DisplayName("Get player's shirt number - Defender 2")
    void getShirtNumberAt2() {
        assertEquals(6, def2.getShirtNumber());
    }

    @Test
    @DisplayName("Get player's cover value - Defender 1")
    void getCoverDef1() {
        assertEquals(91, def1.getCover());
    }

    @Test
    @DisplayName("Get player's cover value - Defender 2")
    void getCoverDef2() {
        assertEquals(97, def2.getCover());
    }

    @Test
    @DisplayName("Get player's disarm value - Defender 1")
    void getDisarmDef1() {
        assertEquals(95, def1.getDisarm());
    }

    @Test
    @DisplayName("Get player's disarm value - Defender 2")
    void getDisarmDef2() {
        assertEquals(98, def2.getDisarm());
    }

    @Test
    @DisplayName("Get player's skill value - Defender 1")
    void getSkillDef1() {
        BigDecimal cover = BigDecimal.valueOf(def1.getCover());
        BigDecimal disarm = BigDecimal.valueOf(def1.getDisarm());
        BigDecimal def1Skill = (cover.multiply(BigDecimal.valueOf(0.6))).add(disarm.multiply(BigDecimal.valueOf(0.4)))
                .setScale(1, RoundingMode.HALF_EVEN);
        assertEquals(def1.getSkill(), def1Skill);
    }

    @Test
    @DisplayName("Get player's skill value - Defender 2")
    void getSkillDef2() {
        BigDecimal cover = BigDecimal.valueOf(def2.getCover());
        BigDecimal disarm = BigDecimal.valueOf(def2.getDisarm());
        BigDecimal def2Skill = (cover.multiply(BigDecimal.valueOf(0.6))).add(disarm.multiply(BigDecimal.valueOf(0.4)))
                .setScale(1, RoundingMode.HALF_EVEN);
        assertEquals(def2.getSkill(), def2Skill);
    }
}