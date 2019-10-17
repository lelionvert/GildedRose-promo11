package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].isSulfuras()) {
                // doNothing
            }

            else if (items[i].isAgedBrie()) {
                items[i].increaseQuality();
                items[i].decreaseSellIn();
                if (items[i].sellIn < 0) {
                    items[i].increaseQuality();
                }
            }

            else if (items[i].isBackstage()) {
                items[i].increaseQuality();
                if (items[i].sellIn < 11) {
                    items[i].increaseQuality();
                }
                if (items[i].sellIn < 6) {
                    items[i].increaseQuality();
                }
                items[i].decreaseSellIn();
                if (items[i].sellIn < 0) {
                    items[i].resetQuality();
                }
            }

            else {
                items[i].decreaseQuality();
                items[i].decreaseSellIn();
                if (items[i].sellIn < 0) {
                    items[i].decreaseQuality();
                }
            }
        }
    }
}