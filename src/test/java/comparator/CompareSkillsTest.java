package comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import players.Attacker;
import players.Defender;
import players.Goalkeeper;
import players.PlayersType;
import team.Team;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CompareSkillsTest {
    private CompareSkills comp = new CompareSkills();
    private Team t1;
    private Team  t2;
    private Goalkeeper goalA;
    private Attacker attackerA1;
    private Attacker attackerA2;
    private Defender defenderA1;
    private Defender defenderA2;
    private Goalkeeper goalB;
    private Attacker attackerB1;
    private Attacker attackerB2;
    private Defender defenderB1;
    private Defender defenderB2;

    @BeforeEach
    void iniSoccerPlayersAndTeams(){
        LocalDate dateOfBirth = LocalDate.parse("1996-07-25");
        goalA = new Goalkeeper("Fabiana", dateOfBirth, PlayersType.GOALKEEPER, 90, 90);
        attackerA1 = new Attacker("Jussara", dateOfBirth, PlayersType.ATTACKER1, 90,90);
        defenderA1 = new Defender("Giovana", dateOfBirth, PlayersType.DEFENDER1, 90, 90);
        attackerA2 = new Attacker("Gabriela", dateOfBirth, PlayersType.ATTACKER2, 90,90);
        defenderA2 = new Defender("Leandra", dateOfBirth, PlayersType.DEFENDER2, 90, 90);

        goalB = new Goalkeeper("Lucrecia", dateOfBirth, PlayersType.GOALKEEPER, 45, 45);
        attackerB1 = new Attacker("Fernanda", dateOfBirth, PlayersType.ATTACKER1, 45,45);
        defenderB1 = new Defender("Marta", dateOfBirth, PlayersType.DEFENDER1, 45, 45);
        attackerB2 = new Attacker("Ingrid", dateOfBirth, PlayersType.ATTACKER2, 45,45);
        defenderB2 = new Defender("Griselda", dateOfBirth, PlayersType.DEFENDER2, 45, 45);

        t1 = new Team("teamOne");
        t2 = new Team("teamTwo");

        t1.addPlayers(goalA);
        t1.addPlayers(attackerA1);
        t1.addPlayers(defenderA1);
        t1.addPlayers(attackerA2);
        t1.addPlayers(defenderA2);

        t2.addPlayers(goalB);
        t2.addPlayers(attackerB1);
        t2.addPlayers(defenderB1);
        t2.addPlayers(attackerB2);
        t2.addPlayers(defenderB2);

        t1.setTeamSkill();
        t2.setTeamSkill();
    }

    //Teste Funcional
    @Test
    void teamOneHasMoreSkill(){
        assertEquals(1, comp.compare(t1,t2));
    }

    //Teste Funcional
    @Test
        //esta quebrando, metodo retorn 0 ao inves de -1
    void teamTwoHasMoreSkill(){
        assertEquals(-1, comp.compare(t2,t1));
    }

    //Teste Funcional
    @Test
    void tie(){
        assertEquals(0, comp.compare(t1,t1));
    }

}