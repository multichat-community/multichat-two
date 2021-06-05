package me.gadse.multichat2;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.plugin.Plugin;

@Plugin(
        id = "multichat2-sponge",
        name = "MultiChat2",
        description = "Spigot side of MultiChat2.",
        authors = {
                "Gadse"
        }
)
public class MultiChat2Sponge {

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
    }
}
