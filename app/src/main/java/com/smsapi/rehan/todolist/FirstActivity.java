package com.smsapi.rehan.todolist;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
public class FirstActivity extends ActionBarActivity {
    ListView list;
    CustomAdapter adapter;
    public FirstActivity firstActivity = null;
    public ArrayList<ListModal> values = new ArrayList<ListModal>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        firstActivity = this;
        setListData();
        /*list = (ListView)findViewById(R.id.lvnames);
        DataTrv obj = new DataTrv();
        String Lists[] = obj.GetList(getApplicationContext());
        String Names[] = new String[]{"No Item Found"};
        if(Lists.length>0) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, Lists);
            list.setAdapter(adapter);
        }
        else
        {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, Names);
            list.setAdapter(adapter);
        }*/
    }

    private void setListData() {
        DataTrv obj = new DataTrv();
        String List[] = obj.GetList(getApplicationContext());
        if (List.length > 0) {
            for (int i=0;i<List.length;i++){
                final ListModal ListModal = new ListModal();
                ListModal.setTitle(List[i]);
                values.add(ListModal);
            }
//            for (String temp : List) {
//                final ListModal ListModal = new ListModal();
//                ListModal.setTitle(temp);
//                Log.e("temp",temp);
//                values.add(ListModal);
//            }
            list = (ListView) findViewById(R.id.lvnames);
            Resources res = getResources();
            adapter = new CustomAdapter(firstActivity, values, res);
        }
        else

        {
            String temp = "No data found";
            final ListModal ListModal = new ListModal();
            ListModal.setTitle(temp);
            values.add(ListModal);
            list = (ListView) findViewById(R.id.lvnames);
            Resources res = getResources();
            adapter = new CustomAdapter(firstActivity, values, res);
        }}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id==R.id.action_add)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Enter Your Task");
            final EditText input = new EditText(this);
            builder.setView(input);
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    DataTrv obj = new DataTrv(getApplicationContext(),input.getText().toString());
                    setListData();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
