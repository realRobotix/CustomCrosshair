package me.realrobotix.customcrosshair.mixin;

import me.realrobotix.customcrosshair.command.CrosshairCommand;
import me.realrobotix.customcrosshair.config.CrosshairConfig;
import net.minecraft.client.gui.GuiIngame;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GuiIngame.class)
public class GuiIngameMixin {
    @Inject(method = "showCrosshair", at = @At(value = "HEAD"), cancellable = true)
    private void onShowCrosshair(CallbackInfoReturnable<Boolean> ci) {
        ci.setReturnValue(!CrosshairConfig.INSTANCE.enabled);
    }
}
