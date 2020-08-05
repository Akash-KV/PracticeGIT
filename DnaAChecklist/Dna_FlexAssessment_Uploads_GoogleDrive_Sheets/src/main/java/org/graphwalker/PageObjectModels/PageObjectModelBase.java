package org.graphwalker.PageObjectModels;

import org.graphwalker.DataReader;

//Page object model class LoginPage
abstract class PageObjectModelBase {
    protected DataReader reader;

    public PageObjectModelBase() {
        reader = new DataReader();
    }
}