import { useState } from "react";
import { Icon, Input, Stack } from "native-base";
import { Pressable } from "react-native";
import Ionicons from "react-native-vector-icons/Ionicons";
import { TEMAS } from "../estilos/tema";

interface InputProps {
    icon?: string;
    color?: string;
    placeholder: string;
}

export function EntradaSenha({
    placeholder,
}: InputProps): JSX.Element {
    
    const [show, setShow] = useState(false); // Estado para controlar a visibilidade da senha

    return (
        <Stack space={4} width="100%" alignItems="center">
            <Input
                mt={5}
                fontSize="20px"
                fontWeight="400"
                width="100%"
                bgColor={TEMAS.colors.cinza.cinzaEscuro}
                color="white"
                shadow={3}
                type={show ? "text" : "password"}
                InputLeftElement={
                    <Pressable onPress={() => setShow((prevShow) => !prevShow)}>
                        <Icon
                            as={
                                <Ionicons name={show ? "eye-off" : "eye"} />
                            }
                            size={7}
                            ml={2}
                            color={TEMAS.colors.marrom.normal}
                        />
                    </Pressable>
                }
                placeholder={placeholder}
            />
        </Stack>
    );
}
