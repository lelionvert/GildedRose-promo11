package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.isSulfuras()) {
                // doNothing
            }

            else if (item.isAgedBrie()) {
                item.increaseQuality();
                item.decreaseSellIn();
                if (item.sellIn < 0) {
                    item.increaseQuality();
                }
            }

            else if (item.isBackstage()) {
                item.increaseQuality();
                if (item.sellIn < 11) {
                    item.increaseQuality();
                }
                if (item.sellIn < 6) {
                    item.increaseQuality();
                }
                item.decreaseSellIn();
                if (item.sellIn < 0) {
                    item.resetQuality();
                }
            }

            else {
                item.decreaseQuality();
                item.decreaseSellIn();
                if (item.sellIn < 0) {
                    item.decreaseQuality();
                }
            }
        }
    }
}