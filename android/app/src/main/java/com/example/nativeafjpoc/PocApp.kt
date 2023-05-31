package com.example.nativeafjpoc

import android.app.Application
import com.facebook.react.PackageList
import com.facebook.react.ReactApplication
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.defaults.DefaultReactNativeHost
import com.facebook.soloader.SoLoader

class PocApp: Application(), ReactApplication {

    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this, false)
    }

    override fun getReactNativeHost(): ReactNativeHost {
        return object : DefaultReactNativeHost(this) {
            override fun getUseDeveloperSupport() = BuildConfig.DEBUG
            override fun getPackages(): List<ReactPackage> {
                // Packages that cannot be autolinked yet can be added manually here
                return PackageList(this).packages.toMutableList()
                    .apply { add(TestPackage()) }
            }
        }
    }
}
