import { ImageSourcePropType, StyleSheet } from 'react-native';
import { Image } from 'expo-image';
import {loginPageStyles} from '../styles/loginPage';

type Props = {
  imgSource: ImageSourcePropType;
};

export default function ImageViewer({ imgSource }: Props) {
  return <Image source={imgSource} style={loginPageStyles.image} />;
}
