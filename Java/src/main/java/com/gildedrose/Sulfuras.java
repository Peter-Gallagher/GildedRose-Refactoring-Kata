package com.gildedrose;

public class Sulfuras extends Item implements TypedItem{


    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        // Sulfuras should not change
    }
}
