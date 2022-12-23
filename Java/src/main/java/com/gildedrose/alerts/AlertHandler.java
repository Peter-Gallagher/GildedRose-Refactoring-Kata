package com.gildedrose.alerts;

import com.gildedrose.GildedItem;

import java.util.ArrayList;

public interface AlertHandler {

    void subscribe(Listener subscriber);

    void unsubscribe(Listener subscriber);

    void notifySubscribers(ArrayList<GildedItem> items);


}
