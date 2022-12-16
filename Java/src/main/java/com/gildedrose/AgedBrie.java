package com.gildedrose;

public class AgedBrie implements TypedItem{

    Item item;
    ItemValueSetter valueSetter;


    public AgedBrie(Item item, ItemValueSetter valueSetter) {
        this.item = item;
        this.valueSetter = valueSetter;
    }

    @Override
    public void update() {
        if (item.sellIn <= 0){
            valueSetter.setQualityWithinLimits(item, 2);
        } else {
            valueSetter.setQualityWithinLimits(item, 1);
        }
        item.sellIn--;
    }
}
