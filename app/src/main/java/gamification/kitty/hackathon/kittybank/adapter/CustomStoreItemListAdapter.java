package gamification.kitty.hackathon.kittybank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import gamification.kitty.hackathon.kittybank.R;
import gamification.kitty.hackathon.kittybank.entity.ItemStore;

/**
 * Created by User on 4/21/2018.
 */

public class CustomStoreItemListAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private Context context;
    private List<ItemStore> data;

    public CustomStoreItemListAdapter(Context context, List<ItemStore> data) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    static class ViewHolder{
        TextView test;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            view = layoutInflater.inflate(R.layout.layout_list_store_item,null);
            holder = new ViewHolder();
            holder.test = (TextView) view.findViewById(R.id.Test);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        ItemStore itemStore = this.data.get(i);
        holder.test.setText(itemStore.getName() + itemStore.getPrice());
        return view;
    }
}
