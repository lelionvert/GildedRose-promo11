package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].isAgedBrie()
                    && !items[i].isBackstage()) {
                if (!items[i].isSulfuras()) {
                    items[i].decreaseQuality();
                }
            } else {
                items[i].increaseQuality();

                if (items[i].isBackstage()) {
                    if (items[i].sellIn < 11) {
                        items[i].increaseQuality();
                    }

                    if (items[i].sellIn < 6) {
                        items[i].increaseQuality();
                    }
                }
            }

            if (!items[i].isSulfuras()) {
                items[i].decreaseSellIn();
            }

            if (items[i].sellIn < 0) {
                if (!items[i].isAgedBrie()) {
                    if (!items[i].isBackstage()) {
                        if (!items[i].isSulfuras()) {
                            items[i].decreaseQuality();
                        }
                    } else {
                        items[i].resetQuality();
                    }
                } else {
                    items[i].increaseQuality();
                }
            }
        }
    }
}