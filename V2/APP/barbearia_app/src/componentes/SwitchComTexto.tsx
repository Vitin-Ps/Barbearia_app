import { HStack, ITextProps, Switch, Text } from "native-base";
import { TEMAS } from "../estilos/tema";
import { ReactNode } from "react";

interface TextoProps extends ITextProps {
    children: ReactNode;
}

export function SwitchComTexto({ children, ...rest }: TextoProps) {
    return (
        <HStack
        alignItems="center"
            space={5}
            mt={5}
        >
            <Switch
                size="md"
                offTrackColor={TEMAS.colors.marrom.muitoClaro}
                onTrackColor={TEMAS.colors.marrom.normalClaro}
                onThumbColor={TEMAS.colors.marrom.normal}
                offThumbColor={TEMAS.colors.marrom.claro}
            />
            <Text
                color={TEMAS.colors.cinza.cinzaClaro}
                fontSize="18px"
                {...rest}
            >
                {children}
            </Text>
        </HStack>
    )
}