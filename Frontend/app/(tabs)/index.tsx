import { Link, Redirect } from 'expo-router';
import { Text, View } from 'react-native';
import { globalStyles } from '../styles/globalStyles';

export default function Index() {

  return <Redirect href="/(auth)/login" />;
}
