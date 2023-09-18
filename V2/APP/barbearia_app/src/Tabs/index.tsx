import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { TEMAS } from "../estilos/tema";

import Ionicons from "react-native-vector-icons/Ionicons"
import Home from "./Home";


const Tab = createBottomTabNavigator();
const screenOptions = {
    tabBarStyle: {
        backgroundColor: TEMAS.colors.cinza.cinzaEscuro
    },
    tabBarActiveTintColor: TEMAS.colors.marrom.normal,
    tabBarInactiveTintColor: TEMAS.colors.cinza.cinzaBlack
}

export const mainTabs = [
    {
        name: 'Home',
        component: Home,
        icon: 'home'
    }
]

export default function Tabs() {
    return (
        <Tab.Navigator
            screenOptions={screenOptions}
        >
            {
                mainTabs.map((tab) => (
                    <Tab.Screen
                        key={tab.name}
                        name={tab.name}
                        component={tab.component}
                        options={{
                            headerShown: false,
                          
                            tabBarIcon: ({ color, size }) => (
                                <Ionicons
                                    name={tab.icon}
                                    color={color}
                                    size={size}
                                />
                            ),
                            tabBarStyle: {
                                backgroundColor: TEMAS.colors.cinza.cinzaEscuro,
                                height: 60  // Defina a altura da barra
                            },
                            tabBarLabelStyle: {
                                height: 0,  // Oculta o rótulo
                            },
                        }}
                    />
                ))
            }
        </Tab.Navigator>
    )
}
