import React, {Component} from "react";
import {Button, TextInput, View} from "react-native";

const url: string = "http://10.0.2.2:8080/api/user/edit";

class EditForm extends Component {

    state = {
            firstName: '',
            lastName: '',
            username: '',
            password: '',
            phoneNumber: ''

    };

    componentDidMount = () => {

        const {navigation} = this.props;

        this.setState({

               id:  navigation.getParam("id", ""),
               firstName:  navigation.getParam("firstName", ""),
               lastName:  navigation.getParam("lastName", ""),
               username:  navigation.getParam("username", ""),
               phoneNumber:  navigation.getParam("phoneNumber", "")

        })


    };


    save= () => {


        console.log(this.state);

        fetch(url, {
            method: "POST",
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(this.state)

        })
    };

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
                <TextInput placeholder='first name' onChangeText={this.handleFirstName}  value={this.state.firstName}/>
                <TextInput placeholder='last name' onChangeText={this.handleLastName} value={this.state.lastName}/>
                <TextInput placeholder='username' onChangeText={this.handleUsername} value={this.state.username}/>
                <TextInput placeholder='password' onChangeText={this.handlePassword} value={this.state.password}/>
                <TextInput placeholder='phone number' onChangeText={this.handlePhoneNumber} value={this.state.phoneNumber}/>

                <Button title='save'
                        onPress={() => this.save()}
                />
            </View>

        );
    }
}


export default EditForm;
