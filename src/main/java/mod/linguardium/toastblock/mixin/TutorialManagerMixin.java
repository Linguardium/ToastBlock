package mod.linguardium.toastblock.mixin;

import net.minecraft.client.toast.TutorialToast;
import net.minecraft.client.tutorial.TutorialManager;
import org.checkerframework.checker.units.qual.A;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TutorialManager.class)
public class TutorialManagerMixin {
    @Inject(method="add", cancellable = true, at=@At("HEAD"))
    private void ToastBlock$TutorialBlocker(TutorialToast toast, int ticks, CallbackInfo ci) {
        ci.cancel();
    }

}
