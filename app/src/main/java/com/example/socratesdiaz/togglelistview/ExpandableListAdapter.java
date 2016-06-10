package com.example.socratesdiaz.togglelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private ArrayList<DataObject> _listData;

    public ExpandableListAdapter(Context context, ArrayList<DataObject> listData) {
        this._context = context;
        this._listData = listData;
    }

    @Override
    public int getGroupCount() {
        return this._listData.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listData.get(groupPosition).getChildren()
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listData.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this._listData.get(groupPosition).getChildren()
                .get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }



    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        DataObject header =  _listData.get(groupPosition);//getGroup(groupPosition));

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if(header.hasChildren()){
                convertView = inflater.inflate(R.layout.list_group, parent, false);

                TextView lblListHeader = (TextView) convertView
                    .findViewById(R.id.lblListHeader);
              lblListHeader.setText(header.getDescription());

            }
            else{
                convertView = inflater.inflate(R.layout.list_item, parent, false);
                CheckBox txtListChild = (CheckBox) convertView
                       .findViewById(R.id.lblListItem);

               txtListChild.setText(header.getDescription());
            }


//           if(header.hasChildren()){
//
//               TextView lblListHeader = (TextView) convertView
//                       .findViewById(R.id.lblListHeader);
//               lblListHeader.setText(header.getDescription());
//           }
//            else {
//               CheckBox txtListChild = (CheckBox) convertView
//                       .findViewById(R.id.lblListItem);
//
//               txtListChild.setText(header.getDescription());
//           }
        }




        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

         String childText = _listData.get(groupPosition).getChildren().get(childPosition).getDescription(); //getChild(groupPosition, childPosition)).getDescription();

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);

            TextView txtListChild = (CheckBox) convertView
                    .findViewById(R.id.lblListItem);

            txtListChild.setText(childText);
        }


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
