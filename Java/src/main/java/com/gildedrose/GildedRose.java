package com.gildedrose;


class GildedRose {
    Item[] items;

    int minAllowedQuality = 0;
    int maxAllowedQuality = 50;


    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {

            switch (item.name){
                case ("Aged Brie"):
                    changeQualityOfBrie(item);
                    break;
                case ("Backstage passes to a TAFKAL80ETC concert"):
                    changeQualityOfBackstage(item);
                    break;
                case ("Sulfuras, Hand of Ragnaros"):
                    changeQualityOfSulfuras(item);
                    continue;
                case ("foo"):
                    changeQualityOffFoo(item);
                    break;
                default:
                    changeQualityOfNormalItem(item);
                    break;
        }

        item.sellIn = item.sellIn - 1;

        }
    }

    private void changeQualityOfBrie(Item item){
        if (item.sellIn <= 0){
            changeQualityWithinLimits(item, 2);
        } else {
            changeQualityWithinLimits(item, 1);
        }
    }

    private void changeQualityOfBackstage(Item item){
        if (item.sellIn <= 0){
            item.quality = 0;
        } else if (item.sellIn < 6) {
            changeQualityWithinLimits(item, 3);
        } else if (item.sellIn < 11) {
            changeQualityWithinLimits(item, 2);
        } else {
            changeQualityWithinLimits(item, 1);
        }
    }

    private void changeQualityOfSulfuras(Item item){
    }

    private void changeQualityOffFoo(Item item){
        item.name = "fixme";
    }

    private void changeQualityOfNormalItem(Item item){
        if (item.sellIn > 0) {
            changeQualityWithinLimits(item, -1);
        } else {
            changeQualityWithinLimits(item, -2);
        }
    }

    private void changeQualityWithinLimits(Item item, int amount_to_change){
        item.quality += amount_to_change;

        if (item.quality < minAllowedQuality){
            item.quality = minAllowedQuality;
        } else if (item.quality > maxAllowedQuality) {
            item.quality = maxAllowedQuality;
        }
    }

}
