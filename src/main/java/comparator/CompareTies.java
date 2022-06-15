package comparator;

import team.Team;

import java.util.Comparator;

/**
 * Classe compara os empates de dois times para ordenação.
 */
public class CompareTies implements Comparator<Team> {

    /**
     * Compara o valor de empates de dois times para ordenação
     * @param team1 time 1
     * @param team2 time 2
     * @return retorna um inteiro negativo, zero ou positivo se o primeiro argumento é menor, igual ou maior o segundo respectivamente.
     */
    @Override
    public int compare(Team team1, Team team2) {
        return Integer.compare(team1.getTotalTie(), team2.getTotalTie());
    }

}
