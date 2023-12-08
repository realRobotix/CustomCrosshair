package me.realrobotix.customcrosshair.render


class CrossRenderer : ShapeRenderer() {
    override fun draw(vg: Long, x: Float, y: Float) {
        if (!cs.crossEnabled) return
        val color: Int = getReactiveColor(
            cs.crossColor,
            if (cs.crossEnablePlayerColor) cs.crossPlayerColor else cs.crossColor,
            if (cs.crossEnableFriendlyColor) cs.crossFriendlyColor else cs.crossColor,
            if (cs.crossEnableHostileColor) cs.crossHostileColor else cs.crossColor
        ).rgb
        val gap: Float = cs.crossGap.toFloat()
        val height: Float = cs.crossHeight.toFloat()
        val width: Float = cs.crossWidth.toFloat()
        val thickness: Float = cs.crossThickness.toFloat()
        val rounding: Float = cs.crossRounding.toFloat()
        val outline: Float = if (cs.outlineEnabled) cs.outlineWidth.toFloat() else 0.0f
        val outlineColor: Int = getReactiveColor(
            cs.outlineColor,
            if (cs.outlineEnablePlayerColor) cs.outlinePlayerColor else cs.outlineColor,
            if (cs.outlineEnableFriendlyColor) cs.outlineFriendlyColor else cs.outlineColor,
            if (cs.outlineEnableHostileColor) cs.outlineHostileColor else cs.outlineColor
        ).rgb
        nanoVGHelper.translate(vg, x, y)
        nanoVGHelper.rotate(vg, Math.toRadians(cs.crossRotation.toDouble()).toFloat())
        //draw upper line
        if (cs.crossTopLine) drawRoundedOutlinedRect(
            vg, -thickness / 2.0f, -gap, thickness, -gap - height, color, rounding, outline, outlineColor
        )
        //draw lower line
        if (cs.crossBottomLine) drawRoundedOutlinedRect(
            vg, -thickness / 2.0f, gap, thickness, gap + height, color, rounding, outline, outlineColor
        )
        //draw left line
        if (cs.crossLeftLine) drawRoundedOutlinedRect(
            vg, -gap, -thickness / 2.0f, -gap - width, thickness, color, rounding, outline, outlineColor
        )
        //draw right line
        if (cs.crossRightLine) drawRoundedOutlinedRect(
            vg, gap, -thickness / 2.0f, gap + width, thickness, color, rounding, outline, outlineColor
        )
    }
}
