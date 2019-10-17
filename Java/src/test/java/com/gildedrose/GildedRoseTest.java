package com.gildedrose;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {

    private Item[] items;
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
        app = new GildedRose(items);
    }

    @Test
    public void initial_items_state() {
        SoftAssertions assertions = new SoftAssertions();

        assertions.assertThat(app.items).extracting("name").containsExactly(
                "+5 Dexterity Vest",
                "Aged Brie",
                "Elixir of the Mongoose",
                "Sulfuras, Hand of Ragnaros",
                "Sulfuras, Hand of Ragnaros",
                "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert"
        );
        assertions.assertThat(app.items).extracting("sellIn").containsExactly(
                10, 2, 5, 0, -1, 15, 10, 5
        );
        assertions.assertThat(app.items).extracting("quality").containsExactly(
                20, 0, 7, 80, 80, 20, 49, 49
        );
        assertions.assertAll();
    }

    @Test
    public void items_state_after_one_day() {
        app.updateQuality();

        SoftAssertions assertions = new SoftAssertions();

        assertions.assertThat(app.items).extracting("name").containsExactly(
                "+5 Dexterity Vest",
                "Aged Brie",
                "Elixir of the Mongoose",
                "Sulfuras, Hand of Ragnaros",
                "Sulfuras, Hand of Ragnaros",
                "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert"
        );
        assertions.assertThat(app.items).extracting("sellIn").containsExactly(
                9, 1, 4, 0, -1, 14, 9, 4
        );
        assertions.assertThat(app.items).extracting("quality").containsExactly(
                19, 1, 6, 80, 80, 21, 50, 50
        );
        assertions.assertAll();
    }

}
