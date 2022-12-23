package com.gildedrose;

import com.gildedrose.strategies.*;

public class GildedItemFactory {

    public GildedItemFactory(){}

    public GildedItem createItem(Item item){
        ItemStrategy strategy;
        if ("Aged Brie".equals(item.name)) {
            strategy = new AgedBrieStrategy();
        } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
            strategy = new BackstagePassStrategy();
        } else if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
            strategy = new SulfurasStrategy();
        } else {
            strategy = new NormalStrategy();
        }

        return new GildedItem(item.name, item.sellIn, item.quality, strategy);
    }
}
