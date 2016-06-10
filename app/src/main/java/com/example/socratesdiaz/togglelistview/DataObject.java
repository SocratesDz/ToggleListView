package com.example.socratesdiaz.togglelistview;

import java.util.ArrayList;

/**
 * Created by socratesdiaz on 6/9/16.
 */
public class DataObject {
    private String _description;
    private String _value;
    private ArrayList<DataObject> _children;

    public DataObject(String description, String value, ArrayList<DataObject> children) {
        _description = description;
        _value = value;
        _children = children;
    }

    public DataObject(String description, String value) {
        new DataObject(description, value, new ArrayList<DataObject>());
    }

    public DataObject(String description) {
        new DataObject(description, "", new ArrayList<DataObject>());
    }

    public DataObject() {
        new DataObject("", "", new ArrayList<DataObject>());
    }

    public ArrayList<DataObject> getChildren() {
        return _children;
    }

    public String getDescription() {
        return _description;
    }

    public String getValue() {
        return _value;
    }

    public void setChildren(ArrayList<DataObject> children) {
        this._children = children;
    }

    public boolean hasChildren() {
        return this._children.size() > 0;
    }

    public void setDescription(String _description) {
        this._description = _description;
    }

    public void setValue(String value) {
        this._value = value;
    }
}
