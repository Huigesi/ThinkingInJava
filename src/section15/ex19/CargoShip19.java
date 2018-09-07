package section15.ex19;

import section15.Generator;
import section15.ex13.Generators13;

import java.util.ArrayList;
import java.util.Random;

class Item {
    private final int id;
    private String description;
    private double price;

    public Item(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public String toString() {
        return id+": "+description+", price: $"+price;
    }

    public void priceChange(double change) {
        price+=change;
    }
    public static Generator<Item> generator=
            new Generator<Item>() {
                private Random rand = new Random(47);
                @Override
                public Item next() {
                    return new Item(rand.nextInt(1000),"Test",
                            Math.round(rand.nextDouble()*1000.0)+0.99);
                }
            };
}

class Shelf extends ArrayList<Item> {
    public Shelf(int initialCapacity) {
        Generators13.fill(this, Item.generator, initialCapacity);
    }
}
class StorageArea extends ArrayList<Shelf> {
    public StorageArea(int nShelves, int nItems) {
        for(int i = 0; i < nShelves; i++)
            add(new Shelf(nItems));
    }
}
class Office {}

public class CargoShip19 extends ArrayList<StorageArea> {
    private ArrayList<StorageArea> mStorageAreas = new ArrayList<>();
    private Office mOffice = new Office();

    public CargoShip19(int storageAreas,int shelf,int nItems) {
        for (int i = 0; i < storageAreas; i++) {
            add(new StorageArea(shelf, nItems));
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (StorageArea s : this) {
            for (Shelf shelf : s) {
                for (Item item : shelf) {
                    result.append(item);
                    result.append("\n");
                }

            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CargoShip19(13,5,10));
    }
}
