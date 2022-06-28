package matches;

import comparator.*;
import players.PlayersType;
import team.Result;
import team.Team;
import team.TeamsType;
import validator.Validator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

/**
 * Classe que implementa os métodos para as partidas dos times de futebol.
 */
public class Match {

    private final LocalDate dateOfMatch;
    private final ArrayList<Team> teamMatches;

    /**
     * Construtor da classe partidas
     * @param dateOfMatch data da partida
     */
    public Match(LocalDate dateOfMatch){
        Validator validator = new Validator();
        validator.validateDateMatch(dateOfMatch);
        this.dateOfMatch = dateOfMatch;
        teamMatches = new ArrayList<>();
    }

    /**
     * @return dia da partida
     */
    public LocalDate getDateOfMatch() {
        return dateOfMatch;
    }

    /**
     * Classifica os os dois times da partida em time da casa e time visitante
     */
    public void setTypeOfTeams() {
        teamMatches.get(0).setTeamsType(TeamsType.HOME);
        teamMatches.get(1).setTeamsType(TeamsType.VISITOR);
    }

    /**
     * Seta os gols do time de acordo com o número randomico sorteado e qual time tem as maiores chances
     * @param result total de gols de um time
     * @param team qual o time está pontuando
     */
    private void setGoalsTeams(int result, int team){
        teamMatches.get(team).setGoalTeam1(result);
        teamMatches.get(team).setTotalGoalTeam(result);
    }

    /**
     * Chama a função de setar os gols do time de acordo com o número randomico sorteado e qual time tem as maiores chances
     * @param number número randômico
     * @param resultMax maior resultado dos gols dos times
     * @param resultMin menor resultado dos gols dos times
     * @param larger indica qual das opções de chances a ser utilizada para o cálculo
     */
    private void setChancesLarger(int number, int resultMax, int resultMin, boolean larger){
        if((larger && number == 0) || (!larger && (number >=0 && number<2))){
            if(teamMatches.get(0).getTeamsType() == TeamsType.VISITOR){
                setGoalsTeams(resultMax,0);
            } else if(teamMatches.get(0).getTeamsType() == TeamsType.HOME){
                setGoalsTeams(resultMin,0);
            } else if(teamMatches.get(1).getTeamsType() == TeamsType.VISITOR){
                setGoalsTeams(resultMax,1);
            } else{
                setGoalsTeams(resultMin,1);
            }
        } else if((larger && number>0) || (!larger && number >=2)){
            if(teamMatches.get(0).getTeamsType() == TeamsType.HOME){
                setGoalsTeams(resultMax,0);
            } else if(teamMatches.get(0).getTeamsType() == TeamsType.VISITOR){
                setGoalsTeams(resultMin,0);
            } else if(teamMatches.get(1).getTeamsType() == TeamsType.HOME){
                setGoalsTeams(resultMax,1);
            } else{
                setGoalsTeams(resultMin,1);
            }
        }
    }

    /**
     * Método que compara as chances dos times. Se o time da casa tem maior habilidade que o time visitante,
     * então o time da casa tem 2x mais chance de ganhar a partida.
     * Se o time visitante tem maior habilidade, então os times tem chances iguais de ganhar a partida
     * @param result1 total de gols de um time
     * @param result2 total de gols de outro time
     */
    private void setChanceTeams(int result1, int result2) {
        BigDecimal chanceHome = new BigDecimal(0);
        BigDecimal chanceVisitor = new BigDecimal(0);
        int resultMax = Math.max(result1, result2);
        int resultMin = Math.min(result1, result2);
        Random random = new Random();
        int number;
        for (Team teamMatch : teamMatches) {
            if (teamMatch.getTeamsType() == TeamsType.HOME) {
                chanceHome = teamMatch.getSkillTeams();
            } else {
                chanceVisitor = teamMatch.getSkillTeams();
            }
        }
        if (chanceHome.compareTo(chanceVisitor) > 0) {
            number = random.nextInt(3);
            setChancesLarger(number, resultMax, resultMin, true);
        } else {
            number = random.nextInt(4);
            setChancesLarger(number, resultMax, resultMin, false);
        }
    }

    private void setChancesDefenderAttacker(int number, int j, boolean chances){
        if(number<2){
            for(int i = 0; i< teamMatches.get(j).getSoccerTeam().size(); i++){
                if((chances && (teamMatches.get(j).getSoccerTeam().get(i).getType() == PlayersType.DEFENDER2)) ||
                        (!chances && (teamMatches.get(j).getSoccerTeam().get(i).getType() == PlayersType.DEFENDER1)) ||
                        (chances && (teamMatches.get(j).getSoccerTeam().get(i).getType() == PlayersType.ATTACKER2)) ||
                        (!chances && (teamMatches.get(j).getSoccerTeam().get(i).getType() == PlayersType.ATTACKER1))) {
                    teamMatches.get(j).getSoccerTeam().get(i).setGoal(1);
                }
            }
        } else{
            for(int i = 0; i< teamMatches.get(j).getSoccerTeam().size(); i++){
                if((chances && (teamMatches.get(j).getSoccerTeam().get(i).getType() == PlayersType.DEFENDER1)) ||
                        (!chances && (teamMatches.get(j).getSoccerTeam().get(i).getType() == PlayersType.DEFENDER2)) ||
                        (chances && (teamMatches.get(j).getSoccerTeam().get(i).getType() == PlayersType.ATTACKER1)) ||
                        (!chances && (teamMatches.get(j).getSoccerTeam().get(i).getType() == PlayersType.ATTACKER2))){
                    teamMatches.get(j).getSoccerTeam().get(i).setGoal(1);
                }
            }
        }
    }

    /**
     * Compara qual dos defensores tem mais chance de fazer um gol.
     * Depende do total das habilidades.
     * Quem tem maior habilidade tem 4x mais chance de fazer gols.
     * @param j índice do time atual a ser comparado
     */
    private void compareDefender(int j) {
        Random random = new Random();
        BigDecimal defender1 = new BigDecimal(0);
        BigDecimal defender2 = new BigDecimal(0);
        for(int i=0; i<teamMatches.get(j).getSoccerTeam().size(); i++){
            if(teamMatches.get(j).getSoccerTeam().get(i).getType() == PlayersType.DEFENDER1){
                defender1 = teamMatches.get(j).getSoccerTeam().get(i).getSkill();
            }
            if(teamMatches.get(j).getSoccerTeam().get(i).getType() == PlayersType.DEFENDER2){
                defender2 = teamMatches.get(j).getSoccerTeam().get(i).getSkill();
            }
        }
        int number2 = random.nextInt(6);
        setChancesDefenderAttacker(number2,j, defender1.compareTo(defender2) > 0);
    }

    /**
     * Compara qual dos atacantes tem mais chance de fazer um gol.
     * Depende do total das habilidades.
     * Quem tem maior habilidade tem 4x mais chance de fazer gols.
     * @param j índice do time atual a ser comparado
     */
    public void compareAttacker(int j){
        Random random = new Random();
        BigDecimal attacker1 = new BigDecimal(0);
        BigDecimal attacker2 = new BigDecimal(0);
        for(int i=0; i<teamMatches.get(j).getSoccerTeam().size(); i++){
            if(teamMatches.get(j).getSoccerTeam().get(i).getType() == PlayersType.ATTACKER1){
                attacker1 = teamMatches.get(j).getSoccerTeam().get(i).getSkill();
            }
            if(teamMatches.get(j).getSoccerTeam().get(i).getType() == PlayersType.ATTACKER2){
                attacker2 = teamMatches.get(j).getSoccerTeam().get(i).getSkill();
            }
        }
        int number2 = random.nextInt(6);
        setChancesDefenderAttacker(number2,j, attacker1.compareTo(attacker2) > 0);
    }

    /**
     * Compara todos os jogadores e calcula quem tem mais chances de fazer o gol.
     * Se for goleiro tem 1x mais chance.
     * Se for defensor tem 3x mais chances.
     * Se for atacante tem 6x mais chances.
     * @param goals total de gols feitos pelo time.
     * @param j índice do time atual para comparação.
     */
    public void comparePlayers(int goals, int j){
        int cont = 0;
        Random random = new Random();
        do {
            int number = random.nextInt(10);
            if (number == 0) {
                for (int i = 0; i < teamMatches.get(j).getSoccerTeam().size(); i++) {
                    if (teamMatches.get(j).getSoccerTeam().get(i).getType() == PlayersType.GOALKEEPER) {
                        teamMatches.get(j).getSoccerTeam().get(i).setGoal(1);
                    }
                }
                cont++;
            }
            if (number >= 1 && number < 4) {
                compareDefender(j);
                cont++;
            }
            if (number >= 4) {
                compareAttacker(j);
                cont++;
            }
        } while(cont<goals);
    }

    /**
     * Simulação de uma partida
     */
    public void simulation(){
        Random random = new Random();
        int result1 = random.nextInt(6);
        random = new Random();
        int result2 = random.nextInt(6);
        if(result1 == result2){
            if(result1 == 0){
                teamMatches.get(0).setTotalPoints(Result.TIE.getPoints());
                teamMatches.get(0).setTotalTie(1);
                teamMatches.get(1).setTotalPoints(Result.TIE.getPoints());
                teamMatches.get(1).setTotalTie(1);
            } else{
                teamMatches.get(0).setTotalGoalTeam(result1);
                teamMatches.get(0).setGoalTeam1(result1);
                teamMatches.get(1).setTotalGoalTeam(result1);
                teamMatches.get(1).setGoalTeam2(result1);
                comparePlayers(result1,0);
                comparePlayers(result1,1);
                teamMatches.get(0).setTotalPoints(Result.TIE.getPoints());
                teamMatches.get(0).setTotalTie(1);
                teamMatches.get(1).setTotalPoints(Result.TIE.getPoints());
                teamMatches.get(1).setTotalTie(1);
            }
        } else {
            setChanceTeams(result1, result2);
            int resultTeam1 = teamMatches.get(0).getGoalTeam1();
            if(resultTeam1 == 0){
                teamMatches.get(0).setGoalTeam1(resultTeam1);
            }
            else{
                comparePlayers(resultTeam1,0);
                teamMatches.get(0).setGoalTeam1(resultTeam1);
            }
            int resultTeam2 = teamMatches.get(1).getGoalTeam2();
            if(resultTeam2 == 0){
                teamMatches.get(1).setGoalTeam2(resultTeam2);
            }
            else{
                comparePlayers(resultTeam2,1);
                teamMatches.get(1).setGoalTeam2(resultTeam2);
            }
            if(resultTeam1 < resultTeam2){
                teamMatches.get(1).setTotalPoints(Result.VICTORY.getPoints());
                teamMatches.get(1).setTotalVictory(1);
            } else{
                teamMatches.get(0).setTotalPoints(Result.VICTORY.getPoints());
                teamMatches.get(0).setTotalVictory(1);
            }
        }
    }

    /**
     * Adiciona o time na partida
     * @param team time
     * @return true se foi possível adicionar, false se já existem dois times na partida
     */
    public boolean addMatchTeams(Team team){
        team.setTeamSkill();
        if(teamMatches.size()<2){
            teamMatches.add(team);
            return true;
        }
        return false;
    }

    /**
     * Mostra na tela os jogadores de um time
     */
    public void showListTeams() {
        System.out.println("Teams list:");
        for (Team teams : teamMatches) {
            System.out.println(teams.getName() + " = " + teams.getSkillTeams());
        }
        System.out.println("**********************");
        System.out.println();
    }

    /**
     * Mostra na tela a lista os scores da lista de times do campeonato.
     */
    public void showOrderListTeams() {
        for (Team teams : teamMatches) {
            System.out.println(teams.getName() + ": ");
            System.out.println("Total of Goals: " + teams.getTotalGoalTeam());
            System.out.println("Total of Victories: " + teams.getTotalVictory());
            System.out.println("Total of Ties: " + teams.getTotalTie());
            System.out.println("Total of Points: " + teams.getTotalPoints());
            System.out.println();
        }
        System.out.println("**********************");
        System.out.println();
    }

    /**
     * Mostra na tela os times cadastrados e a data da partida
     */
    public void showListMatches() {
        System.out.println("Matches list - " + getDateOfMatch());
        System.out.println(teamMatches.get(0).getTeamsType() + " - " + teamMatches.get(0).getName());
        System.out.println(teamMatches.get(1).getTeamsType() + " - " + teamMatches.get(1).getName());
        System.out.println("**********************");
        System.out.println();
    }

    /**
     * Mostra os scores dos times da partida atual
     */
    public void showTeamStatistics() {
        System.out.println("Match Statistics - " + getDateOfMatch() + ":");
        System.out.println(" ");
        for(int i=0; i<2; i++){
            System.out.println(teamMatches.get(i).getTeamsType() + " - " + teamMatches.get(i).getName());
            System.out.println("Total of Points: " + teamMatches.get(i).getTotalPoints());
            System.out.println("Number of Victories: " + teamMatches.get(i).getTotalVictory());
            System.out.println("Number of Ties: " + teamMatches.get(i).getTotalTie());
            System.out.println("Total of Goals: " + teamMatches.get(i).getTotalGoalTeam());
            System.out.println("***********************");
            System.out.println();
        }
    }

    /**
     * Mostra na tela os scores dos jogadores dos times da partida
     */
    public void showTeamPlayersStatistics() {
        System.out.println("Team Statistics:");
        System.out.println(" ");
        for(int i=0; i<2; i++){
            System.out.println(teamMatches.get(i).getTeamsType() + " - " + teamMatches.get(i).getName() + " goals players:");
            for(int j=0; j< teamMatches.get(i).getSoccerTeam().size(); j++){
                System.out.println("Player " + teamMatches.get(i).getSoccerTeam().get(j).getNamePlayer() + " - " +
                        teamMatches.get(i).getSoccerTeam().get(j).getType() +": " +
                        teamMatches.get(i).getSoccerTeam().get(j).getGoal());
                }
            System.out.println("***********************");
            System.out.println();
        }
    }

    /**
     * Mostra na tela o placar da partida
     */
    public void showScoreboard(){
        System.out.println("Scoreboard:");
        System.out.println(" ");
        System.out.println(teamMatches.get(0).getTeamsType() + " - " + teamMatches.get(0).getName() + " Scoreboard:" +
                teamMatches.get(0).getGoalTeam1());
        System.out.println(teamMatches.get(1).getTeamsType() + " - " + teamMatches.get(1).getName() + " Scoreboard:" +
                teamMatches.get(1).getGoalTeam2());
        System.out.println("***********************");
        System.out.println();
    }

    /**
     * Método que ordena os times de acordo com suas estatísticas
     * @param name nome da estatística que pretende ser ordenada e mostrada na tela
     */
    public void compareStatistics(String name){
        switch (name) {
            case "goals" -> {
                System.out.println("Order Goals");
                teamMatches.sort(new CompareGoals());
                showOrderListTeams();
            }
            case "victories" -> {
                System.out.println("Order Victories");
                teamMatches.sort(new CompareVictory());
                showOrderListTeams();
            }
            case "ties" -> {
                System.out.println("Order Ties");
                teamMatches.sort(new CompareTies());
                showOrderListTeams();
            }
            case "points" -> {
                System.out.println("Order Points");
                teamMatches.sort(new ComparePoints());
                showOrderListTeams();
            }
            case "skills" -> {
                System.out.println("Order Skills");
                teamMatches.sort(new CompareSkills());
                showListTeams();
            }
        }
    }
}
