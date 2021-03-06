package com.mortarnav.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.mortarnav.R;
import com.mortarnav.stackable.HomeStackable;
import com.mortarnav.presenter.HomePresenter;

import javax.inject.Inject;

import architect.robot.DaggerService;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Lukasz Piliszczuk - lukasz.pili@gmail.com
 */
public class HomeAdditionalCustomView extends FrameLayout {

    @Inject
    protected HomePresenter presenter;

    public HomeAdditionalCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);

        DaggerService.<HomeStackable.Component>get(context).inject(this);

        View view = View.inflate(context, R.layout.home_additional_custom_view, this);
        ButterKnife.bind(view);
    }

    @OnClick
    void onClick() {
        presenter.customViewClick();
    }


}
