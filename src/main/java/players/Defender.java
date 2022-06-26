package players;

import validator.Validator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 * Classe defensor herdada de jogador
 */
public class Defender extends SoccerPlayer {
    private final int cover;
    private final int disarm;
    private final int shirtNumber;

    /**
     * Construtor de defensor
     * @param name nome do jogador
     * @param dateOfBirth data de nascimento
     * @param type posição do jogador
     * @param cover cobertura
     * @param disarm desarme
     */
    public Defender(String name, LocalDate dateOfBirth, PlayersType type, int cover, int disarm){
        super(name, dateOfBirth, type);
        Validator validator = new Validator();
        validator.validateDefenderSkills(cover, disarm);
        if(type == PlayersType.DEFENDER1){
            this.shirtNumber = 5;
        } else {
            this.shirtNumber = 6;
        }
        this.cover = cover;
        this.disarm = disarm;
    }

    /**
     * @return número da camisa
     */
    public int getShirtNumber() {
        return shirtNumber;
    }

    /**
     * @return cobertura
     */
    public int getCover() {
        return cover;
    }

    /**
     * @return desarme
     */
    public int getDisarm() {
        return disarm;
    }


    /**
     * Calcula a habilidade total do defensor
     * @return habilidade total do defensor
     */
    @Override
    public BigDecimal getSkill(){
        BigDecimal valueDisarm = new BigDecimal("0.4");
        BigDecimal cover = new BigDecimal(getCover());
        BigDecimal valueCover = new BigDecimal("0.6");
        BigDecimal disarm = new BigDecimal(getDisarm());
        return ((disarm.multiply(valueDisarm)).add(cover.multiply(valueCover))).setScale(1, RoundingMode.HALF_EVEN);
    }

    /**
     * Implementa o toString para a classe do defensor
     * @return nome, idade, cobertura, desarme, número da camisa, e total das habilidades
     */
    @Override
    public String toString() {
        return "Defender [ " + super.toString() +
                ", cover=" + getCover() +
                ", disarm=" + getDisarm() +
                ", shirt number=" + getShirtNumber() +
                ", DefenderSkill =" + getSkill() + " ]";
    }
}
