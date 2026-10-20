import { Stack } from 'expo-router';
import { useState }  from "react";

export default function RootLayout() {
  // //replacing this with real auth logic later
  // const  [isLoggedIn, setIsLoggedIn] = useState(false);
  return (
    <Stack screenOptions={{headerShown: false}}>
      <Stack.Screen name="(auth)/login" />
      <Stack.Screen name="(tabs)" />
    </Stack>
  );
}
