package listener

import org.bukkit.ChatColor
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent

@listener.Listener
class EntityDamageByEntity : Listener {
    @EventHandler
    fun onEntityDamageByEntity(event: EntityDamageByEntityEvent) {
        val damager = event.damager

        if (damager.type == EntityType.CREEPER) {
            event.isCancelled = true
        }
        if (event.entityType == EntityType.CREEPER) {
            event.damage = 5000
        }

        if (damager !is Player) return

        val name = event.entityType.name.ifEmpty {
            "Player"
        }
        val damage = event.damage

        damager.sendMessage("${ChatColor.AQUA}You hit $name. You dealt $damage damage.")
    }
}