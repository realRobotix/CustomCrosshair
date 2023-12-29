package me.realrobotix.customcrosshair.render

class SquareRenderer : ShapeRenderer() {
    override fun draw(vg: Long, x: Float, y: Float) {
        if (!cs.squareEnabled) return
        val color: Int = getReactiveColor(
            cs.squareColor,
            if (cs.squareEnablePlayerColor) cs.squarePlayerColor else cs.squareColor,
            if (cs.squareEnableFriendlyColor) cs.squareFriendlyColor else cs.squareColor,
            if (cs.squareEnableHostileColor) cs.squareHostileColor else cs.squareColor
        ).rgb
        val height: Float = cs.squareHeight.toFloat()
        val width: Float = cs.squareWidth.toFloat()
        val gap: Float = if (cs.squareDynamicBow) cs.squareGap.toFloat() + (getDynamicBowValue() * cs.squareDynamicBowMultiplier * 5) else cs.squareGap.toFloat()
        val thickness: Float = cs.squareThickness.toFloat()
        val rounding: Float = cs.squareRounding.toFloat()
        val outline: Float = if (cs.outlineEnabled) cs.outlineWidth.toFloat() else 0.0f
        val outlineColor: Int = getReactiveColor(
            cs.outlineColor,
            if (cs.outlineEnablePlayerColor) cs.outlinePlayerColor else cs.outlineColor,
            if (cs.outlineEnableFriendlyColor) cs.outlineFriendlyColor else cs.outlineColor,
            if (cs.outlineEnableHostileColor) cs.outlineHostileColor else cs.outlineColor
        ).rgb
        nanoVGHelper.translate(vg, x, y)
        nanoVGHelper.rotate(vg, cs.squareRotation.toDouble())
        //draw upper line
        if (cs.squareTopLine) drawRoundedOutlinedRect(
            vg, -width / 2.0f, height / 2.0f + gap, width, -thickness, color, rounding, outline, outlineColor
        )
        //draw lower line
        if (cs.squareBottomLine) drawRoundedOutlinedRect(
            vg, width / 2.0f, -height / 2.0f - gap, -width, thickness, color, rounding, outline, outlineColor
        )
        //draw left line
        if (cs.squareLeftLine) drawRoundedOutlinedRect(
            vg, -width / 2.0f - gap, -height / 2.0f, thickness, height, color, rounding, outline, outlineColor
        )
        //draw right line
        if (cs.squareRightLine) drawRoundedOutlinedRect(
            vg, width / 2.0f + gap, height / 2.0f, -thickness, -height, color, rounding, outline, outlineColor
        )
    }
}