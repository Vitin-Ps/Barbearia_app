import { useState } from "react";

import { Box, ScrollView, Text, } from "native-base";
import { TEMAS } from "./estilos/tema";
import { Titulo } from "./componentes/Titulo";
import { EntradaTexto } from "./componentes/EntradaTexto";
import Botao from "./componentes/Botao";
import { sessoes } from "./utils/CadastroEntradaTexto";
import { KeyboardAwareScrollView } from "react-native-keyboard-aware-scroll-view";

export default function Cadastro() {

    const [numSessao, setNumSessao] = useState(0);

    function avancarSessao() {
        if (numSessao < sessoes.length - 1) {
            setNumSessao(numSessao + 1)
        } else {
            return;
        }

    }

    function voltarSessao() {
        if (numSessao > 0) {
            setNumSessao(numSessao - 1)
        }
    }



    return (
        <ScrollView
        flex={1}
        bgColor={TEMAS.body.corFundo}>
            <KeyboardAwareScrollView
                contentContainerStyle={{ flexGrow: 1}}
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
                    >
                        {sessoes[numSessao].titulo}
                    </Titulo>

                    <Box>
                        {
                            sessoes[numSessao]?.entradaTexto?.map(entrada => {
                                return < EntradaTexto
                                    icon={entrada.icon}
                                    placeholder={entrada.placeholder}
                                    senha={entrada.senha}
                                    key={entrada.id}
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

    )

}