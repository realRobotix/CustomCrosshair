package me.realrobotix.customcrosshair


import cc.polyfrost.oneconfig.libs.universal.UResolution
import cc.polyfrost.oneconfig.renderer.NanoVGHelper
import me.realrobotix.customcrosshair.config.CrosshairConfig
import me.realrobotix.customcrosshair.render.*
import net.minecraft.client.Minecraft
import net.minecraftforge.client.event.GuiScreenEvent.DrawScreenEvent
import net.minecraftforge.client.event.RenderGameOverlayEvent
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent


@Mod(
    modid = CustomCrosshair.MODID,
    name = CustomCrosshair.NAME,
    version = CustomCrosshair.VERSION,
    modLanguageAdapter = "cc.polyfrost.oneconfig.utils.KotlinLanguageAdapter"
)
object CustomCrosshair {
    const val MODID = "@ID@"
    const val NAME = "@NAME@"
    const val VERSION = "@VER@"

    val mc: Minecraft = Minecraft.getMinecraft()
    var drawAtCursor = false
    val elements: Array<ShapeRenderer> = arrayOf(CrossRenderer(), SquareRenderer(), CircleRenderer(), DotRenderer())

    @Mod.EventHandler
    fun onInit(event: FMLInitializationEvent) {
        CrosshairConfig
        MinecraftForge.EVENT_BUS.register(this)
    }

    fun drawCrosshair(x: Float, y: Float, mcScaling: Boolean = false) {
        for (element in elements) {
            NanoVGHelper.INSTANCE.setupAndDraw(mcScaling) { vg ->
                element.draw(vg, x, y)
            }
        }
    }

    @SubscribeEvent
    fun onRender(event: RenderGameOverlayEvent.Post) {
        if (event.type != RenderGameOverlayEvent.ElementType.CROSSHAIRS) return
        val gs = mc.gameSettings
        val cs = CrosshairConfig
        if (CrosshairConfig.enabled && if (gs.thirdPersonView > 0) cs.visibleThirdperson else if (gs.showDebugInfo && !mc.thePlayer.hasReducedDebug() && !mc.gameSettings.reducedDebugInfo) cs.visibleDebug else if (mc.playerController.isSpectator) cs.visibleSpectator else cs.visibleFirstperson) {
            if (cs.guiScaling) drawCrosshair(
                event.resolution.scaledWidth / 2.0f,
                event.resolution.scaledHeight / 2.0f,
                true
            ) else drawCrosshair(mc.displayWidth / 2.0f, mc.displayHeight / 2.0f, false)
        }
    }

    @SubscribeEvent
    fun onRender(event: DrawScreenEvent.Post) {
        if (drawAtCursor) {
            if (CrosshairConfig.guiScaling) drawCrosshair(
                event.mouseX.toFloat(),
                event.mouseY.toFloat(),
                true
            ) else drawCrosshair(
                event.mouseX.toFloat() * UResolution.scaleFactor.toFloat(),
                event.mouseY.toFloat() * UResolution.scaleFactor.toFloat(),
                false
            )
            drawAtCursor = false
        }
    }
}
