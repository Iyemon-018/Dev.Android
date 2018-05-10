package com.example.iyemon018.visionapiexample

import android.content.Intent
import android.databinding.DataBindingUtil
import android.graphics.Bitmap
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import com.example.iyemon018.visionapiexample.databinding.ActivityMainBinding
import com.example.iyemon018.visionapiexample.useCase.RequestIntentService
import com.example.iyemon018.visionapiexample.useCase.ToastMessageService
import com.example.iyemon018.visionapiexample.viewModel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val messageService = ToastMessageService(this)
        val requestIntentService = RequestIntentService(this)

        binding.vm = MainActivityViewModel(messageService, requestIntentService)

        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * Dispatch incoming result to the correct fragment.
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RequestIntentService.TAKE_PICTURE_REQUEST_CODE) {
            if (data != null) {
                if (data.extras == null) {
                    Toast.makeText(this, "data.extras is null.", Toast.LENGTH_LONG).show()
                } else {
                    val extrasData = data.extras.get("data")
                    if (extrasData == null) {
                        Toast.makeText(this, "extras.data not exist.", Toast.LENGTH_LONG).show()
                    } else {
                        val bitmap = extrasData as Bitmap
                        findViewById<ImageView>(R.id.imageView).setImageBitmap(bitmap)
                    }
                }
            }
        }

    }
}
