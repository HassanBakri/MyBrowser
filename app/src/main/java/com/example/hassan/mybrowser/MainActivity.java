package com.example.hassan.mybrowser;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    WebView View ;
    Button backbtn,gobtn,forwbtn;
    EditText urled;
    Stack<String> stack1;
    Stack<String> stack2;
    String buffer="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        View=(WebView)findViewById(R.id.webView);
        backbtn=(Button)findViewById(R.id.goBack);
        gobtn=(Button)findViewById(R.id.GO);
        forwbtn=(Button)findViewById(R.id.forw);
        urled=(EditText)findViewById(R.id.url);
        stack1=new Stack<>();
        stack2=new Stack<>();
    }
    public void goToUrl(View view){
        String url=urled.getText().toString();
        Toast.makeText(getApplicationContext(),"Goging To "+url,Toast.LENGTH_LONG).show();
        View.loadUrl(url);
        stack1.push(buffer);
        buffer=url;
    }
    public  void goBack(View v){
        Toast.makeText(getApplicationContext(),"GoBack Clicked",Toast.LENGTH_LONG).show();
        if(stack1.size()==1){
            Toast.makeText(this,"no url to back to",Toast.LENGTH_LONG).show();
        }else{
            String url=stack1.pop();
            stack2.push(buffer);
            buffer=url;
            Toast.makeText(getApplicationContext(),"Goging To "+url,Toast.LENGTH_LONG).show();
            View.loadUrl(url);
        }
    }
    public  void goForward(View v){
        Toast.makeText(getApplicationContext(),"goForward Clicked",Toast.LENGTH_LONG).show();
        if(stack2.empty()){
            Toast.makeText(this,"no url to go to",Toast.LENGTH_LONG).show();
        }else{
            String url=stack2.pop();
            stack1.push(buffer);
            buffer=url;
            Toast.makeText(getApplicationContext(),"Goging To "+url,Toast.LENGTH_LONG).show();
            View.loadUrl(url);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        return super.onOptionsItemSelected(item);
    }
}
