package com.gildedrose;



class GildedRose {
    Item[] items;



    public GildedRose(Item[] items) {
        this.items = items;

        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            Item typedItem;
            if ("Aged Brie".equals(item.name)) {
                typedItem = new AgedBrie(item.name, item.sellIn, item.quality);
            } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
                typedItem = new BackstagePass(item.name, item.sellIn, item.quality);
            } else if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
                typedItem = new Sulfuras(item.name, item.sellIn, item.quality);
            } else {
                typedItem = new NormalItem(item.name, item.sellIn, item.quality);
            }
            items[i] = typedItem;
        }

    }

    public void updateQuality() {

//        for (int i = 0; i < items.length; i++) {
//            Item item = items[i];
//            Item typedItem;
//            if ("Aged Brie".equals(item.name)) {
//                typedItem = new AgedBrie(item.name, item.sellIn, item.quality);
//            } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
//                typedItem = new BackstagePass(item.name, item.sellIn, item.quality);
//            } else if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
//                typedItem = new Sulfuras(item.name, item.sellIn, item.quality);
//            } else {
//                typedItem = new NormalItem(item.name, item.sellIn, item.quality);
//            }
//            typedItem.update();
//            items[i] = typedItem;
//        }
        for(Item item: items){
            item.update();
        }


    }


}
