package me.realrobotix.customcrosshair.config

import cc.polyfrost.oneconfig.config.elements.BasicOption
import cc.polyfrost.oneconfig.utils.InputHandler
import me.realrobotix.customcrosshair.CustomCrosshair
import java.lang.reflect.Field


class CrosshairPreviewOption(field: Field?, parent: Any?, name: String?, category: String?, subcategory: String?, size: Int) :
    BasicOption(field, parent, name, "", category, subcategory, size) {
    override fun draw(vg: Long, x: Int, y: Int, inputHandler: InputHandler) {
        CustomCrosshair.drawAtCursor = true
    }

    override fun getHeight(): Int {
        return 32
    }
}
