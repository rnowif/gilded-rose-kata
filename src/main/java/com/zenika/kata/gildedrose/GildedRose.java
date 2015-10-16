package com.zenika.kata.gildedrose;

public class GildedRose {
    public static final String AGED_BRIE_NAME = "Aged Brie";
    public static final String BACKSTAGE_PASS_NAME = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_NAME = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (item.name.equals(SULFURAS_NAME)) {
                continue;
            }

            decrementSellIn(item);

            if (item.name.equals(BACKSTAGE_PASS_NAME)) {
                if (item.sellIn < 0) {
                    item.quality = 0;
                } else if (item.sellIn <= 6) {
                    incrementQuality(item, 3);
                }  else if (item.sellIn <= 11) {
                    incrementQuality(item, 2);
                }

            } else if (item.name.equals(AGED_BRIE_NAME)) {
                if (item.sellIn < 0) {
                    incrementQuality(item, 2);
                } else {
                    incrementQuality(item, 1);
                }
            } else {
                if (item.sellIn < 0) {
                    incrementQuality(item, -2);
                } else {
                    incrementQuality(item, -1);
                }
            }

            item.quality = Math.min(item.quality, 50);
            item.quality = Math.max(item.quality, 0);
        }
    }

    private void decrementSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void incrementQuality(Item item, int delta) {
        item.quality = item.quality + delta;
    }
}

