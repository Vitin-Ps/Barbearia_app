import { Image, ScrollView, Text, VStack, HStack, Avatar, Button } from "native-base";
import Logo from "../assets/images/Logo.png";

import { TEMAS } from "../estilos/tema";
import { Titulo } from "../componentes/Titulo";
import BotaoComImagem from "../componentes/BotaoComImagem";

export default function Home() {
    return (
        <ScrollView flex={1} backgroundColor={TEMAS.colors.cinza.cinzaBlack}>
            <VStack ml={3}>
                <HStack p={5} flex={1} alignItems="center">
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
                    />
                    <BotaoComImagem
                        source={require("../assets/images/BarbeiroIcon.png")}
                        alt="Barbeiros"
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
                    />
                </HStack>




            </VStack>
        </ScrollView>
    );
}
