package br.home.myfirsttestproject;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

import java.io.IOException;

import br.home.myfirsttestproject.ui.MainActivity;
import okhttp3.mockwebserver.MockWebServer;

/**
 * Created by Ronan.lima on 12/01/17.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    private MockWebServer server;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class, false, false);

    @Before
    public void setUp() throws Exception {
        server = new MockWebServer();
        server.start();
    }

    @After
    public void tearDown() throws IOException {
        server.shutdown();
    }
}
