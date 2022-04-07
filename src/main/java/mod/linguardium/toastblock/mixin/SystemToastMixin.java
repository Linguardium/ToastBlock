package mod.linguardium.toastblock.mixin;

import net.minecraft.client.toast.SystemToast;
import net.minecraft.client.toast.ToastManager;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SystemToast.class)
public class SystemToastMixin {
    @Inject(method="show",at=@At("HEAD"),cancellable = true)
    private static void ToastBlock$NoSystemToast(ToastManager manager, SystemToast.Type type, Text title, Text description, CallbackInfo ci) {
        ci.cancel();
    }
}
