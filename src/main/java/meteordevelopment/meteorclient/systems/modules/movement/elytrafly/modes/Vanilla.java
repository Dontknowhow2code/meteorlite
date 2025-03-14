/*
 * This file is part of the Meteorlite Client tribution based off of Meteor Client, which can be found at: https://github.com/MeteorDevelopment/meteor-client.
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.systems.modules.movement.elytrafly.modes;

import meteordevelopment.meteorclient.systems.modules.movement.elytrafly.ElytraFlightMode;
import meteordevelopment.meteorclient.systems.modules.movement.elytrafly.ElytraFlightModes;

public class Vanilla extends ElytraFlightMode {
    public Vanilla() {
        super(ElytraFlightModes.Vanilla);
    }
    
    @Override
    public void onActivate() {
        elytraFly.error("This module has been removed in meteorlite.");
        elytraFly.toggle();
    }
}
