package br.home.myfirsttestproject.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import br.home.myfirsttestproject.adapter.holder.ViewBinder;

/**
 * Created by Ronan.lima on 13/01/17.
 */
public class BasicViewHolder<T, V extends View & ViewBinder<T>> extends RecyclerView.ViewHolder {
    private final ViewBinder<T> binder;

    public BasicViewHolder(V itemView) {
        super(itemView);
        this.binder = itemView;
    }

    public ViewBinder<T> getBinder() {
        return binder;
    }
}