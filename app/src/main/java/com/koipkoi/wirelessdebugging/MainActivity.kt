package com.koipkoi.wirelessdebugging

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.service.quicksettings.TileService
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    try {
      val intent = Intent(TileService.ACTION_QS_TILE_PREFERENCES).apply {
        putExtra(
          Intent.EXTRA_COMPONENT_NAME,
          ComponentName(
            "com.android.settings",
            "com.android.settings.development.qstile.DevelopmentTiles\$WirelessDebugging"
          )
        )
      }
      startActivity(intent)
    } catch (e: Exception) {
      Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
    }

    finish()
  }
}
