package team;

import players.PlayersType;
import players.SoccerPlayer;
import validator.Validator;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Classe que manipula os times
 */
public class Team {
    private final ArrayList<SoccerPlayer> soccerTeam;
    private final String name;
    private BigDecimal skillTeams;
    private int totalGoalTeam;
    private int totalPoints;
    private int totalVictory;
    private int totalTie;
    private TeamsType teamsType;
    private int goalTeam1;
    private int goalTeam2;
    private final Validator validator = new Validator();

    /**
     * Construtor de times
     * @param name nome do time
     */
    public Team(String name){
        validator.validateNameTeam(name);
        this.name = name;
        soccerTeam = new ArrayList<>();
        totalPoints = 0;
        totalVictory = 0;
        totalTie = 0;
    }

    /**
     * Seta o gol do time 1
     * @param goalTeam1 gol do time 1
     */
    public void setGoalTeam1(int goalTeam1) {
        validator.validateNegativeNumbers(goalTeam1);
        this.goalTeam1 = goalTeam1;
    }

    /**
     * Seta o gol do time 2
     * @param goalTeam2 gol do time 2
     */
    public void setGoalTeam2(int goalTeam2) {
        validator.validateNegativeNumbers(goalTeam2);
        this.goalTeam2 = goalTeam2;
    }

    /**
     * @return gol do time 1
     */
    public int getGoalTeam1() {
        return goalTeam1;
    }

    /**
     * @return gol do time 2
     */
    public int getGoalTeam2() {
        return goalTeam2;
    }

    /**
     * Seta os tipos de times
     * @param teamsType enumeração de times (casa e vsitante)
     */
    public void setTeamsType(TeamsType teamsType) {
        this.teamsType = teamsType;
    }

    /**
     * @return tipo dos times
     */
    public TeamsType getTeamsType() {
        return teamsType;
    }

    /**
     * Seta total de gols de um time
     * @param totalGoalTeam total de gols do time
     */
    public void setTotalGoalTeam(int totalGoalTeam) {
        validator.validateNegativeNumbers(totalGoalTeam);
        this.totalGoalTeam += totalGoalTeam;
    }

    /**
     * @return total de gols de um time
     */
    public int getTotalGoalTeam() {
        return totalGoalTeam;
    }

    /**
     * @return total de pontos de um time
     */
    public int getTotalPoints() {
        return totalPoints;
    }

    /**
     * Seta o total de pontos de um time
     * @param totalPoints total de pontos
     */
    public void setTotalPoints(int totalPoints) {
        validator.validateNegativeNumbers(totalPoints);
        this.totalPoints += totalPoints;
    }

    /**
     * @return total de empates
     */
    public int getTotalTie() {
        return totalTie;
    }

    /**
     * Seta total de empates
     * @param totalTie total de empates
     */
    public void setTotalTie(int totalTie) {
        validator.validateNegativeNumbers(totalTie);
        this.totalTie += totalTie;
    }

    /**
     * @return total de vitórias
     */
    public int getTotalVictory() {
        return totalVictory;
    }

    /**
     * Seta total de vitórias de um time
     * @param totalVictory total de vitórias
     */
    public void setTotalVictory(int totalVictory) {
        validator.validateNegativeNumbers(totalVictory);
        this.totalVictory += totalVictory;
    }

    /**
     * @return lista de jogadores de um time
     */
    public ArrayList<SoccerPlayer> getSoccerTeam() {
        return soccerTeam;
    }

    /**
     * @return nome do time
     */
    public String getName() {
        return name;
    }

    /**
     * @return total das habilidades de um time
     */
    public BigDecimal getSkillTeams() {
        return skillTeams;
    }

    /**
     * Função auxiliar para adicionar jogadores à lista do time
     * @param soccerTeam lista de jogadores de um time
     * @param player jogador
     * @return true quando adiciona um jogador à lista de jogadores
     */
    public boolean addPlayersInTeam(ArrayList<SoccerPlayer> soccerTeam, SoccerPlayer player){
        soccerTeam.add(player);
        return true;
    }

    /**
     * Adiciona os jogadores em um time.
     * Se for um jogador em uma posição repetida, ele não adiciona e retorna false
     * @param player jogador
     * @return true se adicionou o jogador na lista do time, false se já está completo o tipo de jogador na equipe
     */
    public boolean addPlayers(SoccerPlayer player) {
        if (soccerTeam.isEmpty()) {
            return addPlayersInTeam(soccerTeam, player);
        } else {
            int contGoal = 0;
            int contDefender1 = 0;
            int contAttacker1 = 0;
            int contDefender2 = 0;
            int contAttacker2 = 0;
            for (SoccerPlayer soccerPlayer : soccerTeam) {
                if (soccerPlayer.getType() == PlayersType.GOALKEEPER) {
                    contGoal++;
                } else if (soccerPlayer.getType() == PlayersType.DEFENDER1) {
                    contDefender1++;
                } else if (soccerPlayer.getType() == PlayersType.ATTACKER1) {
                    contAttacker1++;
                } else if (soccerPlayer.getType() == PlayersType.DEFENDER2) {
                    contDefender2++;
                } else if (soccerPlayer.getType() == PlayersType.ATTACKER2) {
                    contAttacker2++;
                }
            }
            if ((player.getType() == PlayersType.GOALKEEPER && contGoal < 1) ||
                        (player.getType() == PlayersType.DEFENDER1 && contDefender1 < 1) ||
                        (player.getType() == PlayersType.ATTACKER1 && contAttacker1 < 1) ||
                        (player.getType() == PlayersType.DEFENDER2 && contDefender2 < 1) ||
                        (player.getType() == PlayersType.ATTACKER2 && contAttacker2 < 1)) {
                return addPlayersInTeam(soccerTeam, player);
            } else {
                return false;
            }
        }
    }

    /**
     * Remove o jogador escolhido do time
     * @param namePlayer nome do jogador a ser removido
     * @return true se foi possível remover, falso se não foi possível pois não existe o jogador no time
     */
    public boolean removePlayers(String namePlayer){
        for(int i=0; i<soccerTeam.size(); i++){
            if(namePlayer.equals(soccerTeam.get(i).getNamePlayer())){
                soccerTeam.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Mostra a lista de jogadores de um time
     */
    public void showTeam(){
        System.out.println("Team: " + getName());
        for(SoccerPlayer t : soccerTeam){
            System.out.println(t);
        }
        System.out.println("**********************");
    }

    /**
     * Calcula o total das habilidades do time somando as habilidades de todos os jogadores do time
     */
    public void setTeamSkill(){
        BigDecimal sum = new BigDecimal(0);
        for (SoccerPlayer soccerPlayer : soccerTeam) {
            sum = soccerPlayer.getSkill().add(sum);
        }
        this.skillTeams = sum;
    }

}
