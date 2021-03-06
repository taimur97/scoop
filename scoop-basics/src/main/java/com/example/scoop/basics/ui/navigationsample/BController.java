package com.example.scoop.basics.ui.navigationsample;

import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;
import com.example.scoop.basics.R;
import com.example.scoop.basics.rx.ViewSubscriptions;
import com.example.scoop.basics.scoop.AppRouter;
import com.example.scoop.basics.scoop.ControllerModule;
import com.lyft.scoop.EnterTransition;
import com.lyft.scoop.ExitTransition;
import com.lyft.scoop.ParentController;
import com.lyft.scoop.Screen;
import com.lyft.scoop.ViewController;
import com.lyft.scoop.transitions.BackwardSlideTransition;
import com.lyft.scoop.transitions.FadeTransition;
import com.lyft.scoop.transitions.ForwardSlideTransition;
import dagger.Provides;
import javax.inject.Inject;
import javax.inject.Singleton;

@ControllerModule(BController.Module.class)
@ParentController(AController.class)
@EnterTransition(ForwardSlideTransition.class)
@ExitTransition(BackwardSlideTransition.class)
public class BController extends ViewController {

    public static Screen createScreen() {
        return Screen.create(BController.class);
    }

    @dagger.Module(
            injects = BController.class,
            addsTo = AController.Module.class,
            library = true
    )
    public static class Module {
    }

    private AppRouter appRouter;

    @Inject
    public BController(AppRouter appRouter) {
        this.appRouter = appRouter;
    }

    @Override
    protected int layoutId() {
        return R.layout.b;
    }

    @Override
    public void attach(View view) {
        super.attach(view);

    }

    @Override
    public void detach(View view) {
        super.detach(view);
    }

    @OnClick(R.id.go_up_button)
    public void goUp() {
        appRouter.goUp();
    }

    @OnClick(R.id.go_to_c_button)
    public void goToB() {
        appRouter.goTo(CController.createScreen());
    }
}
