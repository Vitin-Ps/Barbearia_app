import { Box, Image, KeyboardAvoidingView,Text } from "native-base";
import { TEMAS } from "./estilos/tema";
import Logo from './assets/images/Logo.png';
import { Titulo } from "./componentes/Titulo";
import { TextoComLink } from "./componentes/TextoComLink";
import { SwitchComTexto } from "./componentes/SwitchComTexto";
import React, { useState } from "react";
import { EstadoClick } from "./componentes/EstadoClick";
import { EntradaTexto } from "./componentes/EntradaTexto";
import { EntradaSenha } from "./componentes/EntradaSenha";
import Botao from "./componentes/Botao";
import { Platform } from "react-native";

export default function Login() {
    const [isLoading, setIsLoading] = useState(false);

    return (
        <KeyboardAvoidingView
            backgroundColor={TEMAS.body.corFundo}
            alignItems="center"
            justifyContent="center"
            flex={1}
            p={5}
            h={{
            base: "100px",
            lg: "auto"
            }} behavior={Platform.OS === "ios" ? "padding" : "height"}
            >
            <Image source={Logo} alt="Logo Arctos" />
            <Titulo>
                Bem Vindo
            </Titulo>
            
                <Box>
                <EntradaTexto
                    icon="person"
                    placeholder="Login"
                />
                <EntradaTexto
                    placeholder="Senha"
                    senha={true}
                />
                </Box>
          
            
            <Botao 
                isLoading={isLoading} 
                onPress={() => EstadoClick( setIsLoading)}
            >
                
                <Text color="white" fontSize="20px">
                    Entrar
                </Text>
            </Botao>
            

            <SwitchComTexto>
                <Text>Lembrar meu Login</Text>
            </SwitchComTexto>

            <TextoComLink>
                <Text>Esqueceu sua senha?</Text>
                <Text> Clique aqui</Text>
            </TextoComLink>
            <TextoComLink>
                <Text>Não tem Cadastro? </Text>
                <Text>Cadastre-se aqui!</Text>
            </TextoComLink>
        </KeyboardAvoidingView>
    )
}