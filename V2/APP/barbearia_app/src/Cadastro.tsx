import { useEffect, useState } from "react";

import { Box, ScrollView, Text, } from "native-base";
import { TEMAS } from "./estilos/tema";
import { Titulo } from "./componentes/Titulo";
import { EntradaTexto } from "./componentes/EntradaTexto";
import Botao from "./componentes/Botao";
import { sessoes } from "./utils/CadastroEntradaTexto";
import { KeyboardAwareScrollView } from "react-native-keyboard-aware-scroll-view";

export default function Cadastro() {

    const [numSessao, setNumSessao] = useState(0);
    const [sessaoAnterior, setSessaoAnterior] = useState(-1);
    const [dados, setDados] = useState({} as any); // {} --> vai ser um obejto e any --> qualque coisa 

    useEffect(() => {
        function teste() {  // Renomeada a função
            console.log("Entrei no cadastro --> ns: " + numSessao)
            console.log("Entrei no cadastro --> s: " + sessaoAnterior)
        }
        teste();  // Chamando a função correta
    }, []);
    function avancarSessao() {
        if (numSessao < sessoes.length - 1) {
            setSessaoAnterior(sessaoAnterior + 1);  // Sessão anterior é a atual antes de avançar
            setNumSessao(numSessao + 1);
        } else {
            return;
        }
    }
    
    function voltarSessao() {
        if(numSessao == sessoes.length - 1) {
            setSessaoAnterior(sessoes.length - 1)
        } 
        // else {
        //     setSessaoAnterior(sessaoAnterior - 1)
        // }
        if (numSessao > 0) {
            setNumSessao(numSessao - 1);
        } else {
            return;
        }
    }

    
    


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
                                // console.log("nst: " + numSessao + "\nnumDados: " + sessoes[numSessao]?.id)
                                const valorCampo = numSessao > sessaoAnterior ? "stringoriginal" : (dados[entrada.placeholder] || '');

                                return < EntradaTexto
                                    icon={entrada.icon}
                                    placeholder={entrada.placeholder}
                                    senha={entrada.senha}
                                    key={entrada.id}
                                    value={valorCampo}
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
                        {
                            console.log("ns: " + numSessao)
                            
                        }
                        {
                            console.log("st: " + sessaoAnterior)
                        }
                    </Box>
                </ScrollView>
            </KeyboardAwareScrollView>
        </ScrollView>

    )

}