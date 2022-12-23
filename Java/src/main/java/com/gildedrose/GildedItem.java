package com.gildedrose;

import com.gildedrose.strategies.ItemStrategy;

public class GildedItem {

    public String name;

    public int sellIn;

    public int quality;

    private ItemStrategy strategy;

    public GildedItem(String name, int sellIn, int quality, ItemStrategy strategy) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.strategy = strategy;
    }

    public void update(){
        strategy.update(this);
    }

    @Override
    public String toString() {
            return this.name + ", " + this.sellIn + ", " + this.quality;
        }

}
