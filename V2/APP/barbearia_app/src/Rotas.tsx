import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import Login from "./Login";
import Cadastro from "./Cadastro";
import { TEMAS } from "./estilos/tema";
import Tabs from "./Tabs";


const Stack = createNativeStackNavigator();

export default function Rotas() {
  return (
    <NavigationContainer>
      <Stack.Navigator>

        <Stack.Screen
          name="Login"
          component={Login as React.FC}
          options={
            {
              headerShown: false
            }
          }
        />
        <Stack.Screen
          name="Cadastro"
          component={Cadastro as React.FC}
          options={{
            headerShown: true,
            headerTitle: "",
            headerStyle: {
              backgroundColor: TEMAS.body.corFundo
            },
            headerTintColor: TEMAS.colors.marrom.normal
          }}
        />
        <Stack.Screen
          name="Tabs"
          component={Tabs as React.FC}
          options={{ headerShown: false }}
        />



      </Stack.Navigator>
    </NavigationContainer>
  )
}