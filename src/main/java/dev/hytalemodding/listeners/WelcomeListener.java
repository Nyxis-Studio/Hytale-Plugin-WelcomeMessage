package dev.hytalemodding.listeners;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.util.EventTitleUtil;
import dev.hytalemodding.managers.SettingsManager;

public class WelcomeListener {

    public static void onPlayerReady(PlayerReadyEvent event) {
        if (SettingsManager.getInstance().isWelcomeEnabled()) {
            String messageText = SettingsManager.getInstance().getWelcomeMessage();
            String messageSubtitle = SettingsManager.getInstance().getWelcomeSubtitle();

            // Using EventTitleUtil for big on-screen message
            // Delay the message to ensure player is fully ready
            new java.util.Timer().schedule(new java.util.TimerTask() {
                @Override
                public void run() {
                    EventTitleUtil.showEventTitleToPlayer(event.getPlayer().getPlayerRef(),
                            Message.raw(messageText).color("#00FF00"),
                            Message.raw(messageSubtitle).color("#AAAAAA"),
                            true, null, 5, 2, 1);
                }
            }, 2000L); // 2 seconds delay
        }
    }
}
