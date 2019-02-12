package ru.trandefil.tm.entity;

public class Session extends BaseEntity {

    private static final long serialVersionUID = 4L;

    private long timeStamp;

    private String userId;

    private Role role;

    private String signature;

    public Session(String id, long timeStamp, String userId, Role role, String signature) {
        super(id);
        this.timeStamp = timeStamp;
        this.userId = userId;
        this.role = role;
        this.signature = signature;
    }

    public Session() {
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
