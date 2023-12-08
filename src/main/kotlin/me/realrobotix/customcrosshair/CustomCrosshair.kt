package me.realrobotix.customcrosshair


import cc.polyfrost.oneconfig.renderer.NanoVGHelper
import me.realrobotix.customcrosshair.config.CrosshairConfig
import me.realrobotix.customcrosshair.render.CrossRenderer
import me.realrobotix.customcrosshair.render.DotRenderer
import me.realrobotix.customcrosshair.render.ShapeRenderer
import me.realrobotix.customcrosshair.render.SquareRenderer
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
    private val elements: Array<ShapeRenderer> = arrayOf(CrossRenderer(), SquareRenderer(), DotRenderer())

    @Mod.EventHandler
    fun onInit(event: FMLInitializationEvent) {
        CrosshairConfig
        MinecraftForge.EVENT_BUS.register(this)
    }

    private fun drawCrosshair(x: Float, y: Float, mcScaling: Boolean = false) {
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
        if (CrosshairConfig.enabled && if (gs.thirdPersonView > 0) cs.visibleThirdperson else if (gs.debugCamEnable) cs.visibleDebug else cs.visibleFirstperson) {
            if (cs.guiScaling) drawCrosshair(
                event.resolution.scaledWidth / 2.0f,
                event.resolution.scaledHeight / 2.0f,
                true
            ) else drawCrosshair(mc.displayWidth / 2.0f, mc.displayHeight / 2.0f, false)
        }
    }

    @SubscribeEvent
    fun onRender(event: DrawScreenEvent.Post) {
        if (CrosshairConfig.guiScaling) drawCrosshair(
            event.mouseX.toFloat(),
            event.mouseY.toFloat(),
            true
        ) else drawCrosshair(
            event.mouseX.toFloat() * (mc.displayWidth / event.gui.width),
            event.mouseY.toFloat() * (mc.displayHeight / event.gui.height),
            false
        )
    }
}
