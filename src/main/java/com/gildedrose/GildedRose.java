package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            boolean isAgedBrie = item.name.equals("Aged Brie");
            boolean isBackstagePass = item.name.equals("Backstage passes to a TAFKAL80ETC concert");
            boolean isSulfuras = item.name.equals("Sulfuras, Hand of Ragnaros");
            boolean isConjured = item.name.contains("Conjured");

            if (!isAgedBrie && !isBackstagePass && item.quality > 0 && !isSulfuras) {
                item.quality--;
                // conjured items degrade twice as fast as standard items
                if (isConjured && item.quality > 0) {
                    item.quality = item.quality - 1;
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    //improved the readability of this section 
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        //combined the two if statements into one 
                        if (items[i].sellIn < 11 && items[i].quality < 50) {
                                items[i].quality++;
                                //edited this to be a ++ instead of adding onto itself. 
                        }

                        if (items[i].sellIn < 6 && items[i].quality < 50) {
                            //similar as above
                            if (items[i].quality < 50) {
                                items[i].quality++;
                            }
                        }
                    }
                }
            }

            if (!isSulfuras) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!isAgedBrie) {
                    if (!isBackstagePass) {
                        if (item.quality > 0) {
                            if (!isSulfuras) {
                                item.quality = item.quality - 1;
                                if (isConjured && item.quality > 0) {
                                    item.quality = item.quality - 1;
                                }
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}