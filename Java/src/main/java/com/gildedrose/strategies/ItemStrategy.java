package com.gildedrose.strategies;

import com.gildedrose.GildedItem;

public abstract class ItemStrategy{

    private int minAllowedQuality = 0;
    private int maxAllowedQuality = 50;

    public void setQualityWithinLimits(GildedItem item, int amountToChange){
        item.quality += amountToChange;

        if (item.quality < minAllowedQuality){
            item.quality = minAllowedQuality;
        } else if (item.quality > maxAllowedQuality) {
            item.quality = maxAllowedQuality;
        }
    }


    public void update(GildedItem item){}

}
