package dev.hytalemodding.listeners;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.event.events.player.PlayerChatEvent;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import dev.hytalemodding.managers.SettingsManager;

public class ChatListener {

    public static void onPlayerChat(PlayerChatEvent event) {
        String playerKey = event.getSender().toString();

        if (SettingsManager.getInstance().isAwaitingInput(playerKey)) {
            String input = event.getContent();
            String stage = SettingsManager.getInstance().getInputStage(playerKey);

            if ("MESSAGE_UP".equals(stage)) {
                // Handle Message Up (Subtitle)
                if (!input.equalsIgnoreCase("skip")) {
                    SettingsManager.getInstance().setWelcomeSubtitle(input);
                } else {
                    SettingsManager.getInstance().setWelcomeSubtitle("");
                }
                SettingsManager.getInstance().setInputStage(playerKey, "MESSAGE_CENTER");
                event.getSender().sendMessage(Message.raw(
                        "Message Up set! Now type 'Message Center' (main title), or type 'skip' to leave it empty.")
                        .color("#FFFF00"));

            } else if ("MESSAGE_CENTER".equals(stage)) {
                // Handle Message Center (Title)
                if (!input.equalsIgnoreCase("skip")) {
                    SettingsManager.getInstance().setWelcomeMessage(input);
                } else { // Allow skipping main title too? User said "option to skip" for center too.
                    SettingsManager.getInstance().setWelcomeMessage("");
                }
                SettingsManager.getInstance().removeAwaitingInput(playerKey);

                event.getSender().sendMessage(Message.raw("Configuration finished!").color("#00FF00"));
                event.getSender().sendMessage(Message
                        .raw("Message Up: " + SettingsManager.getInstance().getWelcomeSubtitle()).color("#AAAAAA"));
                event.getSender().sendMessage(Message
                        .raw("Message Center: " + SettingsManager.getInstance().getWelcomeMessage()).color("#AAAAAA"));
            }

            // Cancel the message so it doesn't appear in chat
            event.setCancelled(true);
        }
    }
}
