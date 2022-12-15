package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    //Test
    public void updateQuality() {
        for (Item item : items) {
            if (handledItemAsSpecialCase(item)){
                continue;
            }

            if (!qualityDecreasesAsItemAges(item)){
                if (item.quality > 0) {
//                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality = item.quality - 1;
//                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            decrementSellInIfApplicable(item);

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
//                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
//                            }
                        }
                    } else {
                        // Backstage pass
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    // Aged brie
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }

    private boolean handledItemAsSpecialCase(Item item){
        if (item.name.equals("Sulfuras, Hand of Ragnaros")){
            return true;
        }
        return false;
    }
    private void decrementSellInIfApplicable(Item item){
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private boolean qualityDecreasesAsItemAges(Item item){
        if (item.name.equals("Aged Brie")){
            return true;
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
            return true;
        }
        return false;
    }
}
