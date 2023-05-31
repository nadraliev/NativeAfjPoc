package com.example.nativeafjpoc

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.nativeafjpoc.databinding.ActivityMainBinding
import com.facebook.react.PackageList
import com.facebook.react.ReactFragment
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactPackage
import com.facebook.react.common.LifecycleState
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
import com.facebook.react.modules.core.DeviceEventManagerModule
import com.facebook.soloader.SoLoader

class MainActivity : AppCompatActivity(), DefaultHardwareBackBtnHandler {

    private lateinit var binding: ActivityMainBinding

    private lateinit var reactFragment: ReactFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        reactFragment = ReactFragment.Builder()
            .setComponentName("MyReactNativeApp")
            .setLaunchOptions(getLaunchOptions("test message"))
            .build()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.reactNativeFragment, reactFragment)
            .commit()

        TestModule.listener = {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }

        // this doesn't work
        binding.accept.setOnClickListener {
            (application as PocApp).reactNativeHost.reactInstanceManager.currentReactContext
                ?.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter::class.java)
                ?.emit("accept_event", "test params")
        }
    }

    override fun invokeDefaultOnBackPressed() {
        reactFragment.onBackPressed()
    }

    private fun getLaunchOptions(message: String) = Bundle().apply {
        putString("message", message)
    }

}