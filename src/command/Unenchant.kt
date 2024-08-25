package command

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

@command.Command("unenchant")
class Unenchant : CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        cmd: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (!cmd.name.equals("unenchant")) return false
        if (sender !is Player) {
            sender.sendMessage("This command can only be run by a player.")
            return true
        }

        val i = sender.itemInHand
        if (i.enchantments.isEmpty()) {
            sender.sendMessage("${ChatColor.DARK_GRAY}This item doesn't have enchantments.")
        }
        i.enchantments.forEach { (e, _) -> i.removeEnchantment(e) }

        return true
    }
}