package CentralPoint;

import Database.DaoGeneric;
import Database.DaoManager;
import Database.DbTables;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kees on 16/03/2016.
 */
public class Mission implements Serializable{
    private int ID;
    private String name;
    private String description;
    private Date startTime;
    private Date lastUpdate;
    private Date endTime;
    private double locationX;
    private double locationY;
    private ArrayList<Team> teamsAssigned;

    public Mission(int ID, String name, String description, Date startTime, Date lastUpdate, Date endTime, double locationX, double locationY) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.lastUpdate = lastUpdate;
        this.endTime = endTime;
        this.locationX = locationX;
        this.locationY = locationY;
        this.teamsAssigned = null;
    }

    public int getID() {
        return ID;
    }


    public String getName() {
        return name;
    }



    public String getDescription() {
        return description;
    }



    public Date getStartTime() {
        return startTime;
    }



    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public double getLocationX() {
        return locationX;
    }

    public void setLocationX(double locationX) {
        this.locationX = locationX;
    }

    public double getLocationY() {
        return locationY;
    }

    public void setLocationY(double locationY) {
        this.locationY = locationY;
    }

    public ArrayList<Team> getTeamsAssigned() {
        return teamsAssigned;
    }

    public void setTeamsAssigned(ArrayList<Team> teamsAssigned) {
        this.teamsAssigned = teamsAssigned;
    }

    public boolean addTeamToJob(Team teamToAdd) {
        boolean addedToTeam = false;
        int counter = 0;
        for(Team team : teamsAssigned){
            if(teamToAdd.getName().equals(team.getName())){
                counter++;
            }
        }
        if(counter==0){
            teamsAssigned.add(teamToAdd);
            addedToTeam = true;
        }
        return addedToTeam;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public ObservableList getTeamsAssignedToMission(int id) {
        DaoManager.INSTANCE.open();
        DaoGeneric getAssignedMembers = DaoManager.INSTANCE.getDao(DbTables.PERSONEEL);
        return getAssignedMembers.getSpecificList(id);
    }
}
