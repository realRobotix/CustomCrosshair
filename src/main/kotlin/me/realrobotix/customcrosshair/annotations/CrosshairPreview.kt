package me.realrobotix.customcrosshair.annotations

import cc.polyfrost.oneconfig.config.annotations.CustomOption

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
@CustomOption(id = "crosshairPreview")
annotation class CrosshairPreview(
    val size: Int = 0,
    val category: String = "General",
    val subcategory: String = ""
)
