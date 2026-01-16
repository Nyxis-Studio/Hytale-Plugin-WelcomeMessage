/*
 * Copyright (c) 2026 Nyxis. All rights reserved.
 */
package dev.WelcomeMessage.commands;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import dev.WelcomeMessage.managers.SettingsManager;

import javax.annotation.Nonnull;

public class ToggleWelcomeCommand extends AbstractPlayerCommand {

    public ToggleWelcomeCommand() {
        super("togglewelcome", "Toggles the welcome message");
    }

    @Override
    protected void execute(@Nonnull CommandContext commandContext, @Nonnull Store<EntityStore> store,
            @Nonnull Ref<EntityStore> ref, @Nonnull PlayerRef playerRef, @Nonnull World world) {
        Player player = commandContext.senderAs(Player.class);

        boolean newState = !SettingsManager.getInstance().isWelcomeEnabled();
        SettingsManager.getInstance().setWelcomeEnabled(newState);

        String stateStr = newState ? "ON" : "OFF";
        String color = newState ? "#00FF00" : "#FF0000";

        player.sendMessage(Message.raw("Welcome message is now " + stateStr).color(color));
    }
}
