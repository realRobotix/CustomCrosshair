package me.realrobotix.customcrosshair.render


class DotRenderer : ShapeRenderer() {
    override fun draw(vg: Long, x: Float, y: Float) {
        if (!cs.dotEnabled) return
        val renderColour: Int = getReactiveColor(
            cs.dotColor,
            if (cs.dotEnablePlayerColor) cs.dotPlayerColor else cs.dotColor,
            if (cs.dotEnableFriendlyColor) cs.dotFriendlyColor else cs.dotColor,
            if (cs.dotEnableHostileColor) cs.dotHostileColor else cs.dotColor
        ).rgb
        val renderSize: Float = cs.dotSize.toFloat()
        nanoVGHelper.translate(vg, x, y)
        nanoVGHelper.rotate(vg, cs.dotRotation.toDouble())
        when(cs.dotType) {
            0 -> nanoVGHelper.drawCircle(vg, 0.0f, 0.0f, renderSize, renderColour)
            1 -> nanoVGHelper.drawRect(vg, -renderSize/2.0f, -renderSize/2.0f, renderSize, renderSize, renderColour)
        }
    }
}