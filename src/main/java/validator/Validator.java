package validator;

import java.time.LocalDate;

/**
 * Classe de validações
 */
public class Validator {

    /**
     * se os argumentos do jogadores forem nulos ele quebra o programa
     * @param name nome do jogador
     * @param dateOfBirth data de nascimento
     */
    public void validateArgument(String name, LocalDate dateOfBirth) {
        if(name == null || dateOfBirth == null){
            throw new IllegalArgumentException("Invalid Argument");
        }
    }

    /**
     * Valida o nome do jogador. Se for uma String vazia, ele quebra o programa.
     * @param name nome do jogador
     */
    public void validateName(String name) {
        if(name.equals(" ")){
            throw new IllegalArgumentException("Name must not be empty");
        }
    }

    /**
     * Valida altura do goleiro. Deve ser entre 0 e 250.
     * @param height altura do jogador
     */
    public void validateHeight(int height) {
        if(height < 0 || height > 250){
            throw new IllegalArgumentException("Invalid height");
        }
    }

    /**
     * Valida o reflexo do goleiro. Deve ser entre 0 e 100.
     * @param reflex reflexo
     */
    public void validateReflex(int reflex) {
        if(reflex < 0 || reflex > 100){
            throw new IllegalArgumentException("Invalid reflex");
        }
    }

    /**
     * Valida habilidades do defensor. Deve ser entre 0 e 100.
     * @param cover cobertura
     * @param disarm desarme
     */
    public void validateDefenderSkills(int cover, int disarm) {
        if(cover < 0 || cover > 100 || disarm < 0 || disarm > 100){
            throw new IllegalArgumentException("Invalid arguments");
        }
    }

    /**
     * Valida as habilidade do atacante. Deve ser entre 0 e 100.
     * @param velocity velocidade
     * @param technique técnica
     */
    public void validateAttackerSkills(int velocity, int technique) {
        if(velocity < 0 || velocity > 100 || technique < 0 || technique > 100){
            throw new IllegalArgumentException("Invalid arguments");
        }
    }


}
