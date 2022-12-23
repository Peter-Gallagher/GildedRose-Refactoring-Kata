package com.gildedrose.alerts;

import com.gildedrose.GildedItem;

import java.util.ArrayList;

public class PriceThresholdAlerter implements AlertHandler {

    String itemName;
    int priceThreshold;
    ArrayList<Listener> listeners = new ArrayList<>();

    public PriceThresholdAlerter(String itemName, int priceThreshold){
        this.itemName = itemName;
        this.priceThreshold = priceThreshold;
    }

    @Override
    public void subscribe(Listener subscriber) {
        listeners.add(subscriber);
    }

    @Override
    public void unsubscribe(Listener subscriber) {
        listeners.remove(subscriber);
    }

    @Override
    public void notifySubscribers(ArrayList<GildedItem> items) {
        for(GildedItem item: items){
            if (item.name.equals(itemName) && item.quality < priceThreshold){
                updateAllSubscribers(item);
            }
        }
    }

    public void updateAllSubscribers(GildedItem item){
        for (Listener listener: listeners){
            listener.update(item);
        }
    }

}
