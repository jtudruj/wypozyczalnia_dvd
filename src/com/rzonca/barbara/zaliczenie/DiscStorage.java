package com.rzonca.barbara.zaliczenie;

import com.rzonca.barbara.zaliczenie.model.DiscModel;

import java.util.ArrayList;
import java.util.List;

public class DiscStorage {
    private static DiscStorage storage = new DiscStorage();

    private List<DiscModel> discs;


    private DiscStorage() {
        this.discs = new ArrayList<DiscModel>();
    }

    public static DiscStorage getInstance() {
        return storage;
    }

    public List<DiscModel> getDiscs() {
        return discs;
    }

    public void overrideListWith(List<DiscModel> list) {
        this.discs = list;
    }
}
