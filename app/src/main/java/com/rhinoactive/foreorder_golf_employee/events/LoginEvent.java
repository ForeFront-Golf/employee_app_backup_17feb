package com.rhinoactive.foreorder_golf_employee.events;

import lombok.Getter;

/**
 * Created by Hunter Andrin on 2017-04-28.
 */

public class LoginEvent {

    @Getter
    private boolean successful;

    public LoginEvent(boolean successful) {
        this.successful = successful;
    }
}
