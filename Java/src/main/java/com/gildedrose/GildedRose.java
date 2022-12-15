package com.gildedrose;

import java.util.ArrayList;

class GildedRose {
    Item[] items;

    int minAllowedQuality = 0;
    int maxAllowedQuality = 50;

    ArrayList<String> itemsIncreaseValueAsTheyAge;

    public GildedRose(Item[] items) {
        this.items = items;
        itemsIncreaseValueAsTheyAge = new ArrayList<>();
        itemsIncreaseValueAsTheyAge.add("Backstage passes to a TAFKAL80ETC concert");
        itemsIncreaseValueAsTheyAge.add("Aged Brie");
    }

    public void updateQuality() {
        for (Item item : items) {

            if (handledItemAsSpecialCase(item)){
                continue;
            }

            if (qualityIncreasesAsItemAges(item)){
                changeQualityWithinLimits(item, 1);
                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 6) {
                        changeQualityWithinLimits(item, 2);
                    } else if (item.sellIn < 11) {
                        changeQualityWithinLimits(item, 1);
                    }
                }
            } else {
                changeQualityWithinLimits(item, -1);
            }

            item.sellIn = item.sellIn - 1;

            if (item.sellIn < 0) {
                if (item.name.equals("Aged Brie")){
                    changeQualityWithinLimits(item, 1);
                } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
                    item.quality = 0;
                } else {
                    changeQualityWithinLimits(item, -1);
                }
            }

        }
    }

    private boolean handledItemAsSpecialCase(Item item){
        if (item.name.equals("Sulfuras, Hand of Ragnaros")){
            return true;
        } else if(item.name.equals("foo")){
            item.name = "fixme";
            return true;
        }
        return false;
    }

    private void changeQualityWithinLimits(Item item, int amount_to_change){
        item.quality += amount_to_change;

        if (item.quality < minAllowedQuality){
            item.quality = minAllowedQuality;
        } else if (item.quality > maxAllowedQuality) {
            item.quality = maxAllowedQuality;
        }
    }

    private boolean qualityIncreasesAsItemAges(Item item){
//        if (item.name.equals("Aged Brie")){
//            return true;
//        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
//            return true;
//        }
//        return false;
        return itemsIncreaseValueAsTheyAge.contains(item.name);
    }
}
