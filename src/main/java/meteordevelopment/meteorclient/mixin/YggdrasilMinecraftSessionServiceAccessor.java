/*
 * This file is part of the Meteorlite Client tribution based off of Meteor Client, which can be found at: https://github.com/MeteorDevelopment/meteor-client.
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.mixin;

import com.mojang.authlib.Environment;
import com.mojang.authlib.yggdrasil.ServicesKeySet;
import com.mojang.authlib.yggdrasil.YggdrasilMinecraftSessionService;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.net.Proxy;

@Mixin(YggdrasilMinecraftSessionService.class)
public interface YggdrasilMinecraftSessionServiceAccessor {
    @Invoker("<init>")
    static YggdrasilMinecraftSessionService createYggdrasilMinecraftSessionService(final ServicesKeySet servicesKeySet, final Proxy proxy, final Environment env) {
        throw new UnsupportedOperationException();
    }
}
