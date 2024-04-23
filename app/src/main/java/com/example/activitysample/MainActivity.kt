package com.example.activitysample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.activitysample.ui.theme.ActivitySampleTheme

class MainActivity : ComponentActivity() {

    private var count: Int = 0

    private val tag = this::class.java.name

    /**
     * onCreate(): callback for creating activity instance, followed by onStart
     *             create views and bind data to views
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show()
        Log.d(tag, "onCreate()")

        count = savedInstanceState?.getInt(SAVED_STATE_STRING_KEY) ?: 0

        setContent {
            ActivitySampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Greeting("MainActivity")
                        Text(text = "Sample app for Activity")
                        Text(
                            text = StringBuilder().apply {
                                append("Action: ${intent?.action}\n")
                                append("URI: ${intent?.toUri(Intent.URI_INTENT_SCHEME)}\n")
                            }.toString()
                        )
                        Text(text = "")
                        Text(text = "Button clicked times: $count")
                        Button(onClick = { count++ }) {
                            Text(text = "increase count")
                        }
                        Button(onClick = {
                            val intent = Intent(this@MainActivity, SecondaryActivity::class.java)
                            startActivity(intent)
                        }) {
                            Text(text = "Open Secondary Activity")
                        }
                    }
                }
            }
        }
    }

    /**
     * onRestart(): similar to onStart, but called when restore from previous instance.
     *              For example, app is killed by the system when onStopped is called, and the user
     *              then tries to return the app.
     *              followed by onStart()
     * */
    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "onRestart()", Toast.LENGTH_SHORT).show()
        Log.d(tag, "onRestart()")
    }

    /**
     * onStart(): callback for preparing to become visible, followed by onRestart if applicable
     * */
    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show()
        Log.d(tag, "onStart()")
    }

    /**
     * onResume(): callback when the activity starts interacting with the user, or the user
     *             returned to the app from either a Paused state or Stopped but not
     *             destroyed. Following either onStart or onRestart
     * */
    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume()", Toast.LENGTH_SHORT).show()
        Log.d(tag, "onResume()")
    }

    /**
     * onPause(): callback when app is no longer in focus but may be partially visible still,
     *            for example, user taps Back or Recents button.
     *            followed by onResume if user returns to app (becomes focused) or onStopped
     *            is app is destroyed (quit by the user or destroyed by the system to release
     *            resources)
     * */
    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause()", Toast.LENGTH_SHORT).show()
        Log.d(tag, "onPause()")
    }

    /**
     * onStop(): When the app becomes invisible, app being destroyed, new activity starting
     *           or existing activity is entering a Resumed state
     *           followed by onRestart() or onDestroy()
     * */
    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop()", Toast.LENGTH_SHORT).show()
        Log.d(tag, "onStop()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(SAVED_STATE_STRING_KEY, count)
        Log.d(tag, "onSaveInstanceState()")
        Toast.makeText(this, "onSaveInstanceState()", Toast.LENGTH_SHORT).show()
        super.onSaveInstanceState(outState)
    }

    /**
     * onDestroy(): App is killed by the system or user. Releasing resources here
     * */
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_SHORT).show()
        Log.d(tag, "onDestroy()")
    }

    companion object {
        private const val SAVED_STATE_STRING_KEY = "SAVED_STATE_STRING_KEY"
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ActivitySampleTheme {
        Greeting("Android")
    }
}