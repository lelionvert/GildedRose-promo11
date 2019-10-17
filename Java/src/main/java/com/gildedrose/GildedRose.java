package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void updateNormalItemQuality(Item item) {
        if (item.getQuality() > 0) {
            if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
                item.decrementQuality();
            }
        }
    }

    private void updateBackstagePass(Item item) {
        if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {

            if (item.getQuality() < 50) {
                item.incrementQuality();
            }

            if (item.getSellIn() < 11) {
                if (item.getQuality() < 50) {
                    item.incrementQuality();
                }
            }
            if (item.getSellIn() < 6) {
                if (item.getQuality() < 50) {
                    item.incrementQuality();
                }
            }
        }
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateBackstagePass(items[i]);
            }
            else if (items[i].getName().equals("Aged Brie")) {
                updateAgeBrie(items[i]);
            }
            else {
                updateNormalItemQuality(items[i]);
            }
            items[i].updateSellIn();

            if (items[i].getSellIn() < 0) {
                if (items[i].getName().equals("Aged Brie")) {
                    updateAgeBrie(items[i]);
                } else if (items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                    items[i].setQualityToZero();
                } else {
                    updateNormalItemQuality(items[i]);
                }
            }
        }
    }

    private void updateAgeBrie(Item item) {
        if (item.getQuality() < 50) {
            item.incrementQuality();
        }
    }

}