package mod.linguardium.toastblock.mixin;

import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AdvancementDisplay.class)
public class AdvancementDisplayMixin {
    @Shadow @Final @Mutable
    private boolean showToast;

    @Inject(method="<init>",at=@At("RETURN"))
    private void ToastBlock$NoAdvancementToastConstructor(ItemStack icon, Text title, Text description, Identifier background, AdvancementFrame frame, boolean toast, boolean announceToChat, boolean hidden, CallbackInfo ci) {
        showToast=false;
    }
    @Inject(method="shouldShowToast",at=@At("HEAD"),cancellable = true)
    private void ToastBlock$NoAdvancementToast(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
