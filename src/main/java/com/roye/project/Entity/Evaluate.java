package com.roye.project.Entity;

public class Evaluate {
    private String id;
    private String oldEvaluate;
    private String oldWorks;
    private String hrEvaluate;
    private String selfEvaluate;
    private int selfScore;
    private int hrScore;
    private int oldScore;

    private Staff staffName;

    public Staff getStaffName() {
        return staffName;
    }

    public void setStaffName(Staff staffName) {
        this.staffName = staffName;
    }

    public int getSelfScore() {
        return selfScore;
    }

    public void setSelfScore(int selfScore) {
        this.selfScore = selfScore;
    }

    public int getHrScore() {
        return hrScore;
    }

    public void setHrScore(int hrScore) {
        this.hrScore = hrScore;
    }

    public int getOldScore() {
        return oldScore;
    }

    public void setOldScore(int oldScore) {
        this.oldScore = oldScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOldEvaluate() {
        return oldEvaluate;
    }

    public void setOldEvaluate(String oldEvaluate) {
        this.oldEvaluate = oldEvaluate;
    }

    public String getOldWorks() {
        return oldWorks;
    }

    public void setOldWorks(String oldWorks) {
        this.oldWorks = oldWorks;
    }

    public String getHrEvaluate() {
        return hrEvaluate;
    }

    public void setHrEvaluate(String hrEvaluate) {
        this.hrEvaluate = hrEvaluate;
    }

    public String getSelfEvaluate() {
        return selfEvaluate;
    }

    public void setSelfEvaluate(String selfEvaluate) {
        this.selfEvaluate = selfEvaluate;
    }
}
