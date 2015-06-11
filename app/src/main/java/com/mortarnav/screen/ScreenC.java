package com.mortarnav.screen;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.mortarnav.DaggerScope;
import com.mortarnav.DaggerService;
import com.mortarnav.MainActivity;
import com.mortarnav.view.ViewC;

import javax.inject.Inject;

import mortar.ViewPresenter;
import mortarnav.library.ScreenContextFactory;
import mortarnav.library.Screen;

/**
 * @author Lukasz Piliszczuk - lukasz.pili@gmail.com
 */
public class ScreenC extends Screen {

    @Override
    public View createView(Context context) {
        return new ViewC(context);
    }

    @Override
    public void configureMortarScope(ScreenContextFactory.BuilderContext builderContext) {
        builderContext.getScopeBuilder().withService(DaggerService.SERVICE_NAME, DaggerScreenC_Component.builder()
                .component((MainActivity.Component) builderContext.getParentScope().getService(DaggerService.SERVICE_NAME))
                .build());
    }

    @dagger.Component(dependencies = MainActivity.Component.class)
    @DaggerScope(Component.class)
    public interface Component {

        void inject(ViewC view);
    }

    @DaggerScope(Component.class)
    public static class Presenter extends ViewPresenter<ViewC> {

        @Inject
        public Presenter() {
        }

        @Override
        protected void onLoad(Bundle savedInstanceState) {

        }

        public void click() {

        }
    }
}
