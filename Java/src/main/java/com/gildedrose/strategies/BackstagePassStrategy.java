package com.gildedrose.strategies;

import com.gildedrose.GildedItem;

public class BackstagePassStrategy extends ItemStrategy{


    @Override
    public void update(GildedItem item) {
        if (item.sellIn <= 0){
            item.quality = 0;
        } else if (item.sellIn < 6) {
            setQualityWithinLimits(item, 3);
        } else if (item.sellIn < 11) {
            setQualityWithinLimits(item, 2);
        } else {
            setQualityWithinLimits(item, 1);
        }
        item.sellIn--;
    }

}
