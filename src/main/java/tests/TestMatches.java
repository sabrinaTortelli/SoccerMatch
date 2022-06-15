package tests;

import matches.Match;
import team.Team;
import players.*;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Classe de teste da partida de futebol
 */
public class TestMatches {

    private Goalkeeper goalA;
    private Attacker attackerA1;
    private Attacker attackerA2;
    private Defender defenderA1;
    private Defender defenderA2;
    private Goalkeeper goalB;
    private Attacker attackerB1;
    private Attacker attackerB2;
    private Defender defenderB1;
    private Defender defenderB2;
    private Defender defenderB3;
    private Goalkeeper goalC;
    private Attacker attackerC1;
    private Attacker attackerC2;
    private Defender defenderC1;
    private Defender defenderC2;
    private LocalDate dateOfBirth;
    private Team team1;
    private Team team2;
    private Team team3;
    private ArrayList<SoccerPlayer> t1;
    private ArrayList<SoccerPlayer> t2;
    private ArrayList<SoccerPlayer> t3;
    private Match match;
    private Match match2;
    private Match match3;
    private LocalDate dateOfMatch;
    private ArrayList<Team> teams;
    private ArrayList<Team> teamMatches;
    private ArrayList<Team> teamMatches2;
    private ArrayList<Team> teamMatches3;

    /**
     * Inicia jogadores
     */
    private void iniSoccerPlayers(){

        dateOfBirth = LocalDate.parse("1996-07-25");
        goalA = new Goalkeeper("Fabiana", dateOfBirth, PlayersType.GOALKEEPER, 205, 90);
        dateOfBirth = LocalDate.parse("1975-06-28");
        attackerA1 = new Attacker("Jussara", dateOfBirth, PlayersType.ATTACKER1, 95,86);
        dateOfBirth = LocalDate.parse("1987-07-08");
        defenderA1 = new Defender("Giovana", dateOfBirth, PlayersType.DEFENDER1, 69, 90);
        dateOfBirth = LocalDate.parse("2003-01-30");
        attackerA2 = new Attacker("Gabriela", dateOfBirth, PlayersType.ATTACKER2, 75,62);
        dateOfBirth = LocalDate.parse("1995-05-14");
        defenderA2 = new Defender("Leandra", dateOfBirth, PlayersType.DEFENDER2, 74, 85);

        dateOfBirth = LocalDate.parse("1994-08-03");
        goalB = new Goalkeeper("Lucrecia", dateOfBirth, PlayersType.GOALKEEPER, 183, 67);
        dateOfBirth = LocalDate.parse("1991-04-15");
        attackerB1 = new Attacker("Fernanda", dateOfBirth, PlayersType.ATTACKER1, 98,74);
        dateOfBirth = LocalDate.parse("1990-12-03");
        defenderB1 = new Defender("Marta", dateOfBirth, PlayersType.DEFENDER1, 82, 67);
        dateOfBirth = LocalDate.parse("2001-03-10");
        attackerB2 = new Attacker("Ingrid", dateOfBirth, PlayersType.ATTACKER2, 98,63);
        dateOfBirth = LocalDate.parse("1975-02-26");
        defenderB2 = new Defender("Griselda", dateOfBirth, PlayersType.DEFENDER2, 82, 100);

        dateOfBirth = LocalDate.parse("1975-02-26");
        defenderB3 = new Defender("Geraldine", dateOfBirth, PlayersType.DEFENDER2, 78, 98);

        dateOfBirth = LocalDate.parse("1997-06-25");
        goalC = new Goalkeeper("Janaina", dateOfBirth, PlayersType.GOALKEEPER, 213, 78);
        dateOfBirth = LocalDate.parse("1995-07-13");
        attackerC1 = new Attacker("Roberta", dateOfBirth, PlayersType.ATTACKER1, 84,95);
        dateOfBirth = LocalDate.parse("1984-08-03");
        defenderC1 = new Defender("Judithe", dateOfBirth, PlayersType.DEFENDER1, 88, 81);
        dateOfBirth = LocalDate.parse("1986-02-05");
        attackerC2 = new Attacker("Renata", dateOfBirth, PlayersType.ATTACKER2, 100,74);
        dateOfBirth = LocalDate.parse("1992-02-26");
        defenderC2 = new Defender("Nazaré", dateOfBirth, PlayersType.DEFENDER2, 93, 75);

    }

    /**
     * Adiciona jogadores em um time
     */
    private void addPlayers(){
        team1 = new Team("Barcelona Team");
        t1 = new ArrayList<>();
        team1.addPlayers(t1, goalA);
        team1.addPlayers(t1, attackerA1);
        team1.addPlayers(t1, attackerA2);
        team1.addPlayers(t1, defenderA1);
        team1.addPlayers(t1, defenderA2);
        team1.showTeam(t1, team1);
        team1.setSoccerTeam(t1);

        team2 = new Team("Real Madrid Team");
        t2 = new ArrayList<>();
        team2.addPlayers(t2, goalB);
        team2.addPlayers(t2, attackerB1);
        team2.addPlayers(t2, attackerB2);
        team2.addPlayers(t2, defenderB1);
        team2.addPlayers(t2, defenderB2);
        team2.showTeam(t2, team2);
        team2.setSoccerTeam(t2);

        team3 = new Team("Manchester United Team");
        t3 = new ArrayList<>();
        team3.addPlayers(t3, goalC);
        team3.addPlayers(t3, attackerC1);
        team3.addPlayers(t3, attackerC2);
        team3.addPlayers(t3, defenderC1);
        team3.addPlayers(t3, defenderC2);
        team3.showTeam(t3, team3);
        team3.setSoccerTeam(t3);
    }

    /**
     * Remove jogadores de um time
     */
    private void removerPlayer(){
        team2.showTeam(t2, team2);

        team2.removePlayers(t2, "Griselda");
        team2.showTeam(t2, team2);

        team2.addPlayers(t2, defenderB3);
        team2.showTeam(t2, team2);
    }

    /**
     * Seta as habilidades dos times
     */
    private void setSkills(){
        dateOfMatch = LocalDate.parse("2020-05-20");
        match = new Match(dateOfMatch);
        teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);

        team1.setTeamSkill(t1);
        team2.setTeamSkill(t2);
        team3.setTeamSkill(t3);

        match.showListTeams(teams);

        System.out.println("*******************");

    }

    /**
     * Simulação da partida
     */
    private void matchSimulation(){
        teamMatches = new ArrayList<>();
        match.addMatchTeams(team1, team2, teamMatches);
        match.setTypeOfTeams(teamMatches);
        match.showListMatches(teamMatches);
        match.simulation(teamMatches);
        match.showScoreboard(teamMatches);
        match.showTeamStatistics(teamMatches);
        match.showTeamPlayersStatistics(teamMatches);

        dateOfMatch = LocalDate.parse("2020-05-24");
        match2 = new Match(dateOfMatch);
        teamMatches2 = new ArrayList<>();
        match2.addMatchTeams(team2, team3, teamMatches2);
        match2.setTypeOfTeams(teamMatches2);
        match2.showListMatches(teamMatches2);
        match2.simulation(teamMatches2);
        match2.showScoreboard(teamMatches2);
        match2.showTeamStatistics(teamMatches2);
        match2.showTeamPlayersStatistics(teamMatches2);

        dateOfMatch = LocalDate.parse("2020-05-27");
        match3 = new Match(dateOfMatch);
        teamMatches3 = new ArrayList<>();
        match3.addMatchTeams(team3, team1, teamMatches3);
        match3.setTypeOfTeams(teamMatches3);
        match3.showListMatches(teamMatches3);
        match3.simulation(teamMatches3);
        match3.showScoreboard(teamMatches3);
        match3.showTeamStatistics(teamMatches3);
        match3.showTeamPlayersStatistics(teamMatches3);
    }

    /**
     * Compara as estatísticas
     */
    private void testCompareStatistics(){
        match.compareStatistics(teams, "skills");
        match.compareStatistics(teams, "points");
        match.compareStatistics(teams, "victories");
        match.compareStatistics(teams, "ties");
        match.compareStatistics(teams, "goals");
    }

    public static void main(String[] args) {
        TestMatches test = new TestMatches();
        test.iniSoccerPlayers();
        test.addPlayers();
        test.removerPlayer();
        test.setSkills();
        test.matchSimulation();
        test.testCompareStatistics();
    }
}
