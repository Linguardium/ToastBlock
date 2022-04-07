package mod.linguardium.toastblock.mixin;

import net.minecraft.client.toast.RecipeToast;
import net.minecraft.client.toast.ToastManager;
import net.minecraft.recipe.Recipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RecipeToast.class)
public class RecipeToastMixin {
    @Inject(method="show",at=@At("HEAD"),cancellable = true)
    private static void ToastBlock$RecipeBlock(ToastManager manager, Recipe<?> recipes, CallbackInfo ci) {
        ci.cancel();
    }
}
