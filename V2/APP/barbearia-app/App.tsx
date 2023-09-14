import { StatusBar } from 'expo-status-bar';
import { NativeBaseProvider } from 'native-base';
import { TEMAS } from './src/estilos/tema';

export default function App() {
  return (
    <NativeBaseProvider theme={TEMAS}>
      <StatusBar backgroundColor={TEMAS.colors.cinza.cinzaEscuro}/>
    </NativeBaseProvider>
  );
}