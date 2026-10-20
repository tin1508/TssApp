import { StyleSheet } from "react-native";

export const loginPageStyles = StyleSheet.create({
    textInput:{
        width: '80%',
        height: 50,
        backgroundColor: "#fff",
        borderRadius: 8,
        paddingHorizontal: 15,
        color: '#fff',
        marginBottom: 30,
        borderWidth: 1, 
        borderColor: '#555',
    },
    buttonText: {
        color: '#fff',
        fontSize: 18,
        fontWeight: 'bold',
    },
    buttonContainer: {
        width: '70%',
        height: 60,
        marginHorizontal: 20,
        alignItems: 'center',
        justifyContent: 'center',
        padding: 3,
        marginTop: 15,
        backgroundColor: '#ffd33d',
        borderRadius: 50,
    },
    button: {
        borderRadius: 50,
        width: '100%',
        height: 55,
        alignItems: 'center',
        justifyContent: 'center',
        flexDirection: 'row',
    },
    buttonLabel: {
        color: '#fff',
        fontSize: 16,
    },
    image: {
        width: 100,
        height: 100,
        borderRadius: 18,
        marginBottom: 30,
    },
});