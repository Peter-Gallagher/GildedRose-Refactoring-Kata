package com.gildedrose;


class GildedRose {
    Item[] items;

    ItemValueSetter valueSetter;


    public GildedRose(Item[] items) {
        this.items = items;
        valueSetter = new ItemValueSetter();
    }

    public void updateQuality() {
        TypedItem typedItem;
        for (Item item : items) {
            if ("Aged Brie".equals(item.name)) {
                typedItem = new AgedBrie(item, valueSetter);
            } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
                typedItem = new BackstagePass(item, valueSetter);
            } else if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
                typedItem = new Sulfuras(item, valueSetter);
            } else {
                typedItem = new NormalItem(item, valueSetter);
            }
            typedItem.update();
        }

    }


}
