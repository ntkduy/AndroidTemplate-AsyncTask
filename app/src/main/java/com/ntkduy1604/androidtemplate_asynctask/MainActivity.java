package com.ntkduy1604.androidtemplate_asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = (TextView) findViewById(R.id.output);
    }

    public void runClickHandler(View view) {
//        output.append("Button clicked\n");
        /**
         * Create instance of the new AsyncTask
         */
        MyAsyncTask task = new MyAsyncTask();
        task.execute("String 1", "String 2", "String 3");
    }

    public void clearClickHandler(View view) {
        output.setText("");
    }

    private class MyAsyncTask extends AsyncTask<String, String, Void>{

        /**
         * @param params: match the type of the first declaration
         * @return: match the type of the third declaration
         */
        @Override
        protected Void doInBackground(String... params) {
            for (String string: params) {
                // Pass the values to onProgressUpdate()
                publishProgress(string);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        /**
         * @param values: match the type of the second declaration
         */
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            output.append(values[0] +"\n");
        }

        /**
         * Used to set up the app before running the task
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        /**
         * Can be used to return the data from the call
         * @param aVoid: match the type of the third declaration
         */
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

}
