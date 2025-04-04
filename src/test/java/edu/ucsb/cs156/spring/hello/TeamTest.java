package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;
    Team other;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    // case 1
    @Test
    public void equals_returns_true_for_same_object() {
        assertTrue(team.equals(team));
    }

    // case 2
    @Test
    public void equals_returns_false_for_different_class() {
        String randomName = "random-team";
        assertFalse(team.equals(randomName));
    }

    // case 3
    @Test
    public void equals_returns_false_for_different_name() {
        other = new Team("other-team");
        assertFalse(team.equals(other));
    }

    @Test
    public void equals_returns_false_for_different_members() {
        other = new Team("test-team");
        other.addMember("Bob");
        assertFalse(team.equals(other));
    }

    @Test
    public void equals_returns_true_for_identical_name_and_members() {
        Team sameTeam = new Team("test-team");
        sameTeam.addMember("Bob");
        team.addMember("Bob");
        assertTrue(team.equals(sameTeam));
    }

    @Test
    public void hashCode_returns_equal_for_same_content() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_mutation() {
        Team t = new Team();
        t.setName("foo");
        t.addMember("bar");
        int result = t.hashCode();
        int expectedResult = 130294;
        assertEquals(expectedResult, result);
    }
}
