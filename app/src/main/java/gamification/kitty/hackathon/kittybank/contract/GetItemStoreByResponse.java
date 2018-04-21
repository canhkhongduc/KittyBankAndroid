package gamification.kitty.hackathon.kittybank.contract;

import java.util.List;

import gamification.kitty.hackathon.kittybank.entity.Food;
import gamification.kitty.hackathon.kittybank.entity.ItemStore;
import gamification.kitty.hackathon.kittybank.entity.KittyType;

/**
 * Created by User on 4/21/2018.
 */

public class GetItemStoreByResponse {
    private List<KittyType> listEggs;
    private List<Food> listFoods;

    public GetItemStoreByResponse() {
    }

    public GetItemStoreByResponse(List<KittyType> listEggs, List<Food> listFoods) {
        this.listEggs = listEggs;
        this.listFoods = listFoods;
    }

    public List<KittyType> getListEggs() {
        return listEggs;
    }

    public void setListEggs(List<KittyType> listEggs) {
        this.listEggs = listEggs;
    }

    public List<Food> getListFoods() {
        return listFoods;
    }

    public void setListFoods(List<Food> listFoods) {
        this.listFoods = listFoods;
    }
}
