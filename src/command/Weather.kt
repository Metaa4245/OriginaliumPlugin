package command

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.World
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

@command.Command("weather")
class Weather : CommandExecutor {
    private fun storm(w: World) {
        w.setStorm(!w.hasStorm())
    }

    private fun thunder(w: World) {
        w.isThundering = !w.isThundering
    }

    override fun onCommand(
        sender: CommandSender,
        cmd: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (!cmd.name.equals("weather")) return false
        if (sender !is Player) {
            sender.sendMessage("This command can only be run by a player.")
            return true
        }
        if (args.isEmpty()) return false

        val w = sender.world
        val message = "${ChatColor.DARK_GRAY}${sender.playerListName}"

        when (args[0]) {
            "storm" -> {
                storm(w)
                Bukkit.broadcastMessage("$message toggled storming.")
            }

            "thunder" -> {
                thunder(w)
                Bukkit.broadcastMessage("$message toggled thundering.")
            }

            "clear" -> {
                storm(w)
                thunder(w)
                Bukkit.broadcastMessage("$message cleared weather.")
            }

            else -> sender.sendMessage("Unknown subcommand.")
        }

        return true
    }
}