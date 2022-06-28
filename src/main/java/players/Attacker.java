package players;

import validator.Validator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 * Classe atacante herdada de jogador
 */
public class Attacker extends SoccerPlayer {
    private final int velocity;
    private final int technique;
    private final int shirtNumber;

    /**
     * Construtor de atacante
     * @param name nome do jogador
     * @param dateOfBirth data de nascimento
     * @param type posição do jogador
     * @param velocity velocidade
     * @param technique técnica
     */
    public Attacker(String name, LocalDate dateOfBirth, PlayersType type, int velocity, int technique){
        super(name, dateOfBirth, type);
        Validator validator = new Validator();
        validator.validateAttackerSkills(velocity, technique);
        if(type == PlayersType.ATTACKER1){
            this.shirtNumber = 9;
        } else {
            this.shirtNumber = 10;
        }
        this.velocity = velocity;
        this.technique = technique;
    }

    /**
     * @return número da camisa do atacante
     */
    public int getShirtNumber() {
        return shirtNumber;
    }

    /**
     * @return técnica
     */
    public int getTechnique() {
        return technique;
    }

    /**
     * @return velocidade
     */
    public int getVelocity() {
        return velocity;
    }

    /**
     * Calcula a habilidade total do atacante
     * @return habilidade total do atacante
     */
    @Override
    public BigDecimal getSkill(){
        BigDecimal valueVelocity = new BigDecimal("0.4");
        BigDecimal velocity = new BigDecimal(getVelocity());
        BigDecimal valueTechnique = new BigDecimal("0.6");
        BigDecimal technique = new BigDecimal(getTechnique());
        return ((velocity.multiply(valueVelocity)).add(technique.multiply(valueTechnique))).setScale(1, RoundingMode.HALF_EVEN);
    }

    /**
     * Implementa o toString para a classe do atacante
     * @return nome, idade, velocidade, técnica, número da camisa, e total das habilidades
     */
    @Override
    public String toString() {
        return "Attacker [ " + super.toString() +
                ", velocity=" + getVelocity() +
                ", technique=" + getTechnique() +
                ", shirt number=" + getShirtNumber()+
                ", AttackerSkill =" + getSkill() + " ]";
    }
}
