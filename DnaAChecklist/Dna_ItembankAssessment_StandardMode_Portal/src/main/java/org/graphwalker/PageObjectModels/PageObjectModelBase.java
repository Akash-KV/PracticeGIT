package org.graphwalker.PageObjectModels;

import org.graphwalker.DataReader;

/****POM Class for PageObjectModelBase******/
abstract class PageObjectModelBase {
    protected static DataReader reader;

    public PageObjectModelBase() {
        reader = new DataReader();
    }
}