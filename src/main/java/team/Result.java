package team;

/**
 * Enumeração dos resultados das partidas
 */
public enum Result {
    VICTORY(3),
    TIE(1),
    DEFEAT(0);

    private final int points;

    /**
     * @param points pontos do resultado
     */
    Result(int points) {
        this.points = points;
    }

    /**
     * @return pontos
     */
    public int getPoints() {
        return points;
    }
}
