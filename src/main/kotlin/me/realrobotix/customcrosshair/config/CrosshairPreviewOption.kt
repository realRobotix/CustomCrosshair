package me.realrobotix.customcrosshair.config

import cc.polyfrost.oneconfig.config.elements.BasicOption
import cc.polyfrost.oneconfig.renderer.scissor.ScissorHelper
import cc.polyfrost.oneconfig.utils.InputHandler
import cc.polyfrost.oneconfig.utils.dsl.nanoVGHelper
import me.realrobotix.customcrosshair.CustomCrosshair
import java.lang.reflect.Field


class CrosshairPreviewOption(field: Field?, parent: Any?, name: String?, category: String?, subcategory: String?, size: Int) :
    BasicOption(field, parent, name, "", category, subcategory, size) {
    override fun draw(vg: Long, x: Int, y: Int, inputHandler: InputHandler) {
        CustomCrosshair.drawCrosshair(x.toFloat()+496f, y.toFloat()+32f)
    }

    override fun getHeight(): Int {
        return 64
    }
}
