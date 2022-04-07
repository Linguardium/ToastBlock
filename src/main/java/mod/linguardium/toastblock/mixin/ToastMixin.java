package mod.linguardium.toastblock.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.toast.Toast;
import net.minecraft.client.toast.ToastManager;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ToastManager.class)
public class ToastMixin {
	@Inject(at = @At("HEAD"), method = "add", cancellable = true)
	private void ToastBlock$ToastBlocker(Toast toast, CallbackInfo info) {
		info.cancel();
	}
	@Inject(method="draw", cancellable = true, at=@At("HEAD"))
	private void ToastBlock$DrawBlocker(MatrixStack matrices, CallbackInfo ci) {
		ci.cancel();
	}
}
