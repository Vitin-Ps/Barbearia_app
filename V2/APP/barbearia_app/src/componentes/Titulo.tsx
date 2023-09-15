import { ITextProps, Text } from "native-base";
import { ReactNode } from "react";
import { TEMAS } from "../estilos/tema";

interface TituloProps extends ITextProps {
    children: ReactNode
}

export function Titulo({ children, ...rest }: TituloProps) {
    return (
        <Text
            fontSize="50px"
            fontWeight="400"
            textAlign="center"
            color="white"
            mt={5}
            {...rest}
        >
            {children}
        </Text>
    )
}

