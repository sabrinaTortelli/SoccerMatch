package comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import players.Attacker;
import players.Defender;
import players.Goalkeeper;
import players.PlayersType;
import team.Team;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CompareSkillsTest {
    private CompareSkills comp = new CompareSkills();
    private Team t1 = new Team("teamOne");
    private Team  t2 = new Team("teamTwo");
    private Team  t3 = new Team("teamThree");
//    private Team  t4 = new Team("teamThree");

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
    private Defender defenderB3;
    private Goalkeeper goalC;
    private Attacker attackerC1;
    private Attacker attackerC2;
    private Defender defenderC1;
    private Defender defenderC2;
//    private Goalkeeper goalD;
//    private Attacker attackerD1;
//    private Attacker attackerD2;
//    private Defender defenderD1;
//    private Defender defenderD2;

    @BeforeEach
    private void iniSoccerPlayers(){

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

        goalC = new Goalkeeper("Janaina", dateOfBirth, PlayersType.GOALKEEPER, 90, 90);
        attackerC1 = new Attacker("Roberta", dateOfBirth, PlayersType.ATTACKER1, 90,90);
        defenderC1 = new Defender("Judithe", dateOfBirth, PlayersType.DEFENDER1, 90, 90);
        attackerC2 = new Attacker("Renata", dateOfBirth, PlayersType.ATTACKER2, 90,90);
        defenderC2 = new Defender("Nazaré", dateOfBirth, PlayersType.DEFENDER2, 90, 90);

//        goalD = new Goalkeeper("Janaina", dateOfBirth, PlayersType.GOALKEEPER, -90, 90);
//        attackerD1 = new Attacker("Roberta", dateOfBirth, PlayersType.ATTACKER1, -90,90);
//        defenderD1 = new Defender("Judithe", dateOfBirth, PlayersType.DEFENDER1, -90, 90);
//        attackerD2 = new Attacker("Renata", dateOfBirth, PlayersType.ATTACKER2, -90,90);
//        defenderD2 = new Defender("Nazaré", dateOfBirth, PlayersType.DEFENDER2, -90, 90);

    }
    @BeforeEach
    private void addPlayers(){
        ArrayList team1 = new ArrayList<>();
        team1.add(goalA);
        team1.add(attackerA1);
        team1.add(defenderA1);
        team1.add(attackerA2);
        team1.add(defenderA2);
        t1.setTeamSkill(team1);

        ArrayList team2 = new ArrayList<>();
        team2.add(goalB);
        team2.add(attackerB1);
        team2.add(defenderB1);
        team2.add(attackerB2);
        team2.add(defenderB2);
        t2.setTeamSkill(team2);

        ArrayList team3 = new ArrayList<>();
        team3.add(goalC);
        team3.add(attackerC1);
        team3.add(defenderC1);
        team3.add(attackerC2);
        team3.add(defenderC2);
        t3.setTeamSkill(team3);

//        ArrayList team4 = new ArrayList<>();
//        team3.add(goalD);
//        team3.add(attackerD1);
//        team3.add(defenderD1);
//        team3.add(attackerD2);
//        team3.add(defenderD2);
//        t4.setTeamSkill(team4);
    }




    @Test
    void teamOneHasMoreSkill(){
        assertEquals(1, comp.compare(t1,t2));
    }
    @Test
        //esta quebrando, metodo retorn 0 ao inves de -1
    void teamTwoHasMoreSkill(){
        assertEquals(-1, comp.compare(t2,t1));
    }
    @Test
    void tie(){
        assertEquals(0, comp.compare(t1,t3));
    }

}