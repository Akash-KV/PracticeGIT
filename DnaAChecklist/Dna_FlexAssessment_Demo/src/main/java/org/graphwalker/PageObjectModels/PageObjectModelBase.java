package org.graphwalker.PageObjectModels;

import org.graphwalker.DataReader;

/**
 * Page Object Model Class for PageObjectModelBase
 **/
abstract class PageObjectModelBase {
    protected DataReader reader;

    public PageObjectModelBase() {
        reader = new DataReader();
    }
}