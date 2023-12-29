package me.realrobotix.customcrosshair.render

import cc.polyfrost.oneconfig.renderer.LwjglManager


class CircleRenderer : ShapeRenderer() {
    override fun draw(vg: Long, x: Float, y: Float) {
        if (!cs.circleEnabled) return
        val color: Int = getReactiveColor(
            cs.circleColor,
            if (cs.circleEnablePlayerColor) cs.circlePlayerColor else cs.circleColor,
            if (cs.circleEnableFriendlyColor) cs.circleFriendlyColor else cs.circleColor,
            if (cs.circleEnableHostileColor) cs.circleHostileColor else cs.circleColor
        ).rgb
        val xRadius: Float = if (cs.circleDynamicBow) cs.circleXRadius.toFloat() + (getDynamicBowValue() * cs.circleDynamicBowMultiplier * 5) else cs.circleXRadius.toFloat()
        val yRadius: Float = if (cs.circleDynamicBow) cs.circleYRadius.toFloat() + (getDynamicBowValue() * cs.circleDynamicBowMultiplier * 5) else cs.circleYRadius.toFloat()
        val thickness: Float = cs.circleThickness.toFloat()
        val outline: Float = if (cs.outlineEnabled) cs.outlineWidth.toFloat() else 0.0f
        val outlineColor: Int = getReactiveColor(
            cs.outlineColor,
            if (cs.outlineEnablePlayerColor) cs.outlinePlayerColor else cs.outlineColor,
            if (cs.outlineEnableFriendlyColor) cs.outlineFriendlyColor else cs.outlineColor,
            if (cs.outlineEnableHostileColor) cs.outlineHostileColor else cs.outlineColor
        ).rgb
        nanoVGHelper.translate(vg, x, y)
        nanoVGHelper.rotate(vg, cs.circleRotation.toDouble())
        //draw circle
        drawOutlinedStrokeEllipse(
            vg, 0.0f, 0.0f, xRadius, yRadius, thickness, color, outline, outlineColor)
    }
}