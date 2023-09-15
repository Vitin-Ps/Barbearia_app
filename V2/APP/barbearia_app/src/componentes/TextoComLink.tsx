import { Box, ITextProps, Text } from "native-base";
import { ReactNode } from "react";
import { TouchableOpacity } from "react-native";
import { TEMAS } from "../estilos/tema";


interface TextoProps extends ITextProps {
    children: ReactNode
}

export function TextoComLink({ children, ...rest }: TextoProps) {
    return (
        <Box
            w="100%"
            flexDirection="row"
            justifyContent="center"
            mt={8}
            {...rest}
        >
            <Text  color={TEMAS.colors.cinza.cinzaClaro}{...rest}>
                {children[0]}
            </Text>
            <TouchableOpacity>
                <Text
                    color={TEMAS.colors.marrom.normal}
                    {...rest}
                >
                    {children[1]}
                </Text>

            </TouchableOpacity>
        </Box>
    )
}