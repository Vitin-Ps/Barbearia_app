import { NativeBaseProvider, ScrollView, StatusBar} from "native-base";
import { TEMAS } from "./src/estilos/tema";
import Rotas from "./src/Rotas";

export default function App() {
  return (
    <NativeBaseProvider theme={TEMAS}>
      <StatusBar backgroundColor={TEMAS.colors.cinza.cinzaEscuro} />
        <Rotas />
    </NativeBaseProvider>
  )
}