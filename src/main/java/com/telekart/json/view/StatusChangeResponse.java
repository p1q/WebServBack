package com.telekart.json.view;

import com.telekart.domain.User;

public class StatusChangeResponse {
    private long userId;
    private User.Status previousStatus;
    private User.Status currentStatus;

    public StatusChangeResponse(long userId, User.Status previousStatus, User.Status currentStatus) {
        this.userId = userId;
        this.previousStatus = previousStatus;
        this.currentStatus = currentStatus;
    }

    public long getUserId() {
        return userId;
    }

    public User.Status getPreviousStatus() {
        return previousStatus;
    }

    public User.Status getCurrentStatus() {
        return currentStatus;
    }
}
