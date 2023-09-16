import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import Login from "./Login";
import Cadastro from "./Cadastro";

const Stack = createNativeStackNavigator();

export default function Rotas() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
      <Stack.Screen
          name="Cadastro"
          component={Cadastro as React.FC}
          options={
            {
              headerShown: false
            }
          }
        />
        <Stack.Screen
          name="Login"
          component={Login as React.FC}
          options={
            {
              headerShown: false
            }
          }
        />
      </Stack.Navigator>
    </NavigationContainer>
  )
}