package me.meta4245.originaliumplugin.listener

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.weather.LightningStrikeEvent

@me.meta4245.originaliumplugin.listener.Listener
class LightningStrike : Listener {
    @EventHandler
    fun onLightningStrike(event: LightningStrikeEvent) {
        event.isCancelled = true
    }
}