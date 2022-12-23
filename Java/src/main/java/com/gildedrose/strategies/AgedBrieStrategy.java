package com.gildedrose.strategies;

import com.gildedrose.GildedItem;

public class AgedBrieStrategy extends ItemStrategy {


    @Override
    public void update(GildedItem item) {
        if (item.sellIn <= 0){
            setQualityWithinLimits(item, 2);
        } else {
            setQualityWithinLimits(item, 1);
        }
        item.sellIn--;
    }

}
