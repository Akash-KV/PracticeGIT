package org.graphwalker.PageObjectModels;

import org.graphwalker.DataReader;

/**
 * Page Object Model class for PageObjectModelBase
 **/
abstract class PageObjectModelBase {

    protected static DataReader reader;

    public PageObjectModelBase() {
        reader = new DataReader();
    }
}