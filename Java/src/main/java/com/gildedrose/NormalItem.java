package com.gildedrose;

public class NormalItem extends Item implements TypedItem{


    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    @Override
    public void update() {
        if (sellIn > 0) {
            setQualityWithinLimits(-1);
        } else {
            setQualityWithinLimits(-2);
        }
        sellIn--;
    }
}
