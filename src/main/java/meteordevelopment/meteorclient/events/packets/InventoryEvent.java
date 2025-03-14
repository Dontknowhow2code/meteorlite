/*
 * This file is part of the Meteorlite Client tribution based off of Meteor Client, which can be found at: https://github.com/MeteorDevelopment/meteor-client.
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.events.packets;

import net.minecraft.network.packet.s2c.play.InventoryS2CPacket;

public class InventoryEvent {
    private static final InventoryEvent INSTANCE = new InventoryEvent();

    public InventoryS2CPacket packet;

    public static InventoryEvent get(InventoryS2CPacket packet) {
        INSTANCE.packet = packet;
        return INSTANCE;
    }
}
