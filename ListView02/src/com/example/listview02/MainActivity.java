package com.example.listview02;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity
{
 
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        String[] menus={"选项01","选项02","选项03"};
      
       setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,menus));
       getListView().setTextFilterEnabled(true);
    }
    
	protected void onListItemClick(ListView l,View v,int position,long id)
	{
		switch(position)
		{
		case 0:
			System.out.println("Item01");
			break;
		case 1:
			System.out.println("Item02");
			break;
		case 2:
			System.out.println("Item03");
			break;
		
		}
		
	}
}
