package me.meta4245.originaliumplugin.listener

import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityExplodeEvent

@me.meta4245.originaliumplugin.listener.Listener
class EntityExplode : Listener {
    @EventHandler
    fun onEntityExplode(event: EntityExplodeEvent) {
        if (event.entityType == EntityType.CREEPER) {
            event.isCancelled = true
        }
    }
}