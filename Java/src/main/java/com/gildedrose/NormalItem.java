package com.gildedrose;

public class NormalItem implements TypedItem{

    Item item;
    ItemValueSetter valueSetter;

    public NormalItem(Item item, ItemValueSetter valueSetter) {
        this.item = item;
        this.valueSetter = valueSetter;
    }

    @Override
    public void update() {
        if (item.sellIn > 0) {
            valueSetter.setQualityWithinLimits(item, -1);
        } else {
            valueSetter.setQualityWithinLimits(item, -2);
        }
        item.sellIn--;
    }
}
