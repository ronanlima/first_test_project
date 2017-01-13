package br.home.myfirsttestproject.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import br.home.myfirsttestproject.adapter.holder.ViewBinder;
import br.home.myfirsttestproject.network.model.UserVO;

/**
 * Created by Ronan.lima on 13/01/17.
 */

public class UserItemView extends RelativeLayout implements ViewBinder<UserVO> {
    public UserItemView(Context context) {
        super(context);
    }

    public UserItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UserItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public UserItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void bind(UserVO payload) {

    }
}
