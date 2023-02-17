package com.rhinoactive.foreorder_golf_employee.events;

import com.rhinoactive.foreorder_library_android.events.BooleanEvent;

/**
 * Created by Hunter Andrin on 2017-05-10.
 */

public class CompleteOrderEvent extends BooleanEvent {

    public CompleteOrderEvent(boolean successful) {
        super(successful);
    }
}
