package org.graphwalker.PageObjectModels;

import org.graphwalker.DataReader;

//Page object model class for PageObjectModelBase
abstract class PageObjectModelBase {
    protected DataReader reader;

    public PageObjectModelBase() {
        reader = new DataReader();
    }
}