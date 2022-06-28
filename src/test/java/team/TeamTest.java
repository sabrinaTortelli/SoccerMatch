package team;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import players.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    Team teamTest;
    Team team1;
    Team team2;
    Team team3;
    Goalkeeper goalA;
    Attacker attackerA1;
    Attacker attackerA2;
    Defender defenderA1;
    Defender defenderA2;
    Goalkeeper goalB;
    Attacker attackerB1;
    Attacker attackerB2;
    Defender defenderB1;
    Defender defenderB2;
    Defender defenderB3;
    Goalkeeper goalC;
    Attacker attackerC1;
    Attacker attackerC2;
    Defender defenderC1;
    Defender defenderC2;

    @BeforeEach
    void initSoccerPlayers(){
        teamTest = new Team("Brasil");

        goalA = new Goalkeeper("Fabiana", LocalDate.parse("1996-07-25"), PlayersType.GOALKEEPER, 205, 90);
        attackerA1 = new Attacker("Jussara", LocalDate.parse("1975-06-28"), PlayersType.ATTACKER1, 95,86);
        defenderA1 = new Defender("Giovana", LocalDate.parse("1987-07-08"), PlayersType.DEFENDER1, 69, 90);
        attackerA2 = new Attacker("Gabriela", LocalDate.parse("2003-01-30"), PlayersType.ATTACKER2, 75,62);
        defenderA2 = new Defender("Leandra", LocalDate.parse("1995-05-14"), PlayersType.DEFENDER2, 74, 85);

        goalB = new Goalkeeper("Lucrecia", LocalDate.parse("1994-08-03"), PlayersType.GOALKEEPER, 183, 67);
        attackerB1 = new Attacker("Fernanda", LocalDate.parse("1991-04-15"), PlayersType.ATTACKER1, 98,74);
        defenderB1 = new Defender("Marta", LocalDate.parse("1990-12-03"), PlayersType.DEFENDER1, 82, 67);
        attackerB2 = new Attacker("Ingrid", LocalDate.parse("2001-03-10"), PlayersType.ATTACKER2, 98,63);
        defenderB2 = new Defender("Griselda", LocalDate.parse("1975-02-26"), PlayersType.DEFENDER2, 82, 100);

        defenderB3 = new Defender("Geraldine", LocalDate.parse("1975-02-26"), PlayersType.DEFENDER2, 78, 98);

        goalC = new Goalkeeper("Janaina", LocalDate.parse("1997-06-25"), PlayersType.GOALKEEPER, 213, 78);
        attackerC1 = new Attacker("Roberta", LocalDate.parse("1995-07-13"), PlayersType.ATTACKER1, 84,95);
        defenderC1 = new Defender("Judithe", LocalDate.parse("1984-08-03"), PlayersType.DEFENDER1, 88, 81);
        attackerC2 = new Attacker("Renata", LocalDate.parse("1986-02-05"), PlayersType.ATTACKER2, 100,74);
        defenderC2 = new Defender("Nazaré", LocalDate.parse("1992-02-26"), PlayersType.DEFENDER2, 93, 75);
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Inválidos
    @Test()
    @DisplayName("Get exception with null name")
    void testNameNull() {
        try {
            teamTest = new Team(null);
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Name must not be null or empty", e.getMessage());
        }
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Inválidos
    @Test()
    @DisplayName("Get exception with empty name")
    void testEmptyName() {
        try {
            teamTest = new Team("");
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Name must not be null or empty", e.getMessage());
        }
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Válidos
    @Test
    @DisplayName("Add players at the team")
    void testAddPlayers() {
        team1 = new Team("Barcelona Team");
        assertAll("add team 1",
                () -> assertTrue(team1.addPlayers(goalA)),
                () -> assertTrue(team1.addPlayers(attackerA1)),
                () -> assertTrue(team1.addPlayers(attackerA2)),
                () -> assertTrue(team1.addPlayers(defenderA1)),
                () -> assertTrue(team1.addPlayers(defenderA2))
        );
        team1.showTeam();

        team2 = new Team("Real Madrid Team");
        assertAll("add team 2",
                () -> assertTrue(team2.addPlayers(goalB)),
                () -> assertTrue(team2.addPlayers(attackerB1)),
                () -> assertTrue(team2.addPlayers(attackerB2)),
                () -> assertTrue(team2.addPlayers(defenderB1)),
                () -> assertTrue(team2.addPlayers(defenderB2))
        );
        team2.showTeam();

        team3 = new Team("Manchester United Team");
        assertAll("add team 3",
                () -> assertTrue(team3.addPlayers(goalC)),
                () -> assertTrue(team3.addPlayers(attackerC1)),
                () -> assertTrue(team3.addPlayers(attackerC2)),
                () -> assertTrue(team3.addPlayers(defenderC1)),
                () -> assertTrue(team3.addPlayers(defenderC2)),
                () -> assertFalse(team3.addPlayers(defenderB3))
        );
        team3.showTeam();
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Válidos
    @Test
    @DisplayName("Remove players at the team")
    void testRemovePlayers() {
        testAddPlayers();
        assertAll("remove players at team 2",
                () -> assertTrue(team2.removePlayers("Griselda")),
                () -> assertFalse(team2.removePlayers("Sabrina"))
        );
    }

    //Teste Funcional
    //Técnica Utilizada: Partição de Equivalência - Valores Válidos
    @Test
    @DisplayName("Set skills team")
    void testSetSkillsTeam() {
        testAddPlayers();
        team1.setTeamSkill();
        team2.setTeamSkill();
        team3.setTeamSkill();
        assertAll("set skills team",
                () -> assertEquals(goalA.getSkill().add(attackerA1.getSkill().add(attackerA2.getSkill()
                                .add(defenderA1.getSkill().add(defenderA2.getSkill())))), team1.getSkillTeams()),
                () -> assertEquals(goalB.getSkill().add(attackerB1.getSkill().add(attackerB2.getSkill()
                        .add(defenderB1.getSkill().add(defenderB2.getSkill())))), team2.getSkillTeams()),
                () -> assertEquals(goalC.getSkill().add(attackerC1.getSkill().add(attackerC2.getSkill()
                        .add(defenderC1.getSkill().add(defenderC2.getSkill())))), team3.getSkillTeams())
        );
    }
}
