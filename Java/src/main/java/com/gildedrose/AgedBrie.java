package com.gildedrose;

public class AgedBrie extends Item implements TypedItem{


    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        if (sellIn <= 0){
            setQualityWithinLimits(2);
        } else {
            setQualityWithinLimits(1);
        }
        sellIn--;
    }
}
