package com.gildedrose;

public class ItemValueSetter {

    int minAllowedQuality = 0;
    int maxAllowedQuality = 50;

    public void setQualityWithinLimits(Item item, int amount_to_change){
        item.quality += amount_to_change;

        if (item.quality < minAllowedQuality){
            item.quality = minAllowedQuality;
        } else if (item.quality > maxAllowedQuality) {
            item.quality = maxAllowedQuality;
        }
    }
}
