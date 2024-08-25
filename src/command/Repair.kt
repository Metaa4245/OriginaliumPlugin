package command

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import kotlin.math.floor

@command.Command("repair")
class Repair : CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        cmd: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (!cmd.name.equals("repair")) return false
        if (sender !is Player) {
            sender.sendMessage("This command can only be run by a player.")
            return true
        }

        val i = sender.itemInHand
        val durability = i.durability

        if (durability == 0.toShort()) {
            sender.sendMessage("${ChatColor.DARK_GRAY}The item has full durability.")
        }

        val maxDurability = i.type.maxDurability
        val level = sender.level
        val xpRequired = maxDurability - (maxDurability - durability)
        val playerXp = floor(1.75 * (level * level) + (5 * level))

        if (xpRequired <= playerXp) {
            sender.exp = 0F
            sender.level = 0

            val newXp = playerXp - xpRequired
            sender.giveExp(newXp.toInt())
            i.durability = 0

            sender.sendMessage("${ChatColor.GREEN}You repaired ${i.type.name} for $xpRequired XP.")
        } else {
            sender.sendMessage("${ChatColor.DARK_GRAY}You need $xpRequired to repair this item.")
        }

        return true
    }
}