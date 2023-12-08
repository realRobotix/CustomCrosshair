package me.realrobotix.customcrosshair.render

import cc.polyfrost.oneconfig.config.core.OneColor
import cc.polyfrost.oneconfig.renderer.NanoVGHelper
import me.realrobotix.customcrosshair.CustomCrosshair
import me.realrobotix.customcrosshair.config.CrosshairConfig
import net.minecraft.entity.EntityAgeable
import net.minecraft.entity.boss.EntityDragon
import net.minecraft.entity.boss.EntityDragonPart
import net.minecraft.entity.monster.EntityGolem
import net.minecraft.entity.monster.EntityMob
import net.minecraft.entity.monster.EntitySlime
import net.minecraft.entity.passive.EntityAmbientCreature
import net.minecraft.entity.passive.EntityWaterMob
import net.minecraft.entity.player.EntityPlayer


abstract class ShapeRenderer {
    val nanoVGHelper: NanoVGHelper = NanoVGHelper.INSTANCE
    val cs = CrosshairConfig
    abstract fun draw(vg: Long, x: Float, y: Float)
    fun drawRoundedOutlinedRect(
        vg: Long,
        x: Float,
        y: Float,
        w: Float,
        h: Float,
        color: Int,
        r: Float,
        outline: Float,
        outlineColor: Int
    ) {
        if (outline > 0.0f) nanoVGHelper.drawRoundedRect(
            vg,
            x - if (w < 0.0f) -outline else outline,
            y - if (h < 0.0f) -outline else outline,
            w + (if (w < 0) -outline else outline) * 2,
            h + (if (h < 0) -outline else outline) * 2,
            outlineColor,
            r
        )
        nanoVGHelper.drawRoundedRect(vg, x, y, w, h, color, r)
    }

    fun getEntityLookingAtType(): Int {
        if (CustomCrosshair.mc.theWorld == null) return -1
        val entity = CustomCrosshair.mc.objectMouseOver.entityHit ?: return -1
        return when (entity) {
            is EntityPlayer -> 0
            is EntityAgeable -> 1
            is EntityWaterMob -> 1
            is EntityAmbientCreature -> 1
            is EntityMob -> 2
            is EntityGolem -> 2
            is EntitySlime -> 2
            is EntityDragon -> 2
            is EntityDragonPart -> 2
            else -> -1
        }
    }
    fun getReactiveColor(defaultColor: OneColor, playerColor: OneColor, passiveColor: OneColor, hostileColor: OneColor): OneColor {
        return when (getEntityLookingAtType()) {
            0 -> playerColor
            1 -> passiveColor
            2 -> hostileColor
            else -> defaultColor
        }
    }
}
