import { useEffect, useState, useRef } from "react";

import { Box, ScrollView, Text, } from "native-base";
import { TEMAS } from "./estilos/tema";
import { Titulo } from "./componentes/Titulo";
import { EntradaTexto } from "./componentes/EntradaTexto";
import Botao from "./componentes/Botao";
import { sessoes } from "./utils/CadastroEntradaTexto";
import { KeyboardAwareScrollView } from "react-native-keyboard-aware-scroll-view";

export default function Cadastro() {

    const [numSessao, setNumSessao] = useState(0);
    const [estadoSessao, setEstadoSessao] = useState(false);
    const [dados, setDados] = useState({} as any); 
    const inputsCarregados = useRef(false); // usado para mudar informções sem ter que renderizar a página novamente

    function avancarSessao() {
        if (numSessao < sessoes.length - 1) {
          setNumSessao(numSessao + 1);
          setEstadoSessao(false);
          inputsCarregados.current = false; // Reset da flag
        } else {
          return;
        }
      }
    
      function voltarSessao() {
        if (numSessao > 0) {
          setNumSessao(numSessao - 1);
          setEstadoSessao(false);
          inputsCarregados.current = false; // Reset da flag
        } else {
          return;
        }
      }
    
      function atualizarDados(id: string, valor: string) {
        setDados({ ...dados, [id]: valor });
      }
    
      useEffect(() => {
        if (inputsCarregados.current === false) { // quando ele estiver false vai carregar apagina tda no false e depois vai mudar para o true 
          // Se os inputs ainda não foram carregados, muda o estado
          setEstadoSessao(true);
          inputsCarregados.current = true; // Atualiza a flag
        }
      }, [numSessao]);
    


   // Restante do seu código...

return (
    <ScrollView
        flex={1}
        bgColor={TEMAS.body.corFundo}>
        <KeyboardAwareScrollView
            contentContainerStyle={{ flexGrow: 1 }}
            extraScrollHeight={30}
            enableOnAndroid={true}
        >
            <ScrollView
                flex={1}
                p={5}
                backgroundColor={TEMAS.body.corFundo}
            >
                <Titulo
                    fontSize={30}
                    color={TEMAS.body.corFonte}
                >
                    {sessoes[numSessao].titulo}
                </Titulo>
  
                <Box>
                    {
                        sessoes[numSessao]?.entradaTexto?.map(entrada => {
                            const valorTexto = estadoSessao === false ? "" : dados[entrada.placeholder]
                            return < EntradaTexto
                                icon={entrada.icon}
                                placeholder={entrada.placeholder}
                                senha={entrada.senha}
                                key={entrada.id}
                                value={valorTexto}
                                onChangeText={(text) => atualizarDados(entrada.name, text)}
                                mt="16"
                            />
                        })
                    }
                </Box>
               
                <Box flexDirection="row" justifyContent="center">
                    {numSessao > 0 && (
                        <Botao
                            onPress={() => voltarSessao()}
                            bgColor={TEMAS.colors.marrom.escuro}
                        >
                            <Text color="white" fontSize="20px">
                                Voltar
                            </Text>
                        </Botao>
                    )}
                    <Botao onPress={() => avancarSessao()}>
                        <Text color="white" fontSize="20px">
                            {numSessao === 2 ? 'Finalizar' : 'Avançar'}
                        </Text>
                    </Botao>
                   
                </Box>
            </ScrollView>
        </KeyboardAwareScrollView>
    </ScrollView>
  );
  

}