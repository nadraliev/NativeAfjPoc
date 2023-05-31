import React from 'react';
import {AppRegistry, Button, StyleSheet, Text, TouchableOpacity, View, Alert, NativeModules, NativeEventEmitter} from 'react-native';

const {TestModule} = NativeModules;

const eventEmitter = new NativeEventEmitter(NativeModules.ToastExample);
   this.eventListener = eventEmitter.addListener('accept_event', event => {
      console.log(event.eventProperty) // "someValue"
      TestModule.notify(event);
   });

const HelloWorld = () => {
  return (
    <View style={styles.container}>
      <Text style={styles.hello}>Hello, World</Text>
      <TouchableOpacity 
      onPress={
        () => {
          // Alert.alert('Alert Title', 'My Alert Msg', [
          //   {
          //     text: 'Cancel',
          //     onPress: () => console.log('Cancel Pressed'),
          //     style: 'cancel',
          //   },
          //   {text: 'OK', onPress: () => console.log('OK Pressed')},
          // ]);      
          TestModule.notify('Notification from React Native');
        }
      } 
      style={{backgroundColor: '#00aa00'}}>
        <Text style={{color: '#ffffff'}}>I'm a react native button</Text>
      </TouchableOpacity>
    </View>
  );
};
var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
});

AppRegistry.registerComponent(
  'MyReactNativeApp',
  () => HelloWorld,
);