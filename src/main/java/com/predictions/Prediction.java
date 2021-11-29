package com.predictions;

/**
 *
 * @author ddanylo
 */
public class Prediction {
    
    private long id;
    private String score;
    private long userId;
    private String date;

    public Prediction() {
    }

    public long getId() {
        return id;
    }

    public String getScore() {
        return score;
    }

    public long getUserId() {
        return userId;
    }

    public String getDate() {
        return date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Prediction{" + "id=" + id + ", score=" + score + ", userId=" + userId + ", date=" + date + '}';
    }
}