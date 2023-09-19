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
            m={5}
            p={5}
            width={100}
            height={100}
            flex={1}
            borderRadius={10}
            shadow={10}
            {...rest}

        >
            <Image source={source} alt={alt} m="auto" width={50} height={50}/>
            <Text
                m="auto"
                color={TEMAS.body.corFonte}
            >{texto}</Text>
        </Button>
    )

}