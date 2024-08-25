package me.meta4245.originaliumplugin

import me.meta4245.originaliumplugin.command.Command
import me.meta4245.originaliumplugin.listener.Listener
import org.bukkit.Bukkit
import org.bukkit.command.CommandExecutor
import org.bukkit.plugin.java.JavaPlugin
import org.reflections.Reflections

class Main : JavaPlugin() {
    override fun onEnable() {
        val commands = Reflections("me.meta4245.originaliumplugin.command")
        val listeners = Reflections("me.meta4245.originaliumplugin.listener")

        commands.getTypesAnnotatedWith(Command::class.java)
            .forEach { clazz ->
                val annotation: Command = clazz.getAnnotation(Command::class.java)
                val instance = clazz.getDeclaredConstructor().newInstance()
                        as CommandExecutor
                getCommand(annotation.name).executor = instance
            }

        val manager = Bukkit.getPluginManager()
        listeners.getTypesAnnotatedWith(Listener::class.java)
            .forEach { clazz ->
                manager.registerEvents(
                    clazz.getDeclaredConstructor().newInstance()
                            as org.bukkit.event.Listener?,
                    this
                )
            }
    }
}