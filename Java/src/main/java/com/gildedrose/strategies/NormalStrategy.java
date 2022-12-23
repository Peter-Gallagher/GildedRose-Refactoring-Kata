package com.gildedrose.strategies;

import com.gildedrose.GildedItem;

public class NormalStrategy extends ItemStrategy{

    @Override
    public void update(GildedItem item){
        if (item.sellIn > 0) {
            setQualityWithinLimits(item, -1);
        } else {
            setQualityWithinLimits(item, -2);
        }
        item.sellIn--;
    }
}
