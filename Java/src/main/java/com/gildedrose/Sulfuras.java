package com.gildedrose;

public class Sulfuras implements TypedItem{

    Item item;
    ItemValueSetter valueSetter;

    public Sulfuras(Item item, ItemValueSetter valueSetter) {
        this.item = item;
        this.valueSetter = valueSetter;
    }

    @Override
    public void update() {
        // Sulfuras should not change
    }
}
