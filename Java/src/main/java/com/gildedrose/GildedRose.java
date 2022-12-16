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
                default:
                    changeQualityOfNormalItem(item);
                    break;
        }

        item.sellIn = item.sellIn - 1;

        }
    }

    private void changeQualityOfBrie(Item item){
        if (item.sellIn <= 0){
            setQualityWithinLimits(item, 2);
        } else {
            setQualityWithinLimits(item, 1);
        }
    }

    private void changeQualityOfBackstage(Item item){
        if (item.sellIn <= 0){
            item.quality = 0;
        } else if (item.sellIn < 6) {
            setQualityWithinLimits(item, 3);
        } else if (item.sellIn < 11) {
            setQualityWithinLimits(item, 2);
        } else {
            setQualityWithinLimits(item, 1);
        }
    }

    private void changeQualityOfSulfuras(Item item){
    }


    private void changeQualityOfNormalItem(Item item){
        if (item.sellIn > 0) {
            setQualityWithinLimits(item, -1);
        } else {
            setQualityWithinLimits(item, -2);
        }
    }

    private void setQualityWithinLimits(Item item, int amount_to_change){
        item.quality += amount_to_change;

        if (item.quality < minAllowedQuality){
            item.quality = minAllowedQuality;
        } else if (item.quality > maxAllowedQuality) {
            item.quality = maxAllowedQuality;
        }
    }

}
