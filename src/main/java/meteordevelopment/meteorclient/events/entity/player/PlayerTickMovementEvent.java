/*
 * This file is part of the Meteorlite Client tribution based off of Meteor Client, which can be found at: https://github.com/MeteorDevelopment/meteor-client.
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.events.entity.player;

/**
 * @see net.minecraft.client.network.ClientPlayerEntity#tickMovement()
 */
public class PlayerTickMovementEvent {
    private static final PlayerTickMovementEvent INSTANCE = new PlayerTickMovementEvent();

    public static PlayerTickMovementEvent get() {
        return INSTANCE;
    }
}
