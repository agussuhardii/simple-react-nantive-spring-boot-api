import React, {Component} from "react";
import {Button, Text, View} from "react-native"
import Get from "./Get";
import EditForm from "../form/EditForm";
import {createAppContainer, createStackNavigator} from "react-navigation";
import AddForm from "../form/AddForm";

const url: string = "http://10.0.2.2:8080/api/user";


class List extends Component {

    state = {
        users: []
    };

    componentDidMount = () => {
        fetch(url, {
            method: 'GET'
        })
            .then((response) => response.json())
            .then((responseJson) => {
                this.setState({
                    users: responseJson.users.content
                })
            })
            .catch((error) => {
                console.error(error);
            });
    };

    render() {

        return (
            <View>

                <Button title='Add' onPress={
                    () => this.props.navigation.navigate("add")
                }/>

                {
                    this.state.users.map((item) => (

                            <View>
                                <Text
                                    onPress={
                                        () => {
                                            this.props.navigation.navigate('get', {id: item.id})
                                        }
                                    }
                                >
                                    {item.id}
                                </Text>
                            </View>
                        )
                    )

                }

            </View>
        )
    }
}


const AppNavigator = createStackNavigator({
    list: List,
    get: Get,
    edit: EditForm,
    add: AddForm,

});

export default createAppContainer(AppNavigator);
