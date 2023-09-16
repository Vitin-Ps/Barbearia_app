import React from 'react';
import { View, TextInput, Button } from 'react-native';
import { KeyboardAwareScrollView } from 'react-native-keyboard-aware-scroll-view';




const MeuComponete = () => {
  return (
    <KeyboardAwareScrollView
      contentContainerStyle={{ flexGrow: 1 }}
      extraScrollHeight={100}
    >
      <View style={{ padding: 20 }}>
        <TextInput placeholder="Input 1" style={{ height: 40, borderColor: 'gray', borderWidth: 1, marginBottom: 10 }} />
        <TextInput placeholder="Input 2" style={{ height: 40, borderColor: 'gray', borderWidth: 1, marginBottom: 10 }} />
        {/* Add more TextInput components as needed */}
        <Button title="Submit" onPress={() => console.log('Submit button pressed')} />
      </View>
    </KeyboardAwareScrollView>
  );
};

export default MeuComponete;
