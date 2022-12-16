package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public int minAllowedQuality = 0;

    public int maxAllowedQuality = 50;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void update(){
        // To be implemented by children
    }
    public void setQualityWithinLimits(int amount_to_change){
        quality += amount_to_change;

        if (quality < minAllowedQuality){
            quality = minAllowedQuality;
        } else if (quality > maxAllowedQuality) {
            quality = maxAllowedQuality;
        }
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
