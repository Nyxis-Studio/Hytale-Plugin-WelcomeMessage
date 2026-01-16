package dev.WelcomeMessage.listeners;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.util.EventTitleUtil;
import dev.WelcomeMessage.managers.SettingsManager;

public class WelcomeListener {

    public static void onPlayerReady(PlayerReadyEvent event) {
        if (SettingsManager.getInstance().isWelcomeEnabled()) {
            String messageText = SettingsManager.getInstance().getWelcomeMessage();
            String messageSubtitle = SettingsManager.getInstance().getWelcomeSubtitle();

            new java.util.Timer().schedule(new java.util.TimerTask() {
                @Override
                public void run() {
                    EventTitleUtil.showEventTitleToPlayer(event.getPlayer().getPlayerRef(),
                            Message.raw(messageText).color("#00FF00"),
                            Message.raw(messageSubtitle).color("#AAAAAA"),
                            true, null, 5, 2, 1);
                }
            }, 2000L);
        }
    }
}
