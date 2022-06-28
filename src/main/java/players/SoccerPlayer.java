package players;

import validator.Validator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

/**
 * Super Classe de Jogadores
 */
public abstract class SoccerPlayer {
    private final String namePlayer;
    private final LocalDate dateOfBirth;
    private int goal;
    private final PlayersType type;

    /**
     * Construtor da classe de jogadores
     * @param namePlayer nome do jogador
     * @param dateOfBirth data de nascimento
     * @param type posição do jogador
     */
    public SoccerPlayer(String namePlayer, LocalDate dateOfBirth, PlayersType type){
        Validator validator = new Validator();
        validator.validateArgument(namePlayer, dateOfBirth);
        validator.validateName(namePlayer);
        this.namePlayer = namePlayer;
        this.dateOfBirth = dateOfBirth;
        this.type = type;
    }

    /**
     * @return nome do jogador
     */
    public String getNamePlayer() {
        return namePlayer;
    }

    /**
     * Seta a quantidade de gol de um jogador
     * @param goal gol
     */
    public void setGoal(int goal) {
        this.goal += goal;
    }

    /**
     * @return gol do jogador
     */
    public int getGoal() {
        return goal;
    }

    /**
     * @return posição do jogador
     */
    public PlayersType getType() {
        return type;
    }

    /**
     * @return idade do jogador
     */
    public int getAge() {
        LocalDate today = LocalDate.now();
        return Period.between(dateOfBirth, today).getYears();
    }

    /**
     * Método que calcula a habilidade total do jogador
     * @return habilidade total do jogador
     */
    public BigDecimal getSkill(){
        BigDecimal valueSkill4 = new BigDecimal("0.4");
        BigDecimal skill4 = new BigDecimal(100);
        BigDecimal valueSkill6 = new BigDecimal("0.6");
        BigDecimal skill6 = new BigDecimal(100);
        return ((skill4.multiply(valueSkill4)).add(skill6.multiply(valueSkill6))).setScale(1, RoundingMode.HALF_EVEN);
    }

    /**
     * Implementa o toString para a classe do jogador
     * @return nome do jogador e a idade
     */
    @Override
    public String toString() {
        return " namePlayer='" + namePlayer + '\'' +
                ", age=" + getAge();
    }

}
