import { Button, HStack, ITextProps, Image, Text } from "native-base";
import { TEMAS } from "../estilos/tema";


interface BotaoProps {
    source?: any;
    alt?: string;
    texto?: string;
}




export default function BotaoComImagem({
    source,
    alt,
    texto,
    ...rest
}: BotaoProps): JSX.Element {
    return (
        <Button
            bgColor={TEMAS.colors.cinza.cinzaEscuro}
            borderRadius={10}
            shadow={10}
            width={150}
            height={150}
            flex={1}
            m={5}
            {...rest}

        >
            <HStack>
                <Image source={source} alt={alt} />
                <Text
                    color={TEMAS.body.corFonte}
                >{texto}</Text>
            </HStack>
        </Button>
    )

}