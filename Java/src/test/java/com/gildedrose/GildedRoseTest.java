package com.gildedrose;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class GildedRoseTest {

    private Item[] items;
    private Item[] itemsLegacy;
    private GildedRose app;

    @Before
    public void setUp() {

        items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)
        };
        itemsLegacy = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)
        };
        app = new GildedRose(items);
    }

    @Test
    public void versus_golden_master() {
        GildedRoseLegacy legacy = new GildedRoseLegacy(itemsLegacy);

        for (int i = 0; i < 100; i++) {
            legacy.updateQuality();
            app.updateQuality();
            SoftAssertions assertions = new SoftAssertions();

            assertions.assertThat(app.items).extracting("name").containsExactly(
                    Arrays.stream(legacy.items).map(item -> item.name).toArray()
            );
            assertions.assertThat(app.items).extracting("sellIn").containsExactly(
                    Arrays.stream(legacy.items).map(item -> item.sellIn).toArray()
            );
            assertions.assertThat(app.items).extracting("quality").containsExactly(
                    Arrays.stream(legacy.items).map(item -> item.quality).toArray()
            );
            assertions.assertAll();
        }
    }

}
