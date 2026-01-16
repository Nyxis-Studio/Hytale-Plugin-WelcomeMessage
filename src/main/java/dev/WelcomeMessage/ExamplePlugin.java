package dev.WelcomeMessage;

import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import dev.WelcomeMessage.commands.SetMessageCommand;
import dev.WelcomeMessage.commands.ToggleWelcomeCommand;
import dev.WelcomeMessage.commands.MessageCommand;
import dev.WelcomeMessage.listeners.WelcomeListener;
import dev.WelcomeMessage.listeners.ChatListener;
import com.hypixel.hytale.server.core.event.events.player.PlayerChatEvent;

import javax.annotation.Nonnull;

public class ExamplePlugin extends JavaPlugin {

    public ExamplePlugin(@Nonnull JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {
        this.getEventRegistry().registerGlobal(PlayerReadyEvent.class, WelcomeListener::onPlayerReady);
        this.getEventRegistry().registerGlobal(PlayerChatEvent.class, ChatListener::onPlayerChat);

        this.getCommandRegistry().registerCommand(new ToggleWelcomeCommand());
        this.getCommandRegistry().registerCommand(new SetMessageCommand());
        this.getCommandRegistry().registerCommand(new MessageCommand());
    }
}