package com.telekart.json.view;

import com.telekart.domain.User;

public class StatusChangeRequest {
    private User.Status status;

    public User.Status getStatus() {
        return status;
    }

    public void setStatus(User.Status status) {
        this.status = status;
    }
}
