package me.realrobotix.customcrosshair.config

import cc.polyfrost.oneconfig.config.Config
import cc.polyfrost.oneconfig.config.annotations.*
import cc.polyfrost.oneconfig.config.core.OneColor
import cc.polyfrost.oneconfig.config.data.Mod
import cc.polyfrost.oneconfig.config.data.ModType
import me.realrobotix.customcrosshair.CustomCrosshair

/**
 * The main Config entrypoint that extends the Config type and inits the config options.
 * See [this link](https://docs.polyfrost.cc/oneconfig/config/adding-options) for more config Options
 */
object CrosshairConfig : Config(Mod(CustomCrosshair.NAME, ModType.HUD), CustomCrosshair.MODID + ".json") {

    init {
        initialize()
    }

    @Dropdown(name = "Crosshair Type", options = ["Default", "Cross", "Circle", "Square", "Arrow"], category = "General")
    var crosshairType = 1

    @Switch(name = "Dynamic Bow", category = "General")
    var dynamicBowEnabled = true

    @Switch(name = "Adjust to Gui Scale", category = "General")
    var guiScaling = false

    @Switch(name = "First Person", description = "Whether or not to show the crosshair in first person", category = "General", subcategory = "Visibility")
    var visibleFirstperson = true

    @Switch(name = "Third Person", description = "Whether or not to show the crosshair in third person", category = "General", subcategory = "Visibility")
    var visibleThirdperson = true

    @Switch(name = "Debug", description = "Whether or not to show the crosshair in debug mode", category = "General", subcategory = "Visibility")
    var visibleDebug = false


    @Switch(name = "Cross", category = "Cross")
    var crossEnabled = true

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

    @Checkbox(name = "Top", category = "Cross", subcategory = "Lines")
    var crossTopLine = true

    @Checkbox(name = "Bottom", category = "Cross", subcategory = "Lines")
    var crossBottomLine = true

    @Checkbox(name = "Left", category = "Cross", subcategory = "Lines")
    var crossLeftLine = true

    @Checkbox(name = "Right", category = "Cross", subcategory = "Lines")
    var crossRightLine = true

    @Color(name = "Default Color", category = "Cross", subcategory = "Color", size = 0)
    var crossColor: OneColor = OneColor(100,100,255,10000.0f)

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

    @Slider(name = "Square Width", min = 0f, max = 35f, step = 1, instant = true, category = "Square", subcategory = "Size")
    var squareWidth = 12

    @Slider(name = "Square Height", min = 0f, max = 35f, step = 1, instant = true, category = "Square", subcategory = "Size")
    var squareHeight = 12

    @Slider(name = "Square Thickness", min = 0f, max = 10f, step = 1, instant = true, category = "Square", subcategory = "Size")
    var squareThickness = 2

    @Slider(name = "Square Rounding", min = 0f, max = 10f, step = 1, instant = true, category = "Square", subcategory = "Size")
    var squareRounding = 1

    @Slider(name = "Square Rotation", min = 0f, max = 360f, step = 1, instant = true, category = "Square", subcategory = "Size")
    var squareRotation = 45

    @Checkbox(name = "Top", category = "Square", subcategory = "Lines")
    var squareTopLine = true

    @Checkbox(name = "Bottom", category = "Square", subcategory = "Lines")
    var squareBottomLine = true

    @Checkbox(name = "Left", category = "Square", subcategory = "Lines")
    var squareLeftLine = true

    @Checkbox(name = "Right", category = "Square", subcategory = "Lines")
    var squareRightLine = true

    @Color(name = "Default Color", category = "Square", subcategory = "Color", size = 0)
    var squareColor: OneColor = OneColor(100,100,255,10000.0f)

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


    @Switch(name = "Outline", category = "Outline")
    var outlineEnabled = false

    @Slider(name = "Outline Width", min = 0f, max = 10f, step = 1, instant = true, category = "Outline")
    var outlineWidth = 1

    @Color(name = "Default Color", category = "Outline", subcategory = "Color", size = 0)
    var outlineColor: OneColor = OneColor(100,100,255,10000.0f)

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

    @Dropdown(name = "Dot Type", options = ["Circle", "Square"], category = "Dot")
    var dotType = 0

    @Slider(name = "Dot Size", min = 0f, max = 10f, step = 1, instant = true, category = "Dot")
    var dotSize = 0

    @Color(name= "Default Color", category = "Dot", subcategory = "Color", size = 0)
    var dotColor: OneColor = OneColor(100,100,255,10000.0f)

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
