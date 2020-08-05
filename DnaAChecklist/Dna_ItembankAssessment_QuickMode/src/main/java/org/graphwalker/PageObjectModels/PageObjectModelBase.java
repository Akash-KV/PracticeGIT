package org.graphwalker.PageObjectModels;

import org.graphwalker.DataReader;

abstract class PageObjectModelBase {
    protected static DataReader reader;

    public PageObjectModelBase() {
        reader = new DataReader();
    }
}