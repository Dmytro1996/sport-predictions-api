package com.predictions;

/**
 *
 * @author ddanylo
 */
public class AlreadyPlayedPrediction extends Prediction {
    
    private String teams;
    private String result;

    public AlreadyPlayedPrediction() {
    }

    public String getTeams() {
        return teams;
    }
    
    public String getResult() {
        return result;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "AlreadyPlayedPrediction{"+ "id=" + getId() + ", score=" + getScore()
                + ", userId=" + getUserId() + ", date=" + getDate() + ", teams=" + teams + '}';
    }
}