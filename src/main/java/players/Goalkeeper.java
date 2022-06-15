package players;

import validator.Validator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 * Classe goleiro herdada de jogador
 */
public class Goalkeeper extends SoccerPlayer {
    private final int height;
    private final int reflex;
    private final int shirtNumber;

    /**
     * Construtor de goleiro
     * @param name nome do jogador
     * @param dateOfBirth data de nascimento
     * @param type posição do jogador
     * @param height altura
     * @param reflex reflexo
     */
    public Goalkeeper(String name, LocalDate dateOfBirth, PlayersType type, int height, int reflex){
        super(name, dateOfBirth, type);
        Validator validator = new Validator();
        validator.validateHeight(height);
        validator.validateReflex(reflex);
        this.shirtNumber = 1;
        this.height = height;
        this.reflex = reflex;
    }

    /**
     * @return número de camisa
     */
    public int getShirtNumber() {
        return shirtNumber;
    }

    /**
     * Calcula habilidade que depende da altura do jogador
     * @return habilidade de altura
     */
    public BigDecimal getHeight() {
        if(height >= 210){
            BigDecimal fh = new BigDecimal(100);
            return fh;
        }
        else{
            double finalHeight = (height * 100)/210;
            BigDecimal fh = new BigDecimal(finalHeight).setScale(0, RoundingMode.HALF_EVEN);
            return fh;
        }
    }


    /**
     * @return reflexo
     */
    public int getReflex() {
        return reflex;
    }

    /**
     * Calcula a habilidade total do goleiro
     * @return habilidade total do goleiro
     */
    @Override
    public BigDecimal getSkill(){
        BigDecimal valueHeight = new BigDecimal(0.4);
        BigDecimal reflex = new BigDecimal(getReflex());
        BigDecimal valueReflex = new BigDecimal(0.6);
        return ((getHeight().multiply(valueHeight)).add(reflex.multiply(valueReflex))).setScale(1,RoundingMode.HALF_EVEN);
    }

    /**
     * Implementa o toString para a classe do goleiro
     * @return nome, idade, habilidade calculada de altura, reflexo, número da camisa, e total das habilidades
     */
    @Override
    public String toString() {
        return "Goalkeeper [ " + super.toString() +
                ", height=" + getHeight() +
                ", reflex=" + getReflex() +
                ", shirt number=" + getShirtNumber() +
                ", GoalkeeperSkill =" + getSkill() + " ]";
    }

}
