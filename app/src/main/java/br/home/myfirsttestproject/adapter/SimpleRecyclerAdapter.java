package br.home.myfirsttestproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.home.myfirsttestproject.adapter.holder.BasicViewHolder;
import br.home.myfirsttestproject.adapter.holder.ViewBinder;

/**
 * Created by Ronan.lima on 13/01/17.
 */
public class SimpleRecyclerAdapter<T, V extends View & ViewBinder<T>> extends RecyclerView.Adapter<BasicViewHolder>{
    protected final List<T> itemList = new ArrayList<>();
    // Used to create views in the base viewholder
    protected ViewCreator<T, V> viewCreator;

    @Override
    public BasicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BasicViewHolder<>(viewCreator.createViewInstance(parent, viewType));
    }

    @Override
    public void onBindViewHolder(BasicViewHolder holder, int position) {
        holder.getBinder().bind(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void addAll(List<T> newItens) {
        final int start = this.itemList.size();
        this.itemList.addAll(newItens);
        notifyItemRangeChanged(0, itemList.size());
    }

    public boolean removeItem(final T item) {
        final int indexOnList = itemList.indexOf(item);
        if (indexOnList < 0) return false;
        notifyItemRemoved(indexOnList);
        itemList.remove(indexOnList);
        return true;
    }

    public final void removeItems(final T... items) {
        for (final T item : items) {
            removeItem(item);
        }
    }

    public boolean insertOrUpdateItem(T item) {
        final int indexOnAdapter = itemList.indexOf(item);
        final boolean wasEmpty = itemList.isEmpty();

        if (indexOnAdapter >= 0) {
            itemList.set(indexOnAdapter, item);
            final int indexOnAdapterAfter = itemList.indexOf(item);
            if (indexOnAdapter != indexOnAdapterAfter) {
                notifyItemMoved(indexOnAdapter, indexOnAdapterAfter);
            }
            notifyItemChanged(indexOnAdapterAfter);
        } else {
            itemList.add(0, item);
            notifyItemInserted(0);
        }
        return wasEmpty;
    }

    public List<T> getItemList() {
        return itemList;
    }

    public void clear() {
        itemList.clear();
        notifyDataSetChanged();
    }

    public void setViewCreator(ViewCreator<T, V> viewCreator) {
        this.viewCreator = viewCreator;
    }

    public boolean hasViewCreator() {
        return viewCreator != null;
    }

    public interface ViewCreator<T, V extends View & ViewBinder<T>> {
        V createViewInstance(ViewGroup parent, int viewType);
    }
}
