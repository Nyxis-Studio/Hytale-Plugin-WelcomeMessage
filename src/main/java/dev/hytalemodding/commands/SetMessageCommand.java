package dev.hytalemodding.commands;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import dev.hytalemodding.managers.SettingsManager;

import javax.annotation.Nonnull;

public class SetMessageCommand extends AbstractPlayerCommand {

    public SetMessageCommand() {
        super("setmessage", "Sets the welcome message via chat");
    }

    @Override
    protected void execute(@Nonnull CommandContext commandContext, @Nonnull Store<EntityStore> store,
            @Nonnull Ref<EntityStore> ref, @Nonnull PlayerRef playerRef, @Nonnull World world) {
        Player player = commandContext.senderAs(Player.class);

        SettingsManager.getInstance().addAwaitingInput(player.getPlayerRef().toString());
        player.sendMessage(
                Message.raw("Type 'Message Up' (small text), or type 'skip' to leave it empty.").color("#FFFF00"));
    }
}
