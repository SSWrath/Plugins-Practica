package me.aleiv.core.paper.listeners;

import java.util.List;

import org.bukkit.Location;

public class ScreenPart {
    List<Location> locations;
    String text;

    public ScreenPart(List<Location> locations, String text){
        this.locations = locations;
        this.text = text;
    }
    
}
