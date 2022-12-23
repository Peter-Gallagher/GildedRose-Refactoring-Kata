package com.gildedrose.alerts;

import com.gildedrose.GildedItem;

import java.util.ArrayList;

public class StringListener implements Listener {
    public ArrayList<String> priceAlerts = new ArrayList<>();

    public StringListener(){
    }

    @Override
    public void update(GildedItem item) {
        priceAlerts.add(item.toString());
    }
}
