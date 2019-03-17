import React, {Component} from "react";
import {Button, TextInput, View} from "react-native";

const url: string = "http://10.0.2.2:8080/api/user/add";

class AddForm extends Component {

    state = {
        firstName: '',
        lastName: '',
        username: '',
        password: '',
        phoneNumber: ''
    };


    save() {
        fetch(url, {
            method: "POST",
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(this.state)

        })
    }

    handleFirstName = (text) => {
        this.setState({firstName: text})
    };
    handleLastName = (text) => {
        this.setState({lastName: text})
    };
    handleUsername = (text) => {
        this.setState({username: text})
    };
    handlePassword = (text) => {
        this.setState({password: text})
    };
    handlePhoneNumber = (text) => {
        this.setState({phoneNumber: text})
    };


    render() {
        return (
            <View>
                <TextInput placeholder='first name' onChangeText={this.handleFirstName}/>
                <TextInput placeholder='last name' onChangeText={this.handleLastName}/>
                <TextInput placeholder='username' onChangeText={this.handleUsername}/>
                <TextInput placeholder='password' onChangeText={this.handlePassword}/>
                <TextInput placeholder='phone number' onChangeText={this.handlePhoneNumber}/>

                <Button title='save'
                        onPress={() => this.save()}
                />

            </View>

        );
    }
}


export default AddForm;
