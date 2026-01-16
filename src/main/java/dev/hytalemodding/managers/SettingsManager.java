package dev.hytalemodding.managers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SettingsManager {
    private static SettingsManager instance;
    private boolean isWelcomeEnabled = false;
    private String welcomeMessage = "Welcome!";
    private String welcomeSubtitle = "";
    private final transient java.util.Set<String> awaitingInput = new java.util.HashSet<>();
    private final transient java.util.Map<String, String> inputStage = new java.util.HashMap<>();
    private final transient java.io.File file = new java.io.File("settings.json");
    private final transient com.google.gson.Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();

    private SettingsManager() {
    }

    public static SettingsManager getInstance() {
        if (instance == null) {
            instance = new SettingsManager();
            instance.load();
        }
        return instance;
    }

    public boolean isWelcomeEnabled() {
        return isWelcomeEnabled;
    }

    public void setWelcomeEnabled(boolean welcomeEnabled) {
        this.isWelcomeEnabled = welcomeEnabled;
        save();
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
        save();
    }

    public String getWelcomeSubtitle() {
        return welcomeSubtitle != null ? welcomeSubtitle : "";
    }

    public void setWelcomeSubtitle(String welcomeSubtitle) {
        this.welcomeSubtitle = welcomeSubtitle;
        save();
    }

    public void addAwaitingInput(String playerRef) {
        awaitingInput.add(playerRef);
        inputStage.put(playerRef, "MESSAGE_UP"); // Start with Message Up
    }

    public void removeAwaitingInput(String playerRef) {
        awaitingInput.remove(playerRef);
        inputStage.remove(playerRef);
    }

    public boolean isAwaitingInput(String playerRef) {
        return awaitingInput.contains(playerRef);
    }

    public String getInputStage(String playerRef) {
        return inputStage.getOrDefault(playerRef, "TITLE");
    }

    public void setInputStage(String playerRef, String stage) {
        inputStage.put(playerRef, stage);
    }

    private void load() {
        if (!file.exists()) {
            save();
            return;
        }
        try (FileReader reader = new FileReader(file)) {
            SettingsManager loaded = gson.fromJson(reader, SettingsManager.class);
            if (loaded != null) {
                this.isWelcomeEnabled = loaded.isWelcomeEnabled;
                this.welcomeMessage = loaded.welcomeMessage;
                this.welcomeSubtitle = loaded.welcomeSubtitle;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void save() {
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
