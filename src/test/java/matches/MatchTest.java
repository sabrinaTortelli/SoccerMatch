package matches;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import players.*;
import team.Team;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {

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
    Goalkeeper goalC;
    Attacker attackerC1;
    Attacker attackerC2;
    Defender defenderC1;
    Defender defenderC2;
    Match match;
    Match match2;
    Match match3;

    @BeforeEach
    void initSoccerPlayersAndTeams(){

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

        goalC = new Goalkeeper("Janaina", LocalDate.parse("1997-06-25"), PlayersType.GOALKEEPER, 213, 78);
        attackerC1 = new Attacker("Roberta", LocalDate.parse("1995-07-13"), PlayersType.ATTACKER1, 84,95);
        defenderC1 = new Defender("Judithe", LocalDate.parse("1984-08-03"), PlayersType.DEFENDER1, 88, 81);
        attackerC2 = new Attacker("Renata", LocalDate.parse("1986-02-05"), PlayersType.ATTACKER2, 100,74);
        defenderC2 = new Defender("Nazaré", LocalDate.parse("1992-02-26"), PlayersType.DEFENDER2, 93, 75);

        team1 = new Team("Barcelona Team");
        team1.addPlayers(goalA);
        team1.addPlayers(defenderA1);
        team1.addPlayers(defenderA2);
        team1.addPlayers(attackerA1);
        team1.addPlayers(attackerA2);

        team2 = new Team("Real Madrid Team");
        team2.addPlayers(goalB);
        team2.addPlayers(attackerB1);
        team2.addPlayers(attackerB2);
        team2.addPlayers(defenderB1);
        team2.addPlayers(defenderB2);

        team3 = new Team("Manchester Team");
        team3.addPlayers(goalC);
        team3.addPlayers(attackerC1);
        team3.addPlayers(attackerC2);
        team3.addPlayers(defenderC1);
        team3.addPlayers(defenderC2);
    }


    /**
     * Teste Funcional
     * Técnica Utilizada: Partição de Equivalência - Valores Inválidos
     */
    @Test()
    @DisplayName("Get exception with null date of match")
    void testDateMatchNull() {
        try {
            match = new Match(null);
            fail("Necessita de exceção!");
        } catch (IllegalArgumentException e) {
            assertEquals("Date Match must not be null", e.getMessage());
        }
    }


    /**
     * Teste Funcional
     * Técnica Utilizada: Partição de Equivalência - Valores Válidos e Inválidos
     */
    @Test
    void testAddTeamsInMatch() {
        match = new Match(LocalDate.parse("2020-05-20"));
        assertAll("add team in match",
                () -> assertTrue(match.addMatchTeams(team1)),
                () -> assertTrue(match.addMatchTeams(team2)),
                () -> assertFalse(match.addMatchTeams(team3))
        );
    }


    /**
     * Testa os fluxos da simulação
     * OBS: não foi feito um teste mais preciso, pois na simulação foi trabalho com números randômicos
     */
    @Test
    void testSimulation() {
        match = new Match(LocalDate.parse("2020-05-20"));
        match.addMatchTeams(team1);
        match.addMatchTeams(team2);
        match.setTypeOfTeams();
        match.showListMatches();
        match.simulation();
        match.showScoreboard();
        match.showTeamStatistics();
        match.showTeamPlayersStatistics();

        match2 = new Match(LocalDate.parse("2020-05-24"));
        match2.addMatchTeams(team2);
        match2.addMatchTeams(team3);
        match2.setTypeOfTeams();
        match2.showListMatches();
        match2.simulation();
        match2.showScoreboard();
        match2.showTeamStatistics();
        match2.showTeamPlayersStatistics();

        match3 = new Match(LocalDate.parse("2020-05-27"));
        match3.addMatchTeams(team3);
        match3.addMatchTeams(team1);
        match3.setTypeOfTeams();
        match3.showListMatches();
        match3.simulation();
        match3.showScoreboard();
        match3.showTeamStatistics();
        match3.showTeamPlayersStatistics();
    }


    /**
     * Testa as comparações estatísticas da simulação
     * OBS: não foi feito um teste mais preciso, pois na simulação foi trabalho com números randômicos
     */
    @Test
    void testCompareStatistics(){
        testSimulation();
        match.compareStatistics("skills");
        match.compareStatistics("points");
        match.compareStatistics("victories");
        match.compareStatistics("ties");
        match.compareStatistics("goals");

        match2.compareStatistics("skills");
        match2.compareStatistics("points");
        match2.compareStatistics("victories");
        match2.compareStatistics("ties");
        match2.compareStatistics("goals");

        match3.compareStatistics("skills");
        match3.compareStatistics("points");
        match3.compareStatistics("victories");
        match3.compareStatistics("ties");
        match3.compareStatistics("goals");
    }
}
