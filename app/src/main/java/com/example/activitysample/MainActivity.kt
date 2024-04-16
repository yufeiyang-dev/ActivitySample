package com.example.activitysample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.activitysample.ui.theme.ActivitySampleTheme

class MainActivity : ComponentActivity() {

    /**
     * onCreate(): callback for creating activity instance, followed by onStart
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ActivitySampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Greeting("Android")
                        Text(text = "Sample app for Activity")
                        Text(
                            text = StringBuilder().apply {
                                append("Action: ${intent?.action}\n")
                                append("URI: ${intent?.toUri(Intent.URI_INTENT_SCHEME)}\n")
                            }.toString()
                        )
                    }
                }
            }
        }
    }

    /**
     * onStart(): callback for preparing to become visible, followed by onRestart if applicable
     * */
    override fun onStart() {
        super.onStart()
    }

    /**
     * onRestart(): similar to onStart, but called when restore from previous instance.
     *              For example, app is killed by the system when onStopped is called, and the user
     *              then tries to return the app.
     * */
    override fun onRestart() {
        super.onRestart()
    }

    /**
     * onResume(): callback when the activity starts interacting with the user, or the user
     *             returned to the app from either a Paused state or Stopped but not
     *             destroyed. Following either onStart or onRestart
     * */
    override fun onResume() {
        super.onResume()
    }

    /**
     * onPause(): callback when app is no longer in focus but may be partially visible still,
     *            followed by onResume if user returns to app (becomes focused) or onStopped
     *            is app is destroyed (quit by the user or destroyed by the system to release
     *            resources)
     * */
    override fun onPause() {
        super.onPause()
    }

    /**
     * onStop(): When the app becomes invisible
     * */
    override fun onStop() {
        super.onStop()
    }

    /**
     * onDestroy(): App is killed by the system.
     * */
    override fun onDestroy() {
        super.onDestroy()

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