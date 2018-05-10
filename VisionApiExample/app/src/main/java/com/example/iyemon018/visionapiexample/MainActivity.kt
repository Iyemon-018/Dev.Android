package com.example.iyemon018.visionapiexample

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.provider.MediaStore
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import com.example.iyemon018.visionapiexample.databinding.ActivityMainBinding
import com.example.iyemon018.visionapiexample.useCase.RequestIntentService
import com.example.iyemon018.visionapiexample.useCase.ToastMessageService
import com.example.iyemon018.visionapiexample.util.PermissionUtils
import com.example.iyemon018.visionapiexample.viewModel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val messageService = ToastMessageService(this)
        val requestIntentService = RequestIntentService(this)

        this.vm = MainActivityViewModel(messageService, requestIntentService)
        binding.vm = this.vm

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
//        if (requestCode == RequestIntentService.TAKE_PICTURE_REQUEST_CODE) {
//            if (data != null) {
//                if (data.extras == null) {
//                    Toast.makeText(this, "data.extras is null.", Toast.LENGTH_LONG).show()
//                } else {
//                    val extrasData = data.extras.get("data")
//                    if (extrasData == null) {
//                        Toast.makeText(this, "extras.data not exist.", Toast.LENGTH_LONG).show()
//                    } else {
//                        val bitmap = extrasData as Bitmap
//                        findViewById<ImageView>(R.id.imageView).setImageBitmap(bitmap)
//                    }
//                }
//            }
//        }

        if (requestCode == RequestIntentService.TAKE_PICTURE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            this.vm.onRequestFromCamera()
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, this.vm.pictureUri)
            findViewById<ImageView>(R.id.imageView).setImageBitmap(bitmap)
        }

    }

    /**
     * Callback for the result from requesting permissions. This method
     * is invoked for every call on [.requestPermissions].
     *
     *
     * **Note:** It is possible that the permissions request interaction
     * with the user is interrupted. In this case you will receive empty permissions
     * and results arrays which should be treated as a cancellation.
     *
     *
     * @param requestCode The request code passed in [.requestPermissions].
     * @param permissions The requested permissions. Never null.
     * @param grantResults The grant results for the corresponding permissions
     * which is either [android.content.pm.PackageManager.PERMISSION_GRANTED]
     * or [android.content.pm.PackageManager.PERMISSION_DENIED]. Never null.
     *
     * @see .requestPermissions
     */
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == RequestIntentService.TAKE_PICTURE_REQUEST_CODE) {
            if (PermissionUtils.permissionGranted(requestCode, RequestIntentService.TAKE_PICTURE_REQUEST_CODE, grantResults)) {

            }
        }
    }
}
