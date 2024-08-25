package listener

import org.bukkit.Material
import org.bukkit.entity.ExperienceOrb
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

@listener.Listener
class BlockBreak : Listener {
    @EventHandler
    fun onBlockBreak(event: BlockBreakEvent) {
        val b = event.block

        if (b.type != Material.SUGAR_CANE_BLOCK) return

        for (i in 1..3) {
            event.player.world.spawn(b.location, ExperienceOrb::class.java).experience = 5
        }
    }
}