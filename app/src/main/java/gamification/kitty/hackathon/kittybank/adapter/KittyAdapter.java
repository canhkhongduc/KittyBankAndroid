package gamification.kitty.hackathon.kittybank.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import gamification.kitty.hackathon.kittybank.activity.R;
import gamification.kitty.hackathon.kittybank.entity.Kitty;
import gamification.kitty.hackathon.kittybank.listener.RecyclerViewClickListener;

public class KittyAdapter extends RecyclerView.Adapter<KittyAdapter.ViewHolder> {
    private static List<Kitty> kittyList;
    private static RecyclerViewClickListener itemListener;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imgKitty;
        public ImageView imgHunger;

        public ViewHolder(View itemView) {
            super(itemView);

            imgKitty = itemView.findViewById(R.id.kitty_home_img_pet);
            imgHunger = itemView.findViewById(R.id.kitty_home_hunger);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemListener.recyclerViewListClicked(v, this.getPosition());
        }
    }

    public KittyAdapter(List<Kitty> kittyList, RecyclerViewClickListener itemListener) {
        this.kittyList = kittyList;
        this.itemListener = itemListener;
    }

    @Override
    public KittyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_pet_list, parent, false);
        KittyAdapter.ViewHolder vh = new KittyAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(KittyAdapter.ViewHolder holder, int position) {
        Uri uri = Uri.parse("android.resource://gamification.kitty.hackathon.kittybank/drawable/" + kittyList.get(position).getImage() + "_static");
        Uri uri2 = Uri.parse("android.resource://gamification.kitty.hackathon.kittybank/drawable/meat");

        holder.imgKitty.setImageURI(uri);

        if (kittyList.get(position).getHunger() <= 15) {
            holder.imgHunger.setImageURI(uri2);
        }
    }

    @Override
    public int getItemCount() {
        return kittyList.size();
    }
}
