package gamification.kitty.hackathon.kittybank.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import gamification.kitty.hackathon.kittybank.activity.ProfileActivity;
import gamification.kitty.hackathon.kittybank.activity.R;
import gamification.kitty.hackathon.kittybank.entity.Food;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private static List<Food> foodList;
    private static ProfileActivity activity;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtFood;
        public ImageView imgFood;

        public ViewHolder(View itemView) {
            super(itemView);

            txtFood = itemView.findViewById(R.id.food_adapter_txt);
            imgFood = itemView.findViewById(R.id.food_adapter_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.hideFoodList();

                    //TODO: feed function
                }
            });
        }
    }

    public FoodAdapter(List<Food> foodList, ProfileActivity activity) {
        this.foodList = foodList;
        this.activity = activity;
    }

    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_food_list, parent, false);
        FoodAdapter.ViewHolder vh = new FoodAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(FoodAdapter.ViewHolder holder, int position) {
//        Uri uri = Uri.parse("android.resource://gamification.kitty.hackathon.kittybank/drawable/apple");
//        holder.txtFood.setText(foodList.get(position).getName());
//        holder.imgFood.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }
}
