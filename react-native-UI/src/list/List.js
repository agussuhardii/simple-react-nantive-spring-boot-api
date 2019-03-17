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
    list: {
        screen:List,
        navigationOptions:()=>({
            title: "HOME",
            headerBackTitle:null
        })
    },
    get: {
        screen:Get,
        navigationOptions:()=>({
            title: "GET"
        })

    },
    edit:{
        screen:EditForm,
        navigationOptions:()=>({
            title: "EDIT"
        })

    },
    add: {
        screen:AddForm,
        navigationOptions:()=>({
            title: "ADD"
        })

    }



});

export default createAppContainer(AppNavigator);
