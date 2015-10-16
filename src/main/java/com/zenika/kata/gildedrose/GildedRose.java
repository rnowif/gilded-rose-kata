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

            if (item.name.equals(AGED_BRIE_NAME) || item.name.equals(BACKSTAGE_PASS_NAME)) {
                item.quality = item.quality + 1;

                if (item.name.equals(BACKSTAGE_PASS_NAME)) {
                    if (item.sellIn < 11) {
                        item.quality = item.quality + 1;
                    }

                    if (item.sellIn < 6) {
                        item.quality = item.quality + 1;
                    }
                }
            } else {
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }
            }

            item.sellIn = item.sellIn - 1;

            if (item.sellIn < 0) {
                if (item.name.equals(AGED_BRIE_NAME)) {
                    item.quality = item.quality + 1;
                } else {
                    if (item.name.equals(BACKSTAGE_PASS_NAME)) {
                        item.quality = 0;
                    } else {
                        if (item.quality > 0) {
                            item.quality = item.quality - 1;
                        }
                    }
                }
            }

            item.quality = Math.min(item.quality, 50);
        }
    }
}

