package gamification.kitty.hackathon.kittybank.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import gamification.kitty.hackathon.kittybank.activity.R;
import gamification.kitty.hackathon.kittybank.entity.Kitty;

public class RankAdapter extends RecyclerView.Adapter<RankAdapter.ViewHolder> {
    private static List<Kitty> kittyList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtRank;
        public TextView txtUser;
        public TextView txtPet;
        public TextView txtLevel;
        public TextView txtExp;
        public ImageView imgKitty;

        public ViewHolder(View itemView) {
            super(itemView);

            txtRank = itemView.findViewById(R.id.rank_txt_rank);
            txtUser = itemView.findViewById(R.id.rank_txt_user);
            txtPet = itemView.findViewById(R.id.rank_txt_pet);
            txtLevel = itemView.findViewById(R.id.rank_txt_level);
            txtExp = itemView.findViewById(R.id.rank_txt_exp);
            imgKitty = itemView.findViewById(R.id.rank_img_pet);
        }
    }

    public RankAdapter(List<Kitty> kittyList) {
        this.kittyList = kittyList;
    }

    @Override
    public RankAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_rank_list, parent, false);
        RankAdapter.ViewHolder vh = new RankAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RankAdapter.ViewHolder holder, int position) {
        Uri uri = Uri.parse("android.resource://gamification.kitty.hackathon.kittybank/drawable/dragon1");

//        holder.txtUser.setText(String.valueOf(kittyList.get(position).getUserId()));
//        holder.txtPet.setText(kittyList.get(position).getName());
//        holder.txtRank.setText(String.valueOf(kittyList.get(position).getRank()));
//        holder.txtLevel.setText(String.valueOf(kittyList.get(position).getLevel()));
//        holder.txtExp.setText(String.valueOf(kittyList.get(position).getExperience()));
        holder.imgKitty.setImageURI(uri);

        holder.txtUser.setText(String.valueOf("Username"));
        holder.txtPet.setText("Petname");
        holder.txtRank.setText("#4");
        holder.txtLevel.setText("Level: 3");
        holder.txtExp.setText("EXP: 500");
    }

    @Override
    public int getItemCount() {
        return kittyList.size();
    }
}
