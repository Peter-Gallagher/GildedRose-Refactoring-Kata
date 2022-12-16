package com.gildedrose;

public class BackstagePass implements TypedItem {
    Item item;
    ItemValueSetter valueSetter;


    public BackstagePass(Item item, ItemValueSetter valueSetter) {
        this.item = item;
        this.valueSetter = valueSetter;
    }


    @Override
    public void update() {
        if (item.sellIn <= 0){
            item.quality = 0;
        } else if (item.sellIn < 6) {
            valueSetter.setQualityWithinLimits(item, 3);
        } else if (item.sellIn < 11) {
            valueSetter.setQualityWithinLimits(item, 2);
        } else {
            valueSetter.setQualityWithinLimits(item, 1);
        }
        item.sellIn--;
    }
}
