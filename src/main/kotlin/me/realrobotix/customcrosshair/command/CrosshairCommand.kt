package me.realrobotix.customcrosshair.command
import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main
import me.realrobotix.customcrosshair.config.CrosshairConfig

@Command("customcrosshair")
class CrosshairCommand {

    @Main
    fun execCommand() {
        CrosshairConfig.openGui()
    }
}
