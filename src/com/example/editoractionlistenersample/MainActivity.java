package com.example.editoractionlistenersample;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends Activity {

    TextView mTextView = null;

    OnEditorActionListener mDoneEditorActionListener = new OnEditorActionListener() {

        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                if (mTextView != null) {
                    mTextView.setText(R.string.done_hint);
                }
                return true;
            }
            return false;
        }
    };

    OnEditorActionListener mSearchEditorActionListener = new OnEditorActionListener() {

        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                if (mTextView != null) {
                    mTextView.setText(R.string.search_hint);
                }
                return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textview);
        EditText doneEditText = (EditText) findViewById(R.id.done_edittext);
        EditText searchEditText = (EditText) findViewById(R.id.search_edittext);

        doneEditText.setOnEditorActionListener(mDoneEditorActionListener);
        searchEditText.setOnEditorActionListener(mSearchEditorActionListener);
    }

}
