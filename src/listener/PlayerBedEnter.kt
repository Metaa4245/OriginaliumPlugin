package listener

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerBedEnterEvent

@listener.Listener
class PlayerBedEnter : Listener {
    @EventHandler
    fun onPlayerBedEnter(event: PlayerBedEnterEvent) {
        val w = event.player.world
        val name = event.player.playerListName

        if (w.hasStorm()) w.setStorm(false)
        if (w.isThundering) w.isThundering = false

        w.fullTime += 24000L - w.time
        Bukkit.broadcastMessage("${ChatColor.DARK_GRAY}$name has slept.")
    }
}