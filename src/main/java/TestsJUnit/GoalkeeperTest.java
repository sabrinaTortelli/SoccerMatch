package TestsJUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import players.Goalkeeper;
import players.PlayersType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GoalkeeperTest {


    Goalkeeper gk = new Goalkeeper("Matheus", LocalDate.parse("2001-02-22"), PlayersType.GOALKEEPER, 180, 95);

    @Test
    @DisplayName("Get player's shirt number")
    void getShirtNumber() {
        assertEquals(1, gk.getShirtNumber());
    }

    @Test
    @DisplayName("Get player's name")
    void getHeight() {
        assertEquals("Matheus", gk.getNamePlayer());
    }

    @Test
    @DisplayName("Get player's reflex")
    void getReflex() {
        assertEquals(95, gk.getReflex());
    }

    @Test
    @DisplayName("Get player's skill")
    void getSkill() {
        //TO-DO
        BigDecimal height = gk.getHeight();
        BigDecimal reflex = BigDecimal.valueOf(gk.getReflex());
        BigDecimal gkSkill = (height.multiply(BigDecimal.valueOf(0.4))).add(reflex.multiply(BigDecimal.valueOf(0.6)))
                .setScale(1, RoundingMode.HALF_EVEN);
        assertEquals(gk.getSkill(), gkSkill);
    }

}