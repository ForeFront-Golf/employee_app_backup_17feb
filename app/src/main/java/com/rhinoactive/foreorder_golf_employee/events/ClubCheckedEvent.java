package com.rhinoactive.foreorder_golf_employee.events;

import com.rhinoactive.foreorder_golf_employee.models.ClubMenus;

import lombok.Getter;

/**
 * Created by Hunter Andrin on 2017-05-04.
 */

public class ClubCheckedEvent {

    @Getter
    private ClubMenus clubMenus;

    public ClubCheckedEvent(ClubMenus clubMenus) {
        this.clubMenus = clubMenus;
    }
}
