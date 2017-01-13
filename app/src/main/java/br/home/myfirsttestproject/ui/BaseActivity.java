package br.home.myfirsttestproject.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import br.home.myfirsttestproject.network.model.ErrorVO;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getCanonicalName();

    /**
     * Change de null parameter in {@code setContentView()}
     * to a layout resource {@code R.layout.example}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: hit");
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: hit");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: hit");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: hit");
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRequestError(ErrorVO errorVO) {
        if (handleError(errorVO)) {
            return;
        }
        Log.e(TAG, "onRequestError: " + errorVO.getError());
    }

    /**
     * If you wish to handle the error in a particular way, override this method in your activity
     * and return true.
     */
    protected boolean handleError(ErrorVO errorVO) {
        return false;
    }
}