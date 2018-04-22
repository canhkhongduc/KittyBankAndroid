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

public class KittyAdapter extends RecyclerView.Adapter<KittyAdapter.ViewHolder> {
    private static List<Kitty> kittyList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgKitty;
        public ImageView imgHunger;

        public ViewHolder(View itemView) {
            super(itemView);

            imgKitty = itemView.findViewById(R.id.kitty_home_img_pet);
            imgHunger = itemView.findViewById(R.id.kitty_home_hunger);
        }
    }

    public KittyAdapter(List<Kitty> kittyList) {
        this.kittyList = kittyList;
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
        Uri uri = Uri.parse("android.resource://gamification.kitty.hackathon.kittybank/drawable/dragon1");
        Uri uri2 = Uri.parse("android.resource://gamification.kitty.hackathon.kittybank/drawable/meat");

//        holder.txtUser.setText(String.valueOf(kittyList.get(position).getUserId()));
//        holder.txtPet.setText(kittyList.get(position).getName());
//        holder.txtRank.setText(String.valueOf(kittyList.get(position).getRank()));
//        holder.txtLevel.setText(String.valueOf(kittyList.get(position).getLevel()));
//        holder.txtExp.setText(String.valueOf(kittyList.get(position).getExperience()));
        holder.imgKitty.setImageURI(uri);
        holder.imgHunger.setImageURI(uri2);
    }

    @Override
    public int getItemCount() {
        return kittyList.size();
    }
}
