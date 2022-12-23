package com.gildedrose;

import com.gildedrose.alerts.PriceThresholdAlerter;
import com.gildedrose.alerts.StringListener;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertTests {

    @Test
    void itemQualityDecreaseTriggersPriceThresholdAlerter(){
        Item[] items = new Item[] { new Item("Cake", 0, 23) };
        GildedRose app = new GildedRose(items);
        PriceThresholdAlerter alerter =  new PriceThresholdAlerter("Cake", 20);
        StringListener listener = new StringListener();
        alerter.subscribe(listener);
        app.addEventHandler(alerter);

        app.updateQuality();
        assertEquals(listener.priceAlerts.size(), 0);
        app.updateQuality();
        assertEquals(listener.priceAlerts.size(), 1);
        assertEquals(listener.priceAlerts.get(0), app.gildedItems.get(0).toString());
    }

    @Test
    void removedListenerNoLongerGetsAlerts(){
        Item[] items = new Item[] { new Item("Cake", 0, 21) };
        GildedRose app = new GildedRose(items);
        PriceThresholdAlerter alerter =  new PriceThresholdAlerter("Cake", 20);
        StringListener listener = new StringListener();
        alerter.subscribe(listener);
        app.addEventHandler(alerter);

        app.updateQuality();
        assertEquals(listener.priceAlerts.size(), 1);
        app.updateQuality();
        assertEquals(listener.priceAlerts.size(), 2);
        alerter.unsubscribe(listener);
        app.updateQuality();
        assertEquals(listener.priceAlerts.size(), 2);
    }

}
