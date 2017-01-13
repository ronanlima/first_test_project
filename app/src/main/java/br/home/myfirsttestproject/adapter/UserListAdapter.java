package br.home.myfirsttestproject.adapter;

import android.view.View;

import br.home.myfirsttestproject.adapter.holder.BasicViewHolder;
import br.home.myfirsttestproject.network.model.UserVO;

/**
 * Created by Ronan.lima on 13/01/17.
 */

public class UserListAdapter extends SimpleRecyclerAdapter<UserVO, UserItemView> {
    private OnItemClickListener listener;

    public UserListAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(BasicViewHolder viewHolder, int position) {
        super.onBindViewHolder(viewHolder, position);
        final UserVO user = itemList.get(position);
        ((UserItemView) viewHolder.getBinder()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null)
                    listener.onItemClick(user);
            }
        });
    }

    public interface OnItemClickListener {
        void onItemClick(UserVO item);
    }
}
