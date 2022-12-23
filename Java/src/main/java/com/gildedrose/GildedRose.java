package com.gildedrose;


import java.util.ArrayList;

class GildedRose {
    ArrayList<GildedItem> gildedItems = new ArrayList<>();
//    TypedItemFactory factory;
    GildedItemFactory factory = new GildedItemFactory();;
    public GildedRose(Item[] items) {
        for (Item item: items){
            GildedItem gildedItem = factory.createItem(item);
            gildedItems.add(gildedItem);
        }
    }

    public void updateQuality() {
//        TypedItem typedItem;
//        for (Item item : items) {
//            typedItem = factory.createItem(item);
//            typedItem.update();
//        }
        for (GildedItem item: gildedItems){
            item.update();
        }

    }


}
