package me.aleiv.core.paper.listeners;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;

public class MainScreen {
    Location location1;
    Location location2;

    HashMap<String, ScreenPart> screen = new HashMap<>();

    public MainScreen(Location location1, Location location2) {
       
        this.location1 = location1;
        this.location2 = location2;

        this.screen.put("players", new ScreenPart(List.of(), "PLAYERS"));

    }

}
