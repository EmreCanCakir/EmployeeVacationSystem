package db.controller;

import db.model.X;
import db.view.ViewFactory;

public abstract class BaseController {

    protected ViewFactory viewFactory;
    protected String fxmlName;
    public X x;

    public BaseController(X x,ViewFactory viewFactory, String fxmlName ) {
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
        this.x = x;
    }

    public String getFxmlName() {
        return fxmlName;
    }

}
