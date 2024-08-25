package listener

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.weather.LightningStrikeEvent

@listener.Listener
class LightningStrike : Listener {
    @EventHandler
    fun onLightningStrike(event: LightningStrikeEvent) {
        event.isCancelled = true
    }
}