package matches;

import comparator.*;
import players.PlayersType;
import team.Result;
import team.Team;
import team.TeamsType;

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

    /**
     * Construtor da classe partidas
     * @param dateOfMatch data da partida
     */
    public Match(LocalDate dateOfMatch){
        this.dateOfMatch = dateOfMatch;
    }

    /**
     * @return dia da partida
     */
    public LocalDate getDateOfMatch() {
        return dateOfMatch;
    }

    /**
     * Classifica os os dois times da partida em time da casa e time visitante
     * @param match lista de times da partida atual
     */
    public void setTypeOfTeams(ArrayList<Team> match) {
        match.get(0).setTeamsType(TeamsType.HOME);
        match.get(1).setTeamsType(TeamsType.VISITOR);
    }

    /**
     * Seta os gols do time de acordo com o número randomico sorteado e qual time tem as maiores chances
     * @param match lista dos times da partida atual
     * @param result total de gols de um time
     * @param team qual o time está pontuando
     */
    public void setGoalsTeams(ArrayList<Team> match, int result, int team){
        match.get(team).setGoalTeam1(result);
        match.get(team).setTotalGoalTeam(result);
    }

    /**
     * Chama a função de setar os gols do time de acordo com o número randomico sorteado e qual time tem as maiores chances
     * @param match lista dos times da partida atual
     * @param number número randômico
     * @param resultMax maior resultado dos gols dos times
     * @param resultMin menor resultado dos gols dos times
     * @param larger indica qual das opções de chances a ser utilizada para o cálculo
     */
    public void setChancesLarger(ArrayList<Team> match, int number, int resultMax, int resultMin, boolean larger){
        if((larger && number == 0) || (!larger && (number >=0 && number<2))){
            if(match.get(0).getTeamsType() == TeamsType.VISITOR){
                setGoalsTeams(match,resultMax,0);
            } else if(match.get(0).getTeamsType() == TeamsType.HOME){
                setGoalsTeams(match,resultMin,0);
            } else if(match.get(1).getTeamsType() == TeamsType.VISITOR){
                setGoalsTeams(match,resultMax,1);
            } else{
                setGoalsTeams(match,resultMin,1);
            }
        } else if((larger && number>0) || (!larger && number >=2)){
            if(match.get(0).getTeamsType() == TeamsType.HOME){
                setGoalsTeams(match,resultMax,0);
            } else if(match.get(0).getTeamsType() == TeamsType.VISITOR){
                setGoalsTeams(match,resultMin,0);
            } else if(match.get(1).getTeamsType() == TeamsType.HOME){
                setGoalsTeams(match,resultMax,1);
            } else{
                setGoalsTeams(match,resultMin,1);
            }
        }
    }

    /**
     * Método que compara as chances dos times. Se o time da casa tem maior habilidade que o time visitante,
     * então o time da casa tem 2x mais chance de ganhar a partida.
     * Se o time visitante tem maior habilidade, então os times tem chances iguais de ganhar a partida
     * @param match lista dos times da partida atual
     * @param result1 total de gols de um time
     * @param result2 total de gols de outro time
     */
    public void setChanceTeams(ArrayList<Team> match, int result1, int result2) {
        BigDecimal chanceHome = new BigDecimal(0);
        BigDecimal chanceVisitor = new BigDecimal(0);
        int resultMax = Math.max(result1, result2);
        int resultMin = Math.min(result1, result2);
        Random random = new Random();
        int number;
        for (int i = 0; i < match.size(); i++) {
            if (match.get(i).getTeamsType() == TeamsType.HOME) {
                chanceHome = match.get(i).getSkillTeams();
            } else {
                chanceVisitor = match.get(i).getSkillTeams();
            }
        }
        if (chanceHome.compareTo(chanceVisitor) > 0) {
            number = random.nextInt(3);
            setChancesLarger(match, number, resultMax, resultMin, true);
        } else {
            number = random.nextInt(4);
            setChancesLarger(match, number, resultMax, resultMin, false);
        }
    }

    /**
     * Compara qual dos defensores tem mais chance de fazer um gol.
     * Depende do total das habilidades.
     * Quem tem maior habilidade tem 4x mais chance de fazer gols.
     * @param match lista dos times da partida
     * @param j índice do time atual a ser comparado
     */
    public void compareDefender(ArrayList<Team> match, int j){
        Random random = new Random();
        BigDecimal defender1 = new BigDecimal(0);
        BigDecimal defender2 = new BigDecimal(0);
        for(int i=0; i<match.get(j).getSoccerTeam().size(); i++){
            if(match.get(j).getSoccerTeam().get(i).getType() == PlayersType.DEFENDER1){
                defender1 = match.get(j).getSoccerTeam().get(i).getSkill();
            }
            if(match.get(j).getSoccerTeam().get(i).getType() == PlayersType.DEFENDER2){
                defender2 = match.get(j).getSoccerTeam().get(i).getSkill();
            }
        }
        if (defender1.compareTo(defender2)>0){
            int number2 = random.nextInt(6);
            if(number2<2){
                for(int i = 0; i< match.get(j).getSoccerTeam().size(); i++){
                    if(match.get(j).getSoccerTeam().get(i).getType() == PlayersType.DEFENDER2){
                        match.get(j).getSoccerTeam().get(i).setGoal(1);
                    }
                }
            } else{
                for(int i = 0; i< match.get(j).getSoccerTeam().size(); i++){
                    if(match.get(j).getSoccerTeam().get(i).getType() == PlayersType.DEFENDER1){
                        match.get(j).getSoccerTeam().get(i).setGoal(1);
                    }
                }
            }
        }else{
            int number2 = random.nextInt(6);
            if(number2<2){
                for(int i=0; i< match.get(j).getSoccerTeam().size(); i++){
                    if(match.get(j).getSoccerTeam().get(i).getType() == PlayersType.DEFENDER1){
                        match.get(j).getSoccerTeam().get(i).setGoal(1);
                    }
                }
            } else{
                for(int i = 0; i< match.get(j).getSoccerTeam().size(); i++){
                    if(match.get(j).getSoccerTeam().get(i).getType() == PlayersType.DEFENDER2){
                        match.get(j).getSoccerTeam().get(i).setGoal(1);
                    }
                }
            }
        }
    }

    /**
     * Compara qual dos atacantes tem mais chance de fazer um gol.
     * Depende do total das habilidades.
     * Quem tem maior habilidade tem 4x mais chance de fazer gols.
     * @param match lista dos times da partida
     * @param j índice do time atual a ser comparado
     */
    public void compareAttacker(ArrayList<Team> match, int j){
        Random random = new Random();
        BigDecimal attacker1 = new BigDecimal(0);
        BigDecimal attacker2 = new BigDecimal(0);
        for(int i=0; i<match.get(j).getSoccerTeam().size(); i++){
            if(match.get(j).getSoccerTeam().get(i).getType() == PlayersType.ATTACKER1){
                attacker1 = match.get(j).getSoccerTeam().get(i).getSkill();
            }
            if(match.get(j).getSoccerTeam().get(i).getType() == PlayersType.ATTACKER2){
                attacker2 = match.get(j).getSoccerTeam().get(i).getSkill();
            }
        }
        if (attacker1.compareTo(attacker2)>0){
            int number2 = random.nextInt(6);
            if(number2<2){
                for(int i = 0; i< match.get(j).getSoccerTeam().size(); i++){
                    if(match.get(j).getSoccerTeam().get(i).getType() == PlayersType.ATTACKER2){
                        match.get(j).getSoccerTeam().get(i).setGoal(1);
                    }
                }
            } else{
                for(int i = 0; i< match.get(j).getSoccerTeam().size(); i++){
                    if(match.get(j).getSoccerTeam().get(i).getType() == PlayersType.ATTACKER1){
                        match.get(j).getSoccerTeam().get(i).setGoal(1);
                    }
                }
            }
        }else{
            int number2 = random.nextInt(6);
            if(number2<2){
                for(int i=0; i< match.get(j).getSoccerTeam().size(); i++){
                    if(match.get(j).getSoccerTeam().get(i).getType() == PlayersType.ATTACKER1){
                        match.get(j).getSoccerTeam().get(i).setGoal(1);
                    }
                }
            } else{
                for(int i = 0; i< match.get(j).getSoccerTeam().size(); i++){
                    if(match.get(j).getSoccerTeam().get(i).getType() == PlayersType.ATTACKER2){
                        match.get(j).getSoccerTeam().get(i).setGoal(1);
                    }
                }
            }
        }
    }

    /**
     * Compara todos os jogadores e calcula quem tem mais chances de fazer o gol.
     * Se for goleiro tem 1x mais chance.
     * Se for defensor tem 3x mais chances.
     * Se for atacante tem 6x mais chances.
     * @param goals total de gols feitos pelo time.
     * @param match lista de times da partida.
     * @param j índice do time atual para comparação.
     */
    public void comparePlayers(int goals, ArrayList<Team> match, int j){
        int cont = 0;
        Random random = new Random();
        do {
            int number = random.nextInt(10);
            if (number == 0) {
                for (int i = 0; i < match.get(j).getSoccerTeam().size(); i++) {
                    if (match.get(j).getSoccerTeam().get(i).getType() == PlayersType.GOALKEEPER) {
                        match.get(j).getSoccerTeam().get(i).setGoal(1);
                    }
                }
                cont++;
            }
            if (number >= 1 && number < 4) {
                compareDefender(match, j);
                cont++;
            }
            if (number >= 4) {
                compareAttacker(match, j);
                cont++;
            }
        } while(cont<goals);
    }

    /**
     * Simulação de uma partida
     * @param match lista de times da partida
     */
    public void simulation(ArrayList<Team> match){
        Random random = new Random();
        int result1 = random.nextInt(6);
        random = new Random();
        int result2 = random.nextInt(6);
        if(result1 == result2){
            if(result1 == 0){
                match.get(0).setTotalPoints(Result.TIE.getPoints());
                match.get(0).setTotalTie(1);
                match.get(1).setTotalPoints(Result.TIE.getPoints());
                match.get(1).setTotalTie(1);
            } else{
                match.get(0).setTotalGoalTeam(result1);
                match.get(0).setGoalTeam1(result1);
                match.get(1).setTotalGoalTeam(result1);
                match.get(1).setGoalTeam2(result1);
                comparePlayers(result1, match, 0);
                comparePlayers(result1, match, 1);
                match.get(0).setTotalPoints(Result.TIE.getPoints());
                match.get(0).setTotalTie(1);
                match.get(1).setTotalPoints(Result.TIE.getPoints());
                match.get(1).setTotalTie(1);
            }
        } else {
            setChanceTeams(match, result1, result2);
            int resultTeam1 = match.get(0).getGoalTeam1();
            if(resultTeam1 == 0){
                match.get(0).setGoalTeam1(resultTeam1);
            }
            else{
                comparePlayers(resultTeam1, match, 0);
                match.get(0).setGoalTeam1(resultTeam1);
            }
            int resultTeam2 = match.get(1).getGoalTeam2();
            if(resultTeam2 == 0){
                match.get(1).setGoalTeam2(resultTeam2);
            }
            else{
                comparePlayers(resultTeam2, match, 1);
                match.get(1).setGoalTeam2(resultTeam2);
            }
            if(resultTeam1 < resultTeam2){
                match.get(1).setTotalPoints(Result.VICTORY.getPoints());
                match.get(1).setTotalVictory(1);
            } else{
                match.get(0).setTotalPoints(Result.VICTORY.getPoints());
                match.get(0).setTotalVictory(1);
            }
        }
    }

    /**
     * Adiciona dois times em uma partida
     * @param team1 time 1
     * @param team2 time 2
     * @param matches lista de times da partida
     */
    public void addMatchTeams(Team team1, Team team2, ArrayList<Team> matches){
        if(matches.size()<2){
            matches.add(team1);
            matches.add(team2);
        } else{
            System.out.println("Match is already complete!");
        }
    }

    /**
     * Mostra na tela os jogadores de um time
     * @param soccerTeams lista de jogadores de um time
     */
    public void showListTeams(ArrayList<Team> soccerTeams) {
        System.out.println("Teams list:");
        for (Team teams : soccerTeams) {
            System.out.println(teams.getName() + " = " + teams.getSkillTeams());
        }
        System.out.println("**********************");
        System.out.println();
    }

    /**
     * Mostra na tela a lista os scores da lista de times do campeonato.
     * @param soccerTeams lista de times do campeonato
     */
    public void showOrderListTeams(ArrayList<Team> soccerTeams) {
        for (Team teams : soccerTeams) {
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
     * @param matches lista de times da partida
     */
    public void showListMatches(ArrayList<Team> matches) {
        System.out.println("Matches list - " + getDateOfMatch());
        System.out.println(matches.get(0).getTeamsType() + " - " + matches.get(0).getName());
        System.out.println(matches.get(1).getTeamsType() + " - " + matches.get(1).getName());
        System.out.println("**********************");
        System.out.println();
    }

    /**
     * Mostra os scores dos times da partida atual
     * @param matches lista de times da partida
     */
    public void showTeamStatistics(ArrayList<Team> matches) {
        System.out.println("Match Statistics - " + getDateOfMatch() + ":");
        System.out.println(" ");
        for(int i=0; i<2; i++){
            System.out.println(matches.get(i).getTeamsType() + " - " + matches.get(i).getName());
            System.out.println("Total of Points: " + matches.get(i).getTotalPoints());
            System.out.println("Number of Victories: " + matches.get(i).getTotalVictory());
            System.out.println("Number of Ties: " + matches.get(i).getTotalTie());
            System.out.println("Total of Goals: " + matches.get(i).getTotalGoalTeam());
            System.out.println("***********************");
            System.out.println();
        }
    }

    /**
     * Mostra na tela os scores dos jogadores dos times da partida
     * @param matches lista de times da partida
     */
    public void showTeamPlayersStatistics(ArrayList<Team> matches) {
        System.out.println("Team Statistics:");
        System.out.println(" ");
        for(int i=0; i<2; i++){
            System.out.println(matches.get(i).getTeamsType() + " - " + matches.get(i).getName() + " goals players:");
            for(int j=0; j< matches.get(i).getSoccerTeam().size(); j++){
                System.out.println("Player " + matches.get(i).getSoccerTeam().get(j).getNamePlayer() + " - " +
                        matches.get(i).getSoccerTeam().get(j).getType() +": " +
                        matches.get(i).getSoccerTeam().get(j).getGoal());
                }
            System.out.println("***********************");
            System.out.println();
        }
    }

    /**
     * Mostra na tela o placar da partida
     * @param matches lista de times da partida
     */
    public void showScoreboard(ArrayList<Team> matches){
        System.out.println("Scoreboard:");
        System.out.println(" ");
        System.out.println(matches.get(0).getTeamsType() + " - " + matches.get(0).getName() + " Scoreboard:" +
                    matches.get(0).getGoalTeam1());
        System.out.println(matches.get(1).getTeamsType() + " - " + matches.get(1).getName() + " Scoreboard:" +
                matches.get(1).getGoalTeam2());
        System.out.println("***********************");
        System.out.println();
    }

    /**
     * Método que ordena os times de acordo com suas estatísticas
     * @param teams lista de times do campeonato
     * @param name nome da estatística que pretende ser ordenada
     */
    public void compareStatistics(ArrayList<Team> teams, String name){
        if(name.equals("goals")){
            System.out.println("Order Goals");
            teams.sort(new CompareGoals());
            showOrderListTeams(teams);
        }
        if(name.equals("victories")){
            System.out.println("Order Victories");
            teams.sort(new CompareVictory());
            showOrderListTeams(teams);
        }
        if(name.equals("ties")){
            System.out.println("Order Ties");
            teams.sort(new CompareTies());
            showOrderListTeams(teams);
        }
        if(name.equals("points")){
            System.out.println("Order Points");
            teams.sort(new ComparePoints());
            showOrderListTeams(teams);
        }
        if(name.equals("skills")){
            System.out.println("Order Skills");
            teams.sort(new CompareSkills());
            showListTeams(teams);
        }
    }
}
