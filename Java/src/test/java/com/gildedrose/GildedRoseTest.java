package com.gildedrose;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void initial_items_state() {
        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)
        };
        GildedRose app = new GildedRose(items);
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

}
