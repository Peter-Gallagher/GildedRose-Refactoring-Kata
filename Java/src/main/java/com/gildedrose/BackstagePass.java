package com.gildedrose;

public class BackstagePass extends Item implements TypedItem {


    public BackstagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        if (sellIn <= 0){
            quality = 0;
        } else if (sellIn < 6) {
            setQualityWithinLimits(3);
        } else if (sellIn < 11) {
            setQualityWithinLimits(2);
        } else {
            setQualityWithinLimits(1);
        }
        sellIn--;
    }
}
