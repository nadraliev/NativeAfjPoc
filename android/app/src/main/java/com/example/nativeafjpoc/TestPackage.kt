package com.example.nativeafjpoc

import android.view.View
import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ReactShadowNode
import com.facebook.react.uimanager.ViewManager

class TestPackage: ReactPackage {

    override fun createNativeModules(p0: ReactApplicationContext): MutableList<NativeModule> =
        listOf(TestModule(p0)).toMutableList()

    override fun createViewManagers(p0: ReactApplicationContext): MutableList<ViewManager<View, ReactShadowNode<*>>> = mutableListOf()
}
