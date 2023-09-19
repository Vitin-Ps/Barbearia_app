import { Image, ScrollView, Text, VStack, HStack, Avatar, Button } from "native-base";
import Logo from "../assets/images/Logo.png";

import { TEMAS } from "../estilos/tema";
import { Titulo } from "../componentes/Titulo";
import BotaoComImagem from "../componentes/BotaoComImagem";

export default function Home() {
    return (
        <VStack
            backgroundColor={TEMAS.body.corFundo}
            flex={1}
            alignItems="center"
            justifyContent="center"
            p={2}
        >
            <HStack p={5} m={2} alignItems="center">
                <Image
                    source={Logo}
                    alt="Logo Barbearia"
                />
                <Titulo>Barbearia</Titulo>
            </HStack>
            <HStack
                justifyContent="center"
            >
                <Titulo fontSize={30}>Olá, "USER"</Titulo>
                <Avatar
                    mt={2}
                    ml={5}
                    size="lg"

                />
            </HStack>
            <Titulo fontSize={20}>Selecione uma opção: </Titulo>

            <HStack
                flex={1}
                mt={10}
            >
                <BotaoComImagem
                    source={require("../assets/images/TesouraIcon.png")}
                    alt="Atendimento"
                    texto="Agendar"
                />
                <BotaoComImagem
                    source={require("../assets/images/BarbeiroIcon.png")}
                    alt="Barbeiros"
                    texto="Barbeiros"
                />
            </HStack>
            <HStack
                flex={1}
            >
                <BotaoComImagem
                    source={require("../assets/images/LocalizacaoIcon.png")}
                    alt="Localização"
                    texto="Localização"
                />
                <BotaoComImagem
                    source={require("../assets/images/ProdutoIcon.png")}
                    alt="Produtos e Serviços"
                    texto="Produtos"
                />
            </HStack>




        </VStack>
    );
}
