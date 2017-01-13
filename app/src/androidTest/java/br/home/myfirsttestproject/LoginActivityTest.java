package br.home.myfirsttestproject;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.home.myfirsttestproject.ui.LoginActivity;
import br.home.myfirsttestproject.ui.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class, false, true);

    @Test
    public void whenActivityIsLaunched_shouldDisplayInitialState() {
        onView(withId(R.id.txt_hello_world)).check(matches(isDisplayed()));
    }

    @Test
    public void whenUsernameIsEmpty_andClickOnLoginButton_shouldDisplayDialog() {
        testEmptyFieldState(R.id.editText_login);
    }

    @Test
    public void whenPasswordisEmpty_andClickOnLoginButton_shouldDisplayDialog() {
        testEmptyFieldState(R.id.editText_senha);
    }

    private void testEmptyFieldState(int notEmptyFieldId) {
        onView(withId(notEmptyFieldId)).perform(typeText("defaultText"), closeSoftKeyboard());
        onView(withId(R.id.button_login)).perform(click());
        onView(withText(R.string.validation_message)).check(matches(isDisplayed()));
        onView(withText(R.string.ok)).perform(click());
    }

    @Test
    public void whenBothFieldsAreEmpty_andClickOnLoginButton_shouldDisplayDialog() {
        whenBothFieldsAreEmpty_andClickOnLoginButton_shouldDisplayDialog(R.id.editText_login, R.id.editText_senha);
    }

    private void whenBothFieldsAreEmpty_andClickOnLoginButton_shouldDisplayDialog(int... fields) {
        for (int i = 0; i < fields.length; i++) {
            onView(withId(fields[i])).check(matches(withText("")));
        }
        onView(withId(R.id.button_login)).perform(click());
        onView(withText(R.string.validation_message)).check(matches(isDisplayed()));
        onView(withText(R.string.ok)).perform(click());
    }

    @Test
    public void whenBothFieldsAreFilled_andClickOnLoginButton_shouldOpenMainActivityResult() {
        Intents.init();
        onView(withId(R.id.editText_login)).perform(typeText("login"), closeSoftKeyboard());
        onView(withId(R.id.editText_senha)).perform(typeText("senha"), closeSoftKeyboard());
        Matcher<Intent> matcher = hasComponent(MainActivity.class.getName());

        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, null);
        intending(matcher).respondWith(result);

        onView(withId(R.id.button_login)).perform(click());
        onView(withText(R.string.validation_message)).check(matches(isDisplayed()));
        onView(withText(R.string.ok)).perform(click());

        intended(matcher);
        Intents.release();
    }

    @Test
    public void whenBothFieldsAreFilled_andClickOnLoginButton_shouldOpenMainActivity() {
        Intents.init();

        onView(withId(R.id.editText_login)).perform(typeText("login"), closeSoftKeyboard());
        onView(withId(R.id.editText_senha)).perform(typeText("senha"), closeSoftKeyboard());

        Matcher<Intent> matcher = hasComponent(MainActivity.class.getName());

        onView(withId(R.id.button_login)).perform(click());
        onView(withText(R.string.validation_message)).check(matches(isDisplayed()));
        onView(withText(R.string.ok)).perform(click());

        intended(matcher);
        Intents.release();
    }
}