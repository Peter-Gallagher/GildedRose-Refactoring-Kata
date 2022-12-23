package com.gildedrose;


import com.gildedrose.alerts.AlertHandler;

import java.util.ArrayList;

class GildedRose {
    ArrayList<GildedItem> gildedItems = new ArrayList<>();
    GildedItemFactory factory = new GildedItemFactory();
    ArrayList<AlertHandler> eventHandlers = new ArrayList<>();

    public GildedRose(Item[] items) {
        for (Item item: items){
            GildedItem gildedItem = factory.createItem(item);
            gildedItems.add(gildedItem);
        }
    }

    public void updateQuality() {
        for (GildedItem item: gildedItems){
            item.update();
        }

        for (AlertHandler eventHandler: eventHandlers){
            eventHandler.notifySubscribers(gildedItems);
        }

    }

    public void addEventHandler(AlertHandler publisher){
        eventHandlers.add(publisher);
    }



}
