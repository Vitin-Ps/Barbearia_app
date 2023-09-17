import { NativeBaseProvider, StatusBar} from "native-base";
import { TEMAS } from "./src/estilos/tema";
import Rotas from "./src/Rotas";
import Cadastro from "./src/Cadastro";
import Login from "./src/Login";
export default function App() {
  return (
    <NativeBaseProvider theme={TEMAS}>
      <StatusBar backgroundColor={TEMAS.colors.cinza.cinzaEscuro} />
        <Rotas />
        {/* <Cadastro /> */}
        {/* <Login /> */}
    </NativeBaseProvider>
  )
}