import React, {Component} from "react";
import {Button, Text, View} from "react-native";


const url: string = "http://10.0.2.2:8080/api/user/get/";

class Get extends Component {

    state = {
        user: ''
    };

    componentDidMount = () => {

        const {navigation} = this.props;
        const id = navigation.getParam("id", "no id");


        fetch(url + id, {
            method: 'GET'
        })
            .then((response) => response.json())
            .then((responseJson) => {
                this.setState({
                    user: responseJson.user
                })
            })
            .catch((error) => {
                console.error(error);
            });
    };


    render(): React.ReactNode {
        return (
            <View>
                <Text> ID : {this.state.user.id}</Text>
                <Text> First Name : {this.state.user.firstName}</Text>
                <Text> Last Name : {this.state.user.lastName}</Text>
                <Text> Username : {this.state.user.username}</Text>
                <Text> Phone : {this.state.user.phoneNumber}</Text>
                <Text> Created At : {this.state.user.updatedAt}</Text>
                <Text> Updated At : {this.state.user.updatedAt}</Text>


                <Button
                    onPress = {
                        () => {
                            this.props.navigation.navigate('edit', {
                                id: this.state.user.id,
                                firstName: this.state.user.firstName,
                                lastName: this.state.user.lastName,
                                username: this.state.user.username,
                                phoneNumber: this.state.user.phoneNumber
                            })
                        }
                    }
                    title = "Edit"
                />

            </View>

        );
    }

}

export default Get;
