package com.roye.project.Entity;

import java.sql.Timestamp;

public class TakeOff {
    private String id;
    private String type;
    private Timestamp regTime;
    private Timestamp backTime;
    private String reason;
    private int hrCheck;
    private String hrMsg;
    private int leaderCheck;
    private String leaderMsg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getRegTime() {
        return regTime;
    }

    public void setRegTime(Timestamp outTime) {
        this.regTime = outTime;
    }

    public Timestamp getBackTime() {
        return backTime;
    }

    public void setBackTime(Timestamp backTime) {
        this.backTime = backTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getHrCheck() {
        return hrCheck;
    }

    public void setHrCheck(int hrCheck) {
        this.hrCheck = hrCheck;
    }

    public int getLeaderCheck() {
        return leaderCheck;
    }

    public void setLeaderCheck(int leaderCheck) {
        this.leaderCheck = leaderCheck;
    }

    public String getHrMsg() {
        return hrMsg;
    }

    public void setHrMsg(String hrMsg) {
        this.hrMsg = hrMsg;
    }


    public String getLeaderMsg() {
        return leaderMsg;
    }

    public void setLeaderMsg(String leaderMsg) {
        this.leaderMsg = leaderMsg;
    }
}
