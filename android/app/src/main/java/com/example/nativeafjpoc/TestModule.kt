package com.example.nativeafjpoc

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class TestModule(reactContext: ReactApplicationContext): ReactContextBaseJavaModule(reactContext) {

    companion object {
        var listener: ((String) -> Unit)? = null
    }

    override fun getName(): String = "TestModule"

    @ReactMethod
    fun notify(message: String) {
        listener?.invoke(message)
    }

}
