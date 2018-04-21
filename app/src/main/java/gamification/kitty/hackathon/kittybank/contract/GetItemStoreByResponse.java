package gamification.kitty.hackathon.kittybank.contract;

import java.util.List;

import gamification.kitty.hackathon.kittybank.entity.ItemStore;

/**
 * Created by User on 4/21/2018.
 */

public class GetItemStoreByResponse {
    private List<ItemStore> listItemStore;

    public GetItemStoreByResponse() {
    }

    public GetItemStoreByResponse(List<ItemStore> listItemStore) {
        this.listItemStore = listItemStore;
    }

    public List<ItemStore> getListItemStore() {
        return listItemStore;
    }

    public void setListItemStore(List<ItemStore> listItemStore) {
        this.listItemStore = listItemStore;
    }
}
