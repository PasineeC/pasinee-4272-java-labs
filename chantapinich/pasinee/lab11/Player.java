package chantapinich.pasinee.lab11;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * This class, Player, represents a player with various attributes such as name, nationality, date of birth,
 * player type, gender, hobbies, sports, and years of experience. It implements the Serializable interface
 * for object serialization.
 * 
 * Attributes:
 * - name: Name of the player.
 * - nationality: Nationality of the player.
 * - dob: Date of birth of the player.
 * - playerType: Type of player.
 * - gender: Gender of the player.
 * - hobbies: List of hobbies of the player.
 * - sports: List of sports played by the player.
 * - year: Years of experience in sports.
 * 
 * Methods:
 * - Constructor: Initializes a Player object with the given attributes.
 * - Getter methods: Retrieve the values of the attributes.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

public class Player implements Serializable {
    private static final long serialVersionUID = -4850492772800500292L;
    protected String name, nationality, dob, playerType, gender;
    protected ArrayList<String> hobbies, sports;
    protected int year;

    public Player(String name, String nationality, String dob, String playerType, String gender,
            ArrayList<String> hobbies, ArrayList<String> sports, int year) {
        this.name = name;
        this.nationality = nationality;
        this.dob = dob;
        this.playerType = playerType;
        this.gender = gender;
        this.hobbies = hobbies;
        this.sports = sports;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getPlayerType() {
        return playerType;
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public ArrayList<String> getSports() {
        return sports;
    }

    public int getYear() {
        return year;
    }
}
