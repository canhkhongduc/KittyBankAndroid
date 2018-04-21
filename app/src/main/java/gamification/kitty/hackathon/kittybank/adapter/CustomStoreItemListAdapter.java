package gamification.kitty.hackathon.kittybank.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import gamification.kitty.hackathon.kittybank.activity.R;
import gamification.kitty.hackathon.kittybank.callback.IVolleyCallback;
import gamification.kitty.hackathon.kittybank.entity.ItemStore;
import gamification.kitty.hackathon.kittybank.request.StoreRequestManagement;

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
        TextView name;
        TextView description;
        TextView price;
        Button btnBuy;
        ImageView image;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            view = layoutInflater.inflate(R.layout.layout_list_store_item,null);
            holder = new ViewHolder();
            holder.name = (TextView) view.findViewById(R.id.tvItemName);
            holder.description = (TextView) view.findViewById(R.id.tvItemDescription);
            holder.price = (TextView) view.findViewById(R.id.tvPrice);
            holder.btnBuy = (Button) view.findViewById(R.id.btnBuy);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        final ItemStore itemStore = this.data.get(i);
        final StoreRequestManagement storeRequestManagement = new StoreRequestManagement(context);
        holder.name.setText(itemStore.getName());
        holder.description.setText(itemStore.getDescription());
        holder.price.setText("CP: "+itemStore.getPrice());
        holder.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, Integer.toString(itemStore.getId()), Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(context);
                }
                builder.setTitle("Buy entry")
                        .setMessage("Are you sure you want to buy this item?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with buy
                                storeRequestManagement.buyItem(new IVolleyCallback() {
                                    @Override
                                    public void onSuccess(String result) {
                                        Toast.makeText(context, "Buy item successfully!", Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onFailure(String message) {
                                        Toast.makeText(context, "Fail to buy this item!", Toast.LENGTH_SHORT).show();
                                    }
                                }, itemStore.getId(), itemStore.getName());
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
        return view;
    }
}
