package math;

/**
 * Classe que faz os cálculos matemáticos necessários na partida.
 */
public class Math {
    private int min;
    private int max;

    /**
     * Compara os dois resultados do placar e seta o mínimo e máximo.
     * @param result1 resultado de um time
     * @param result2 resultado de outro time
     */
    public void setMinMax(int result1, int result2) {
        if(result1< result2){
            this.min = result1;
            this.max = result2;
        } else{
            this.min = result2;
            this.max = result1;
        }
    }

    /**
     * @return retorna o valor mínimo do placar
     */
    public int getMin() {
        return min;
    }

    /**
     * @return retorna o valor máximo do placar
     */
    public int getMax() {
        return max;
    }
}
