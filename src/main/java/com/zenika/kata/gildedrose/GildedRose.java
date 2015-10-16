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
                incrementQuality(item);

                if (item.sellIn <= 11) {
                    incrementQuality(item);
                }

                if (item.sellIn <= 6) {
                    incrementQuality(item);
                }
            } else if (item.name.equals(AGED_BRIE_NAME)) {
                incrementQuality(item);
            } else {
                decrementQuality(item);
            }

            if (item.sellIn < 0) {
                if (item.name.equals(AGED_BRIE_NAME)) {
                    incrementQuality(item);
                } else {
                    if (item.name.equals(BACKSTAGE_PASS_NAME)) {
                        item.quality = 0;
                    } else {
                        decrementQuality(item);
                    }
                }
            }

            item.quality = Math.min(item.quality, 50);
            item.quality = Math.max(item.quality, 0);
        }
    }

    private void decrementSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void decrementQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private void incrementQuality(Item item) {
        item.quality = item.quality + 1;
    }
}

