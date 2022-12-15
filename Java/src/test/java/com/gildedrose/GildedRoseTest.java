package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

//    @Test
//    void foo() {
//        Item[] items = new Item[] { new Item("foo", 0, 0) };
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals("fixme", app.items[0].name);
//    }

    @Test
    void sellinShouldDecreaseByOne() {
        Item[] items = new Item[] { new Item("foo", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void qualityShouldNotGoBelowZero() {
        Item[] items = new Item[] { new Item("foo", -2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void sulfurasQualityIseighty() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        items[0].sellIn = -10;
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void agedBrieWithNegativeSellinShouldIncreaseInQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", -5, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(27, app.items[0].quality);
    }

    @Test
    void agedBrieShouldNotIncreaseQualityPast50() {
        Item[] items = new Item[] { new Item("Aged Brie", -5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void backstagePassesShouldIncreaseQualityBy2When10DaysOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 5),
            new Item("Backstage passes to a TAFKAL80ETC concert", 6, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].quality);
        assertEquals(7, app.items[1].quality);
    }

    @Test
    void backstagePassesShouldIncreaseQualityBy3When5DaysOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5),
            new Item("Backstage passes to a TAFKAL80ETC concert", 1, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
        assertEquals(8, app.items[1].quality);
    }

    @Test
    void backstagePassesShouldHave0QualityAfterShowEnded() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5),
            new Item("Backstage passes to a TAFKAL80ETC concert", -10, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
    }

}
