/*
 * This file is part of the Meteorlite Client tribution based off of Meteor Client, which can be found at: https://github.com/MeteorDevelopment/meteor-client.
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.utils.network;

public class OnlinePlayers {
    private static long lastPingTime;

    private OnlinePlayers() {
    }

    public static void update() {
        long time = System.currentTimeMillis();

        if (time - lastPingTime > 5 * 60 * 1000) {
            MeteorExecutor.execute(() -> Http.post("https://meteorclient.com/api/online/ping").ignoreExceptions().send());

            lastPingTime = time;
        }
    }

    public static void leave() {
        MeteorExecutor.execute(() -> Http.post("https://meteorclient.com/api/online/leave").ignoreExceptions().send());
    }
}
