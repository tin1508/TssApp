import { View, Text, StyleSheet, TextInput, Button} from "react-native";
import { router } from "expo-router";
import { globalStyles } from "../styles/globalStyles";
import { loginPageStyles } from "../styles/loginPage";
import ImageViewer from "../components/IconApp";
import { useState } from "react";

export default function LoginScreen() {

  const [storeName, setStoreName] = useState("");
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const securePwdEntry = (text: string) => {
    
  }

  return (
    <View style={globalStyles.container}>
      <ImageViewer imgSource={require("../../assets/images/Tss_app_icon.png")}/>
      <Text style={globalStyles.text}> Welcome to TSS App</Text>

      {/* Store Name Input*/}
      <TextInput 
        style={loginPageStyles.textInput}
        placeholder="Store Name (e.g., Tin's grocery,...)"
        placeholderTextColor="#808080"
        value={storeName}
        onChangeText={setStoreName}
      />

      {/* Username Input*/}
      <TextInput 
        style={loginPageStyles.textInput}
        placeholder="Username"
        placeholderTextColor="#808080"
        value={username}
        onChangeText={setUsername}
      />

      {/* Password Input*/}
      <TextInput 
        style={loginPageStyles.textInput}
        placeholder="Password"
        placeholderTextColor="#aaa"
        secureTextEntry={true}
        value={password}
        onChangeText={setPassword}
      />

      <Button title="Login" onPress={() => router.replace('/(tabs)')}/>
      <Button title="Sign Up"/>

    </View>
  )
}