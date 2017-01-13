package br.home.myfirsttestproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Ronan.lima on 09/01/17.
 */
public class RecyclerViewTemplate extends RecyclerView.Adapter<RecyclerViewTemplate.ViewHolder> {
    private static final String TAG = RecyclerViewTemplate.class.getCanonicalName();

    private Context mContext;
    private List<Object> mData;

    /**
     * Change {@link list} type according to your needs
     */
    public RecyclerViewTemplate(Context context, List<Object> data) {
        if (context == null) {
            throw new NullPointerException("context can not be null");
        }
        if (data == null) {
            throw new NullPointerException("ata list can not be null");
        }
        this.mContext = context;
        this.mData = data;
    }

    /**
     * Change the null parameter to a layout resource {@code R.layout.example}
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(null, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // include binding logic here
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // include {@link view} components here

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}