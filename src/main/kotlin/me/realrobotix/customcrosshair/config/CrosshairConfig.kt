package me.realrobotix.customcrosshair.config

import cc.polyfrost.oneconfig.config.Config
import cc.polyfrost.oneconfig.config.annotations.*
import cc.polyfrost.oneconfig.config.core.ConfigUtils
import cc.polyfrost.oneconfig.config.core.OneColor
import cc.polyfrost.oneconfig.config.data.Mod
import cc.polyfrost.oneconfig.config.data.ModType
import cc.polyfrost.oneconfig.config.elements.BasicOption
import cc.polyfrost.oneconfig.config.elements.OptionPage
import me.realrobotix.customcrosshair.CustomCrosshair
import me.realrobotix.customcrosshair.annotations.CrosshairPreview
import java.lang.reflect.Field

/**
 * The main Config entrypoint that extends the Config type and inits the config options.
 * See [this link](https://docs.polyfrost.cc/oneconfig/config/adding-options) for more config Options
 */
object CrosshairConfig : Config(Mod(CustomCrosshair.NAME, ModType.HUD), CustomCrosshair.MODID + ".json") {

    override fun getCustomOption(
        field: Field?,
        annotation: CustomOption,
        page: OptionPage?,
        mod: Mod?,
        migrate: Boolean
    ): BasicOption? {
        var option: BasicOption? = null
        when (annotation.id) {
            "crosshairPreview" -> {
                val myOption: CrosshairPreview = ConfigUtils.findAnnotation(field, CrosshairPreview::class.java)
                option = CrosshairPreviewOption(field, myOption, "Crosshair Preview", myOption.category, myOption.subcategory, myOption.size)
                ConfigUtils.getSubCategory(page, myOption.category, myOption.subcategory).options.add(option)
            }
        }
        return option
    }

    @Switch(name = "Adjust to Gui Scale", category = "General")
    var guiScaling = false

    @CrosshairPreview(category = "General")
    var a = "a"

    @Switch(name = "First Person", description = "Whether or not to show the crosshair in first person", category = "General", subcategory = "Visibility")
    var visibleFirstperson = true

    @Switch(name = "Third Person", description = "Whether or not to show the crosshair in third person", category = "General", subcategory = "Visibility")
    var visibleThirdperson = true

    @Switch(name = "Debug", description = "Whether or not to show the crosshair in debug mode", category = "General", subcategory = "Visibility")
    var visibleDebug = false

    @Switch(name = "Spectator", description = "Whether or not to show the crosshair in spectator mode", category = "General", subcategory = "Visibility")
    var visibleSpectator = true


    @Switch(name = "Cross", category = "Cross")
    var crossEnabled = true

    @CrosshairPreview(category = "Cross")
    var b = "b"

    @Slider(name = "Cross Width", min = 0f, max = 35f, step = 1, instant = true, category = "Cross", subcategory = "Size")
    var crossWidth = 12

    @Slider(name = "Cross Height", min = 0f, max = 35f, step = 1, instant = true, category = "Cross", subcategory = "Size")
    var crossHeight = 12

    @Slider(name = "Cross Gap", min = 0f, max = 10f, step = 1, instant = true, category = "Cross", subcategory = "Size")
    var crossGap = 4

    @Slider(name = "Cross Thickness", min = 0f, max = 10f, step = 1, instant = true, category = "Cross", subcategory = "Size")
    var crossThickness = 2

    @Slider(name = "Cross Rounding", min = 0f, max = 10f, step = 1, instant = true, category = "Cross", subcategory = "Size")
    var crossRounding = 1

    @Slider(name = "Cross Rotation", min = 0f, max = 360f, step = 1, instant = true, category = "Cross", subcategory = "Size")
    var crossRotation = 45

    @Switch(name = "Dynamic Bow", category = "Cross", subcategory = "Animation")
    var crossDynamicBow = true

    @Slider(name = "Dynamic Bow Multiplier", min = 0f, max = 10f, step = 1, instant = true, category = "Cross", subcategory = "Animation")
    var crossDynamicBowMultiplier = 4

    @Checkbox(name = "Top", category = "Cross", subcategory = "Lines")
    var crossTopLine = true

    @Checkbox(name = "Bottom", category = "Cross", subcategory = "Lines")
    var crossBottomLine = true

    @Checkbox(name = "Left", category = "Cross", subcategory = "Lines")
    var crossLeftLine = true

    @Checkbox(name = "Right", category = "Cross", subcategory = "Lines")
    var crossRightLine = true

    @Color(name = "Default Color", category = "Cross", subcategory = "Color", size = 0)
    var crossColor: OneColor = OneColor(100,100,255,10.0f)

    @Switch(name = "Player Color", category = "Cross", subcategory = "Color")
    var crossEnablePlayerColor = false

    @Color(name = "Player Color", category = "Cross", subcategory = "Color")
    var crossPlayerColor: OneColor = OneColor(0,0,255,255)

    @Switch(name = "Hostile Color", category = "Cross", subcategory = "Color")
    var crossEnableHostileColor = false

    @Color(name = "Hostile Color", category = "Cross", subcategory = "Color")
    var crossHostileColor: OneColor = OneColor(255,0,0,255)

    @Switch(name = "Friendly Color", category = "Cross", subcategory = "Color")
    var crossEnableFriendlyColor = false

    @Color(name = "Friendly Color", category = "Cross", subcategory = "Color")
    var crossFriendlyColor: OneColor = OneColor(0,255,0,255)


    @Switch(name = "Square", category = "Square")
    var squareEnabled = false

    @CrosshairPreview(category = "Square")
    var c = "c"

    @Slider(name = "Square Width", min = 0f, max = 35f, step = 1, instant = true, category = "Square", subcategory = "Size")
    var squareWidth = 12

    @Slider(name = "Square Height", min = 0f, max = 35f, step = 1, instant = true, category = "Square", subcategory = "Size")
    var squareHeight = 12

    @Slider(name = "Square Gap", min = 0f, max = 10f, step = 1, instant = true, category = "Square", subcategory = "Size")
    var squareGap = 0

    @Slider(name = "Square Thickness", min = 0f, max = 10f, step = 1, instant = true, category = "Square", subcategory = "Size")
    var squareThickness = 2

    @Slider(name = "Square Rounding", min = 0f, max = 10f, step = 1, instant = true, category = "Square", subcategory = "Size")
    var squareRounding = 1

    @Slider(name = "Square Rotation", min = 0f, max = 360f, step = 1, instant = true, category = "Square", subcategory = "Size")
    var squareRotation = 45

    @Switch(name = "Dynamic Bow", category = "Square", subcategory = "Animation")
    var squareDynamicBow = true

    @Slider(name = "Dynamic Bow Multiplier", min = 0f, max = 10f, step = 1, instant = true, category = "Square", subcategory = "Animation")
    var squareDynamicBowMultiplier = 4

    @Checkbox(name = "Top", category = "Square", subcategory = "Lines")
    var squareTopLine = true

    @Checkbox(name = "Bottom", category = "Square", subcategory = "Lines")
    var squareBottomLine = true

    @Checkbox(name = "Left", category = "Square", subcategory = "Lines")
    var squareLeftLine = true

    @Checkbox(name = "Right", category = "Square", subcategory = "Lines")
    var squareRightLine = true

    @Color(name = "Default Color", category = "Square", subcategory = "Color", size = 0)
    var squareColor: OneColor = OneColor(100,100,255,10.0f)

    @Switch(name = "Player Color", category = "Square", subcategory = "Color")
    var squareEnablePlayerColor = false

    @Color(name = "Player Color", category = "Square", subcategory = "Color")
    var squarePlayerColor: OneColor = OneColor(0,0,255,255)

    @Switch(name = "Hostile Color", category = "Square", subcategory = "Color")
    var squareEnableHostileColor = false

    @Color(name = "Hostile Color", category = "Square", subcategory = "Color")
    var squareHostileColor: OneColor = OneColor(255,0,0,255)

    @Switch(name = "Friendly Color", category = "Square", subcategory = "Color")
    var squareEnableFriendlyColor = false

    @Color(name = "Friendly Color", category = "Square", subcategory = "Color")
    var squareFriendlyColor: OneColor = OneColor(0,255,0,255)


    @Switch(name = "Circle", category = "Circle")
    var circleEnabled = false

    @CrosshairPreview(category = "Circle")
    var d = "d"

    @Slider(name = "Circle X Radius", min = 0f, max = 35f, step = 1, instant = true, category = "Circle", subcategory = "Size")
    var circleXRadius = 12

    @Slider(name = "Circle Y Radius", min = 0f, max = 35f, step = 1, instant = true, category = "Circle", subcategory = "Size")
    var circleYRadius = 12

    @Slider(name = "Circle Thickness", min = 0f, max = 10f, step = 1, instant = true, category = "Circle", subcategory = "Size")
    var circleThickness = 2

    @Slider(name = "Circle Rotation", min = 0f, max = 360f, step = 1, instant = true, category = "Circle", subcategory = "Size")
    var circleRotation = 45

    @Switch(name = "Dynamic Bow", category = "Circle", subcategory = "Animation")
    var circleDynamicBow = true

    @Slider(name = "Dynamic Bow Multiplier", min = 0f, max = 10f, step = 1, instant = true, category = "Circle", subcategory = "Animation")
    var circleDynamicBowMultiplier = 4

    @Color(name = "Default Color", category = "Circle", subcategory = "Color", size = 0)
    var circleColor: OneColor = OneColor(100,100,255,10.0f)

    @Switch(name = "Player Color", category = "Circle", subcategory = "Color")
    var circleEnablePlayerColor = false

    @Color(name = "Player Color", category = "Circle", subcategory = "Color")
    var circlePlayerColor: OneColor = OneColor(0,0,255,255)

    @Switch(name = "Hostile Color", category = "Circle", subcategory = "Color")
    var circleEnableHostileColor = false

    @Color(name = "Hostile Color", category = "Circle", subcategory = "Color")
    var circleHostileColor: OneColor = OneColor(255,0,0,255)

    @Switch(name = "Friendly Color", category = "Circle", subcategory = "Color")
    var circleEnableFriendlyColor = false

    @Color(name = "Friendly Color", category = "Circle", subcategory = "Color")
    var circleFriendlyColor: OneColor = OneColor(0,255,0,255)


    @Switch(name = "Outline", category = "Outline")
    var outlineEnabled = false

    @CrosshairPreview(category = "Outline")
    var e = "e"

    @Slider(name = "Outline Width", min = 0f, max = 10f, step = 1, instant = true, category = "Outline")
    var outlineWidth = 1

    @Color(name = "Default Color", category = "Outline", subcategory = "Color", size = 0)
    var outlineColor: OneColor = OneColor(100,100,255,10.0f)

    @Switch(name = "Player Color", category = "Outline", subcategory = "Color")
    var outlineEnablePlayerColor = false

    @Color(name = "Player Color", category = "Outline", subcategory = "Color")
    var outlinePlayerColor: OneColor = OneColor(0,0,255,255)

    @Switch(name = "Hostile Color", category = "Outline", subcategory = "Color")
    var outlineEnableHostileColor = false

    @Color(name = "Hostile Color", category = "Outline", subcategory = "Color")
    var outlineHostileColor: OneColor = OneColor(255,0,0,255)

    @Switch(name = "Friendly Color", category = "Outline", subcategory = "Color")
    var outlineEnableFriendlyColor = false

    @Color(name = "Friendly Color", category = "Outline", subcategory = "Color")
    var outlineFriendlyColor: OneColor = OneColor(0,255,0,255)


    @Switch(name = "Dot", category = "Dot")
    var dotEnabled = false

    @CrosshairPreview(category = "Dot")
    var f = "f"

    @Dropdown(name = "Dot Type", options = ["Circle", "Square"], category = "Dot")
    var dotType = 0

    @Slider(name = "Dot Size", min = 0f, max = 10f, step = 1, instant = true, category = "Dot")
    var dotSize = 0

    @Slider(name = "Dot Rotation", min = 0f, max = 360f, step = 1, instant = true, category = "Dot")
    var dotRotation = 45

    @Color(name= "Default Color", category = "Dot", subcategory = "Color", size = 0)
    var dotColor: OneColor = OneColor(100,100,255,10.0f)

    @Switch(name = "Player Color", category = "Dot", subcategory = "Color")
    var dotEnablePlayerColor = false

    @Color(name = "Player Color", category = "Dot", subcategory = "Color")
    var dotPlayerColor: OneColor = OneColor(0,0,255,255)

    @Switch(name = "Hostile Color", category = "Dot", subcategory = "Color")
    var dotEnableHostileColor = false

    @Color(name = "Hostile Color", category = "Dot", subcategory = "Color")
    var dotHostileColor: OneColor = OneColor(255,0,0,255)

    @Switch(name = "Friendly Color", category = "Dot", subcategory = "Color")
    var dotEnableFriendlyColor = false

    @Color(name = "Friendly Color", category = "Dot", subcategory = "Color")
    var dotFriendlyColor: OneColor = OneColor(0,255,0,255)
}
