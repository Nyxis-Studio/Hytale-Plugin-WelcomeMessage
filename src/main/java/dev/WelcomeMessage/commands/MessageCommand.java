/*
 * Copyright (c) 2026 Nyxis. All rights reserved.
 */
package dev.WelcomeMessage.commands;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import com.hypixel.hytale.server.core.util.EventTitleUtil;
import dev.WelcomeMessage.managers.SettingsManager;

import javax.annotation.Nonnull;

public class MessageCommand extends AbstractPlayerCommand {

    public MessageCommand() {
        super("message", "Manually displays the welcome message");
    }

    @Override
    protected void execute(@Nonnull CommandContext commandContext, @Nonnull Store<EntityStore> store,
            @Nonnull Ref<EntityStore> ref, @Nonnull PlayerRef playerRef, @Nonnull World world) {

        String messageText = SettingsManager.getInstance().getWelcomeMessage();
        String messageSubtitle = SettingsManager.getInstance().getWelcomeSubtitle();

        EventTitleUtil.showEventTitleToPlayer(playerRef,
                Message.raw(messageText).color("#00FF00"),
                Message.raw(messageSubtitle).color("#AAAAAA"),
                true, null, 5, 2, 1);
    }
}
